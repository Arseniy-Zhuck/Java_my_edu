import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Home> homeList = new ArrayList<>();
        homeList.add(new Home());
        homeList.add(new Home(300));
        homeList.add(new Home(400, 500));
        for (int i = 0; i < 3; i++) {
            System.out.println("Home № " + i + ": " + homeList.get(i));
        }
    }

    static class Home{
        private final int width;
        private final int height;

        public Home() {
            width = 100;
            height = 200;
        }

        public Home(int width) {
            this.width = width;
            this.height = width;
        }

        public Home(int height, int width) {
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return String.format("Width = %d, height = %d", this.width, this.height);
        }
    }
}
