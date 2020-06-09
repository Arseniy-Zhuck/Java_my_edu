package core.model.list;

import core.model.example.Cat;

public interface CatCollection {
    Cat getCurrentCat();
    boolean hasCurrentCat();
    void nextCat();
    void addCat(Cat cat);
    void deleteCat(Cat cat);
    void deleteCat(int catIndex);
    Cat getCatByIndex(int index);
    int getIndexByCat(Cat cat);
    void setCurrentCat(Cat cat);
    void setCurrentCat(int catIndex);
    Cat firstCat();
    int getCatCount();
    void showCats();

}
