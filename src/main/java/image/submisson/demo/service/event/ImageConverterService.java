package image.submisson.demo.service.event;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageConverterService {

  public byte[] convert(MultipartFile image) {

    try {

      BufferedImage originalImage = ImageIO.read(image.getInputStream());

      if (originalImage == null) {

        throw new ImageProcessingException("Image invalide");
      }

      BufferedImage blackWhiteImage =
          new BufferedImage(
              originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

      Graphics2D graphics = blackWhiteImage.createGraphics();

      graphics.drawImage(originalImage, 0, 0, null);

      graphics.dispose();

      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

      ImageIO.write(blackWhiteImage, getExtension(image), outputStream);

      return outputStream.toByteArray();

    } catch (Exception e) {

      throw new ImageProcessingException("Erreur lors de la conversion de l'image");
    }
  }

  private String getExtension(MultipartFile image) {

    String filename = image.getOriginalFilename();

    if (filename == null || !filename.contains(".")) {

      return "png";
    }

    return filename.substring(filename.lastIndexOf(".") + 1);
  }

  private static class ImageProcessingException extends RuntimeException {

    public ImageProcessingException(String message) {

      super(message);
    }
  }
}
