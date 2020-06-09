package core.view.term;

import core.conroller.CatShelter;
import core.conroller.State;
import core.conroller.WhiteState;
import java.io.IOException;
import static java.lang.System.out;


public class MainProg extends AbstractTerm {

    private MainProg(CatShelter catShelter){
        super(catShelter);
    }

    private String hello() {
        return "Wellcome to our CatShelter \"SkillBox\" with dark and black sides\n" +
                "Here you can give homeless cats and give a new home for one of our cats\n" +
                "We are java developers, so we are very clever\n" +
                "That's why here you can pay for clone of your cat\n" +
                "And here you can free your inner Sharikov\n";
    }

    protected String showCommands() {
        return "So, what do you want?\n" +
                "1. See all our cats\n" +
                "2. See all given cats\n" +
                "3. Visit the place of memory\n" +
                "4. Get to the other side\n" +
                "5. Leave us";
    }

    @Override
    protected void setStrategy() {

    }

    protected void doJob(int choice) throws IOException {
        switch (choice) {
            case 1: catShelter.showOurCats(); break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            default:
                out.println("Wrong command");
                run();
        }
    }

    public static void main(String[] args) throws IOException {
        CatShelter catShelter = CatShelter.getInstance();
        MainProg mP = new MainProg(catShelter);
        State whiteState = new WhiteState(catShelter);
        catShelter.setState(whiteState);
        catShelter.setMainProg(mP);
        out.println(mP.hello());
        mP.run();
    }
}
