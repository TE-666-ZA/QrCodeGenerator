import code.QrCodeGenerator;

public class RunQrSimpleCreation {

  private static final String QR_CODE_IMAGE_PATH = "src/main/java/res/MyQRCode.png";

  public static void main(String[] args) {

    QrCodeGenerator.generateQRCodeImage("Hello, World!", 0, 0, QR_CODE_IMAGE_PATH);

  }

}

