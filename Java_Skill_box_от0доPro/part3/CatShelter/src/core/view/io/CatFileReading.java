package core.view.io;

import core.model.example.Cat;
import core.model.list.CatCollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CatFileReading {
    public CatCollection catCollection;

    public CatFileReading(CatCollection catCollection) {
        setCatCollection(catCollection);
    }

    public CatCollection getCatCollection() {
        return catCollection;
    }

    public void setCatCollection(CatCollection catCollection) {
        this.catCollection = catCollection;
    }

    public void readCats(String fileName) throws IOException {
        File file = new File(fileName);
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = reader.readLine();
        while (line != null) {
            String[] lines = line.split(" ");
            catCollection.addCat(new Cat(Double.parseDouble(lines[2]),lines[1]));
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
    }
}
