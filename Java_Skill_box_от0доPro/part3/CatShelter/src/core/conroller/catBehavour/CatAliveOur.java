package core.model.example;

public class CatAliveOur implements CatState{
    private Cat cat;
    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toStr() {
        return null;
    }
}
