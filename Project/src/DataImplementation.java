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
        try {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
            
            File f = new File(filename);
            ImageIO.write(bufferedImage, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] openImage(String filename) throws RemoteException {
        try {
            File f = new File(filename);
            BufferedImage image = ImageIO.read(f);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", output);

            return output.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Override
    public String teste(String msg) throws RemoteException {
        return "Servidor: " + msg;
    }
}