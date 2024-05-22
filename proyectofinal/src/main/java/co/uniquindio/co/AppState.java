package co.uniquindio.co;

import java.util.ArrayList;
import java.util.List;

import co.uniquindio.Logica.ImageData;

public class AppState {
    private static AppState instance;
    private List<ImageData> imageList;

    private AppState() {
        imageList = new ArrayList<>();
    }

    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
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
