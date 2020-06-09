package core.view.term;

import core.conroller.CatShelter;
import core.conroller.Strategy;
import core.model.list.CatCollection;
import core.view.io.SimpleReading;

import java.io.IOException;

public class ListCatTerm extends AbstractTerm implements Strategy{
    private CatCollection catCollection;
    private Strategy strategy;


    public ListCatTerm(CatCollection catCollection, CatShelter catShelter) {
        super(catShelter);
        this.catCollection = catCollection;
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
    public String showCommands() {
        return strategy.showCommands();

    }

    @Override
    protected void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doJob(int choice) {
        strategy.doJob(choice);
    }
}
