import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class lowcode {
    public static void main(String[] args) {
        File name = new File("C:\\Users\\Paul\\Pictures\\testimage\\1200px-Sunflower_from_Silesia2.jpg");
        File name2 = new File("C:\\Users\\Paul\\Pictures\\testimage\\compression.jpg");
        try {
            ImageCompressora(name, name2, 0.2f);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void ImageCompressora(File originalI, File compressI, float Quality) throws IOException {
        RenderedImage Oimage = ImageIO.read(originalI);
        ImageWriter jpegW = ImageIO.getImageWritersByFormatName("jpg").next();
        ImageWriteParam jpegWP = jpegW.getDefaultWriteParam();
        jpegWP.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpegWP.setCompressionQuality(Quality);

        try (ImageOutputStream output = ImageIO.createImageOutputStream(compressI)) {
            jpegW.setOutput(output);
            IIOImage outpuI = new IIOImage(Oimage, null, null);
            jpegW.write(null, outpuI, jpegWP);
        }
        jpegW.dispose();
    }
}
