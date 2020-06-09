import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother);

        System.out.println(catMother);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother) {
            this(name);
            this.mother = mother;
        }

        Cat(String name, Cat mother, Cat father) {
            this(name, mother);
            this.father = father;
        }


        @Override
        public String toString() {
            String start = "The cat's name is ";
            String mother = this.mother!=null ? ", mother is "+this.mother.name : ", no mother";
            String father = this.father!=null ? ", father is "+this.father.name : ", no father";
            return start+this.name+mother+father;
        }
    }

}
