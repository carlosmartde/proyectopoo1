package org.example;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String filename = "credenciales.txt";
        CredentialManager credentialManager = new CredentialManager(filename);
        System.out.print("Ingrese su nombre de usuario: ");
        String username = entrada.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = entrada.nextLine();
        if (credentialManager.validateLogin(username, password)) {
            System.out.println("Inicio de sesión exitoso.");
            String code = generateRandomCode(6); // Genera un código aleatorio de 6 dígitos
            String filePath = "QRCode.png";
            int width = 300;
            int height = 300;
            String fileType = "png";
            try {
                generateQRCode(code, filePath, width, height, fileType);
                System.out.println("Código QR generado exitosamente.");
            } catch (WriterException | IOException e) {
                System.out.println("Error al generar el código QR: " + e.getMessage());
            }

            // Simulación de ingreso del código por parte del usuario
            System.out.print("Ingrese el código de autenticación: ");
            String inputCode = entrada.nextLine();

            if (inputCode.equals(code)) {
                System.out.println("Acceso concedido.");
                Menu menu = new Menu();
                menu.mostrarMenu();
            } else {
                System.out.println("Código incorrecto. Acceso denegado.");
            }
            /*Menu menu = new Menu();
            menu.mostrarMenu();*/
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }

        entrada.close();
    }

    private static String generateRandomCode(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(random.nextInt(10)); // Genera un número aleatorio entre 0 y 9
        }
        return code.toString();
    }

    private static void generateQRCode(String data, String filePath, int width, int height, String fileType) throws WriterException, IOException {
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, fileType, path);
    }
}