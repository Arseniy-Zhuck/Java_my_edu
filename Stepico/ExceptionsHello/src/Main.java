public class Main {
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        MainClass.Beh1 b =(MainClass.Beh1) mainClass.getBehaviour();
    }

    static class MainClass {
        private Beh behaviour;

        public MainClass() {
            this.behaviour = new Beh2();
        }

        public Beh getBehaviour() {
            return behaviour;
        }

        class Beh2 implements Beh {

            @Override
            public void doIt() {

            }

            @Override
            public void makeIt() {

            }
        }



        class Beh1 implements Beh {

            @Override
            public void doIt() {

            }

            @Override
            public void makeIt() {

            }
        }
    }

}
