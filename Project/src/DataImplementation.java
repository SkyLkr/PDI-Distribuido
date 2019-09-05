import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;

public class DataImplementation implements DataInterface, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void saveImage(byte[] image, String filename) throws RemoteException {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
            ImageSaver saver = new ImageSaver();
            saver.saveImage(bufferedImage, "images/" + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public String teste(String msg) throws RemoteException {
        return "Servidor: " + msg;
    }
}