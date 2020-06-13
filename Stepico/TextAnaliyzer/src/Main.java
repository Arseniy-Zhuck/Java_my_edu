public class Main {
    public static void main(String[] args) {

    }
    public enum Label {
        SPAM,
        NEGATIVE_TEXT,
        TOO_LONG,
        OK
    }
    public interface TextAnalyzer {
        Label processText(String text);
    }

    abstract class KeywordAnalyzer implements TextAnalyzer{
        protected abstract String[] getKeywords();
        protected abstract Label getLabel();
        @Override
        public Label processText(String text){
            boolean res = true;
            for (String keyWord: getKeywords())
                res = res && (!text.contains(keyWord));
            return res ? Label.OK : getLabel();
        }
    }
    class SpamAnalyzer extends KeywordAnalyzer{
        private String[] keywords;
        protected SpamAnalyzer(String[] keyWords) {
            this.keywords = keyWords;
        }
        @Override
        protected String[] getKeywords() {
            return keywords;
        }
        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }
    class NegativeTextAnalyzer extends KeywordAnalyzer {
        private String[] keywords;
        @Override
        protected String[] getKeywords() {
            return keywords;
        }
        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    class TooLongTextAnalyzer implements TextAnalyzer{
        private int maxLength;
        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }
        @Override
        public Label processText(String text) {
            boolean res = text.length()<=maxLength;
            return res ? Label.OK : Label.TOO_LONG;
        }
    }
}
