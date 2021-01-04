import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        Path path = file.toPath();
    }
}
