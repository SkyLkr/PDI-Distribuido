import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSaver {
    public void saveImage(BufferedImage image, String path) {
        try {
            File f = new File(path);
            f.mkdirs();
            ImageIO.write(image, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}