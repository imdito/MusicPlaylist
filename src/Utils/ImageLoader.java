package Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.URL;
import java.net.URI;
import java.net.URLConnection;
import java.io.InputStream;
public class ImageLoader {

   public static ImageIcon loadImageAndScale(String imageUrl, int targetWidth, int targetHeight) {
        try {
            if (imageUrl == null || imageUrl.trim().isEmpty()) return null;

            URI uri = new URI(imageUrl);
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // Trik User-Agent
            InputStream inputStream = connection.getInputStream();
            BufferedImage originalImage = ImageIO.read(inputStream);
            inputStream.close();

            if (originalImage != null) {
                // ... (logika scaleImage Anda di sini) ...
                Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
                return new ImageIcon(resultingImage);
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat & scale gambar: " + imageUrl);
            e.printStackTrace();
        }
        return null;
    }

    private static ImageIcon scaleImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        // Hitung rasio skala untuk lebar dan tinggi
        double scaleX = (double) targetWidth / originalWidth;
        double scaleY = (double) targetHeight / originalHeight;

        // Gunakan rasio yang lebih kecil agar seluruh gambar pas dan tidak terpotong (letterboxing)
        double scale = Math.min(scaleX, scaleY);

        // Hitung lebar dan tinggi baru berdasarkan rasio skala
        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);

        // Buat gambar baru dengan ukuran yang sudah dihitung
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(resultingImage);
    }
}