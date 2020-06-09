package core.view.term;

import core.conroller.CatShelter;
import core.conroller.Strategy;
import core.view.io.SimpleReading;

import java.io.IOException;

import static java.lang.System.out;

public abstract class AbstractTerm {
    protected abstract String showCommands();
    protected CatShelter catShelter;
    protected abstract void setStrategy(Strategy strategy);

    public AbstractTerm(CatShelter catShelter) {
        this.catShelter = catShelter;
    }

    private int getChoice() throws IOException {
        return SimpleReading.readInteger();
    }

    protected abstract void doJob(int choice) throws IOException;

    public void run() throws IOException {
        out.println(showCommands());
        doJob(getChoice());
    }
}
