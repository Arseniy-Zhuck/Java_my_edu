package core.view.term;

import core.conroller.Strategy;
import core.model.list.CatCollection;
import core.view.io.SimpleReading;

import java.io.IOException;

public class listCatTerm implements Strategy{
    private CatCollection catCollection;
    private Strategy strategy;


    public listCatTerm(CatCollection catCollection, Strategy strategy) {
        this.catCollection = catCollection;
        this.strategy = strategy;
    }

    public void showCats() {

    }

    private int getChoice() throws IOException {
        return SimpleReading.readInteger();
    }


    public void run() {
        showCats();
        showCommands();

    }


    @Override
    public void showCommands() {
        strategy.showCommands();
    }

    @Override
    public void doJob(int choice) {
        strategy.doJob(choice);
    }
}
