import code.QrCodeGenerator;

public class RunQrSimpleCreation {

  private static final String QR_CODE_PATH = "src/main/java/res/QRCode.png";
  private static final String QR_CODE_LOGO_PATH = "src/main/java/res/QrCodeLogo.png";

  public static void main(String[] args) {

    QrCodeGenerator qrCodeGenerator = new QrCodeGenerator();
    String text = "https://github.com/TE-666-ZA/QrCodeGenerator";


   qrCodeGenerator.generateQRCode(text,450,QR_CODE_PATH,
       "src/main/java/res/QrCodeLogo.png");

  }

}

