package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {
    @Test
    void test(){
        try {
            BufferedImage image = ImageIO.read(new File("/Users/weichangda/Desktop/txkt/learn/tank/tank/src/images/bulletD.gif"));
            assertNotNull(image);
            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
