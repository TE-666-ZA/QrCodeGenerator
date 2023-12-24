import code.QrCodeGenerator;

public class RunQrSimpleCreation {

  private static final String QR_CODE_IMAGE_PATH = "src/main/java/res/QRCode.png";

  public static void main(String[] args) {

    String text = "https://github.com/TE-666-ZA/QrCodeGenerator";

    QrCodeGenerator.generateQRCodeImage(text, 300, 300, QR_CODE_IMAGE_PATH);

  }

}

