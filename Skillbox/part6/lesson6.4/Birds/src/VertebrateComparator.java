import java.util.Comparator;

public class VertebrateComparator implements Comparator<Vertebrate> {
    @Override
    public int compare(Vertebrate o1, Vertebrate o2) {
        return (int) Math.round(o1.getWeight() - o2.getWeight());
    }
}
