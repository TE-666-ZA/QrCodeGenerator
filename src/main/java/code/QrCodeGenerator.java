package code;

import static javax.imageio.ImageIO.read;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class QrCodeGenerator {


  public void generateQRCode(String text, int size, String qrCodePath){
    BufferedImage qrImage = createQrImage(text,size);
    saveQrCode(qrImage,qrCodePath);
  }
  public void generateQRCode(String text, int size, String qrCodePath,String logoPath){
    BufferedImage qrImage = createQrImage(text,size);
    qrImage = addLogo(qrImage,logoPath);
    saveQrCode(qrImage,qrCodePath);
  }


  public BufferedImage createQrImage(String text, int size) {
    try {
      Map<EncodeHintType, Object> hintMap = new HashMap<>();
      hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

      BitMatrix bitMatrix = new MultiFormatWriter().encode
          (text, BarcodeFormat.QR_CODE,
              size,size, hintMap);

      BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
      return qrImage;

    }catch (WriterException e ){
      throw new RuntimeException(e);
    }

  }

  public BufferedImage addLogo(BufferedImage qrImage, String logoPath) {
   try {

     int targetLogoWidth = qrImage.getWidth() / 6;
     int targetLogoHeight = qrImage.getHeight() / 6;
     Image logo = ImageIO.read(new File(logoPath));
     logo = logo.getScaledInstance(targetLogoWidth, targetLogoHeight, Image.SCALE_SMOOTH);

     int logoX = (qrImage.getWidth() - targetLogoWidth) / 2;
     int logoY = (qrImage.getHeight() - targetLogoHeight) / 2;

     Graphics2D graphics = qrImage.createGraphics();
     graphics.drawImage(logo, logoX, logoY, targetLogoWidth, targetLogoHeight, null);
     graphics.dispose();

     return qrImage;

   }catch (IOException e ){
     throw new RuntimeException(e);
   }
  }

  private void saveQrCode(BufferedImage qrImage, String qrCodePath){

    try {
      ImageIO.write(qrImage, "PNG", new File(qrCodePath));
      System.out.println("QR code successfully generated");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
