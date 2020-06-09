package core.conroller;

import core.view.term.ListCatTerm;

public class AliveStrategy implements Strategy {
    private ListCatTerm listCatTerm;

    public AliveStrategy(ListCatTerm listCatTerm) {
        this.listCatTerm = listCatTerm;
    }

    @Override
    public void showCommands() {

    }

    @Override
    public void doJob(int choice) {

    }
}
