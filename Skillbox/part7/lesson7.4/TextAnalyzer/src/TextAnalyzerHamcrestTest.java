import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextAnalyzerHamcrestTest {
    @Test
    public void getWords_SimpleWord_Test() {
        TextAnalyzer textAnalyzer = new TextAnalyzer("Simple");
        ArrayList<String> actualWords;
        ArrayList<String> expectedWords = new ArrayList<>();

        actualWords = textAnalyzer.getWords();
        expectedWords.add("simple");

        assertThat(actualWords, equalTo(expectedWords));
    }

    @Test
    public void getWords_Sentence_Test() {
        TextAnalyzer textAnalyzer = new TextAnalyzer("Here we have simple sentence, you won't see anything else!");
        ArrayList<String> actualWords;
        ArrayList<String> expectedWords = new ArrayList<>();

        actualWords = textAnalyzer.getWords();
        expectedWords.add("here");
        expectedWords.add("we");
        expectedWords.add("have");
        expectedWords.add("simple");
        expectedWords.add("sentence");
        expectedWords.add("you");
        expectedWords.add("won't");
        expectedWords.add("see");
        expectedWords.add("anything");
        expectedWords.add("else");

        assertThat(actualWords, equalTo(expectedWords));
    }

    @Test
    public void getWords_ManySentences_Test() {
        TextAnalyzer textAnalyzer = new TextAnalyzer("Here we have two sentences. You won't see anything else!");
        ArrayList<String> actualWords;
        ArrayList<String> expectedWords = new ArrayList<>();

        actualWords = textAnalyzer.getWords();
        expectedWords.add("here");
        expectedWords.add("we");
        expectedWords.add("have");
        expectedWords.add("two");
        expectedWords.add("sentences");
        expectedWords.add("you");
        expectedWords.add("won't");
        expectedWords.add("see");
        expectedWords.add("anything");
        expectedWords.add("else");

        assertThat(actualWords, equalTo(expectedWords));
    }

    @Test
    public void getMostFrequentWord_SimpleWord_Text() {
        TextAnalyzer textAnalyzer = new TextAnalyzer("Simple");
        String actualMostFrequentWord;
        String expectedMostFrequentWord;

        actualMostFrequentWord = textAnalyzer.getMostFrequentWord();
        expectedMostFrequentWord = "simple";

        assertThat(actualMostFrequentWord, equalTo(expectedMostFrequentWord));
    }

    @Test
    public void getMostFrequentWord_AllDifferentWords_Test() {
        TextAnalyzer textAnalyzer = new TextAnalyzer("Simple sentence with different words");
        String actualMostFrequentWord;
        String expectedMostFrequentWord;

        actualMostFrequentWord = textAnalyzer.getMostFrequentWord();
        expectedMostFrequentWord = "simple";

        assertThat(actualMostFrequentWord, equalTo(expectedMostFrequentWord));
    }

    @Test
    public void getMostFrequentWord_BigText() {
        TextAnalyzer textAnalyzer = new TextAnalyzer("Simple sentence with different words.\n" +
                "And then more and more and more sentences.\n" +
                "And so on and on");
        String actualMostFrequentWord;
        String expectedMostFrequentWord;

        actualMostFrequentWord = textAnalyzer.getMostFrequentWord();
        expectedMostFrequentWord = "and";

        assertThat(actualMostFrequentWord, equalTo(expectedMostFrequentWord));
    }

}
