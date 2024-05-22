package co.uniquindio.co;

import java.util.ArrayList;
import java.util.List;

import co.uniquindio.Logica.ImageData;

public class AppStateCarro {

    private static AppStateCarro instance;
    private List<ImageData> imageList;

    public AppStateCarro() {
        imageList = new ArrayList<>();
    }

    public static AppStateCarro getInstance() {
        if (instance == null) {
            instance = new AppStateCarro();
        }
        return instance;
    }

    public List<ImageData> getImageList() {
        return imageList;
    }

    public void addImageData(ImageData imageData) {
        imageList.add(imageData);
    }

}
