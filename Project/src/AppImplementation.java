import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;

public class AppImplementation implements AppInterface, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8199114052752054623L;

    @Override
    public byte[] applyFilter(byte[] img) throws RemoteException {
        byte[] filterImg = null;
        try {

            System.out.println("Recebendo imagem");

            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(img));

            int height = bufferedImage.getHeight();
            int width = bufferedImage.getWidth();
            
            System.out.println("Convertendo para tons de cinza");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(bufferedImage.getRGB(j, i));

                    int red = (int) (c.getRed() * 0.2125);
                    int green = (int) (c.getGreen() * 0.7154);
                    int blue = (int) (c.getBlue() * 0.0721);

                    int gray = red + green + blue;

                    Color newColor = new Color(gray, gray, gray);

                    bufferedImage.setRGB(j, i, newColor.getRGB());
                }
            }

            System.out.println("Imagem convertida");
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", output);

            filterImg = output.toByteArray();

            long time = System.currentTimeMillis();
            System.out.println("Salvando Imagem na base de dados com o código " + time);
            data.saveImage(img, Long.toString(time) + "_normal.jpg");
            data.saveImage(filterImg, Long.toString(time) + "_filter.jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return filterImg;
    }

    @Override
    public String test(String msg) throws RemoteException {
        return "Server: " + msg;
    }

    private DataInterface data;

    public AppImplementation() {
        try {
            data = (DataInterface) Naming.lookup("rmi://192.168.43.125/DataServer");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}