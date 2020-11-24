package task19;

import task19.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) throws IllegalArgumentException{
        ImageReader reader = null;
        if(type == ImageTypes.BMP){
            reader = new BmpReader();
        } else if(type == ImageTypes.JPG) {
            reader = new JpgReader();
        } else if(type == ImageTypes.PNG){
            reader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
