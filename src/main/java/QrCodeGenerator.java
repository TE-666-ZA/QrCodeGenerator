import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QrCodeGenerator {


   static void generateQRCodeImage(String text, int width, int height, String filePath) {
    try {

      Map<EncodeHintType, Object> hintMap = new HashMap<>();
      hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

      BitMatrix bitMatrix = new MultiFormatWriter().encode
          (text, BarcodeFormat.QR_CODE,
              width,height, hintMap);

      Path path = FileSystems.getDefault().getPath(filePath);
      MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

      System.out.println("QR code successfully generated");
    }catch (WriterException | IOException e ){
      throw new RuntimeException(e);
    }

  }
}
