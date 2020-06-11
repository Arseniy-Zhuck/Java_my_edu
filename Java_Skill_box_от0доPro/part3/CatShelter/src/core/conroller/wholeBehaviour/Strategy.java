package core.conroller;

import core.view.term.AbstractTerm;

public interface Strategy {

    public String showCommands();
    public void doJob(int choice);
    public void noCats();

}
