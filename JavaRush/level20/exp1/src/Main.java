import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/regions.txt";
        String tagToSearch = "tag";


        String allTags = "";
        FileReader fileReader = new FileReader(fileName);
        while (fileReader.ready()) {
            int s = fileReader.read();
            allTags += (char) s;
        }
        fileReader.close();

        MyTree myTree = new MyTree(allTags);
        MyTag myTag = new MyTag(tagToSearch, null);
        while (myTree.hasNext()) {
            MyTag currentTag = myTree.next();
            if (myTag.equals(currentTag))
                System.out.println(currentTag);
        }
    }

    public static class MyTree {
        private MyTag root;
        private MyTag currentTag;
        private MyTag prevTag = null;

        public MyTree(String s) {
            root = new MyTag("root",null);
            root.setContent(s);
            root.buildChildren();
            reStart();
        }

        public boolean hasNext() {
            return currentTag != null;
        }

        public MyTag next() {
            MyTag result = currentTag;
            if (currentTag.getChildren() != null) {
                currentTag = currentTag.getChildren().get(0);
            } else {
                boolean flag = true;
                MyTag cur = currentTag.getPrev();
                while (flag) {
                    if (cur == null) {
                        currentTag = null;
                        flag = false;
                    }
                    else {
                        int k = cur.getChildren().indexOf(currentTag);
                        if (k < cur.getChildren().size() - 1) {
                            flag = false;
                            currentTag = cur.getChildren().get(k + 1);
                        } else {
                            cur = cur.getPrev();
                            currentTag = currentTag.getPrev();
                        }
                    }
                }
            }
            return result;
        }

        public void reStart() {
            currentTag = root.getChildren().get(0);
            prevTag = null;
        }
    }

    public static class MyString {
        private String s;

        public MyString(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }
    }

    public static class MyTag {
        private String name;
        private String params = null;
        private ArrayList<MyTag> innerTags = null;
        private String content;
        private MyTag prev;


        public ArrayList<MyTag> getChildren() {
            return innerTags;
        }

        public String getName() {
            return this.name;
        }

        public static MyTag getFirstTagFromString(MyString s, MyTag prev) {
            MyTag currentTag = null;
            String lastStringToAnalyze = "";
            if (s.getS().indexOf("<") >= 0) {
                String nameToParse = s.getS().substring(s.getS().indexOf("<"), 1 + s.getS().indexOf(">", s.getS().indexOf("<")));
                currentTag = new MyTag(nameToParse);
                String withoutName = s.getS().substring(s.getS().indexOf(nameToParse)).replaceFirst(nameToParse, "");
                int innerThisTagCount = 1;
                String currentString = withoutName;
                int open = -1;
                int close = -1;
                while (innerThisTagCount != 0) {
                    open = currentString.indexOf("<" + currentTag.getName());
                    close = currentString.indexOf("</" + currentTag.getName());
                    if (open < close && open != -1) {
                        innerThisTagCount++;
                        currentString = currentString.substring(open + currentTag.getName().length() + 2);
                    }
                    else {
                        innerThisTagCount--;
                        currentString = currentString.substring(close + currentTag.getName().length() + 3);
                    }
                }
                String content =
                        currentString.equals("") ?
                                withoutName.substring(0,withoutName.length() - 3 - currentTag.getName().length()) :
                                withoutName.substring(0, withoutName.indexOf(currentString) - 3 - currentTag.getName().length());
                currentTag.setContent(content);
                lastStringToAnalyze = currentString;
                currentTag.setPrev(prev);
            }
            s.setS(lastStringToAnalyze);
            return currentTag;
        }

        public void buildChildren() {
            MyString currentString = new MyString(this.content);
            while (true) {
                MyTag currentTag = MyTag.getFirstTagFromString(currentString, this);
                if (currentTag == null) break;
                currentTag.buildChildren();
                addChild(currentTag);
            }
        }

        private MyTag(String openTag) {
            String s = openTag.replaceAll("[<>]", "");
            String[] lines = s.split("[\\n|[\\s|[\\t|[\\r]]]]+",2);
            name = lines[0];
            if (lines.length > 1) params = lines[1];
        }

        public MyTag(String name, String params) {
            this.name = name;
            this.params = params;
            this.prev = null;
        }

        private void addChild(MyTag myTag) {
            if (innerTags == null) {
                innerTags = new ArrayList<>();
            }
            innerTags.add(myTag);
        }

        @Override
        public String toString() {
            String result = String.format("<%s", this.name);
            result = params == null ? result + ">" : result + " " + params + ">";
            result += content.replaceAll("[\\n|[\\t|[\\r]]]", "");
            result+="</" + name + ">";
            return result;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyTag) {
                return this.name.equals(((MyTag) obj).getName()) && (this.content == null || this.content.equals(((MyTag) obj).getContent()));
            } else return false;
        }

        private String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public MyTag getPrev() {
            return prev;
        }

        public void setPrev(MyTag prev) {
            this.prev = prev;
        }
    }

}
