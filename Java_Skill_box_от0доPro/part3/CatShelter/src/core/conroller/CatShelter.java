package core.conroller;

import core.model.list.CatArray;
import core.model.list.CatArrayList;
import core.view.io.CatFileReading;

import java.io.IOException;

public class CatShelter {
    // константы класса
    private static final int MAX_CAT_COUNT = 10;

    // переменные класса
    private static CatShelter instance;


    // переменные объекта
    private CatArray ourCats = new CatArray(MAX_CAT_COUNT);
    private CatArrayList givenCats,deadCats;
    private State state;
    private String ourCatsPath,givenCatsPath,deadCatsPath;
    // методы класса

    public static CatShelter getInstance() throws IOException {
        if (instance==null) instance = new CatShelter();
        return instance;
    }

    public void showOurCats(){

    }


    // конструкторы
    private CatShelter() throws IOException {
        initialize();
    }
    // методы объекта

    private void setFilePaths() {
        this.ourCatsPath = "AliveCats.txt";
    }

    private void initialize() throws IOException {
        ourCats = new CatArray(MAX_CAT_COUNT);
        givenCats = new CatArrayList(MAX_CAT_COUNT);
        deadCats = new CatArrayList(MAX_CAT_COUNT);
        setFilePaths();
        CatFileReading catFileReading = new CatFileReading(ourCats);
        catFileReading.readCats(ourCatsPath);
        ourCats = (CatArray) catFileReading.getCatCollection();
        catFileReading.setCatCollection(givenCats);
        catFileReading.readCats(givenCatsPath);
        givenCats = (CatArrayList) catFileReading.getCatCollection();
        catFileReading.setCatCollection(deadCats);
        catFileReading.readCats(deadCatsPath);
        deadCats = (CatArrayList) catFileReading.getCatCollection();
    }

    public void setState(State state) {
        this.state = state;
    }
}
