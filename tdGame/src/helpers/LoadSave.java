package helpers;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {

    //FUNCTIONS
    public static BufferedImage loadImg(final String path) {

        final InputStream is = LoadSave.class.getClassLoader().getResourceAsStream(path);
        BufferedImage img = null;

        try {

            img = ImageIO.read(is);

        } catch (final Exception e) {

            e.printStackTrace();

        }

        return img;

    }

}
