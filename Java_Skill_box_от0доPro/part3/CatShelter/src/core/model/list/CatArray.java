package core.model.list;

import core.model.example.Cat;

public class CatArray implements CatCollection {

    private int maxCats;
    private int catCount;
    private Cat[] cats;
    private int currentCatIndex;

    public CatArray(int maxCats) {
        this.maxCats = maxCats;
        this.cats = new Cat[maxCats];
        this.currentCatIndex = -1;
        this.catCount = 0;
    }
    @Override
    public int getIndexByCat(Cat cat) {
        int i = 0;
        while ((i<catCount)&&(!cats[i].equals(cat))) i++;
        return i==catCount ? -1 : i;
    }

    @Override
    public void setCurrentCat(Cat cat) {
        currentCatIndex = getIndexByCat(cat);
    }

    @Override
    public void setCurrentCat(int catIndex) {
        currentCatIndex = catIndex;
    }

    @Override
    public Cat firstCat() {
        currentCatIndex = 0;
        return cats[0];
    }

    @Override
    public int getCatCount() {
        return catCount;
    }

    @Override
    public void showCats() {

    }

    @Override
    public Cat getCurrentCat() {
        return currentCatIndex<catCount ? cats[currentCatIndex] : null;
    }

    @Override
    public boolean hasCurrentCat() {
        return (currentCatIndex<catCount)&&(catCount>0);
    }

    @Override
    public void nextCat() {
        currentCatIndex++;
    }

    @Override
    public void deleteCat(Cat cat) {
        deleteCat(getIndexByCat(cat));
    }

    @Override
    public void deleteCat(int catIndex) {
        setCurrentCat(firstCat());
        for (int i = catIndex; i < catCount; i++) cats[i] = cats[i+1];
        cats[catCount--] = null;
    }

    @Override
    public Cat getCatByIndex(int index) {
        currentCatIndex = index;
        return cats[index];
    }

    @Override
    public void addCat(Cat cat) {
        if (catCount<maxCats) cats[catCount++] = cat;
        setCurrentCat(cat);
    }

}
