package com.chriso.wordsquare.selector;

import com.chriso.wordsquare.dictionary.cache.DictionaryCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WordSelectorTest {

    private DictionaryCache cache;

    public static final String DICTIONARY_PATH = "src/main/resources/dictionary.txt";

    @BeforeEach
    public void setup() {
        cache = new DictionaryCache(DICTIONARY_PATH);
        assertNotNull(cache);
    }

    @Test
    public void testThreeByThreeWithEasyData() {
        String characters = "aaccrrtty"; // for act, car, try

        LinkedList<String> candidateWords = cache.loadFor(3, characters);
        assertThat(candidateWords.size()).isGreaterThan(2);

        WordSelector selector = new WordSelector(candidateWords, characters);
        assertNotNull(selector);

        Deque<String> chosenWords = selector.SelectWords();

        assertThat(chosenWords.size()).isEqualTo(3);
        assertThat(chosenWords.pop()).isEqualTo("act");
        assertThat(chosenWords.pop()).isEqualTo("car");
        assertThat(chosenWords.pop()).isEqualTo("try");
    }

    @Test
    public void testFourByFour() {
        String characters = "eeeeddoonnnsssrv"; // for rose, oven, send, ends

        LinkedList<String> candidateWords = cache.loadFor(4, characters);
        assertThat(candidateWords.size()).isGreaterThan(3);

        WordSelector selector = new WordSelector(candidateWords, characters);
        assertNotNull(selector);

        Deque<String> chosenWords = selector.SelectWords();
        assertThat(chosenWords.size()).isEqualTo(4);
        for (String chosenWord : chosenWords) {
            System.out.println(chosenWord);
        }
        assertThat(chosenWords.pop()).isEqualTo("rose");
        assertThat(chosenWords.pop()).isEqualTo("oven");
        assertThat(chosenWords.pop()).isEqualTo("send");
        assertThat(chosenWords.pop()).isEqualTo("ends");
    }

    @Test
    public void testThreeByThreeWithImpossibleData() {
        String characters = "aydeiloms";

        LinkedList<String> candidateWords = cache.loadFor(3, characters);
        assertThat(candidateWords.size()).isGreaterThan(2);

        WordSelector selector = new WordSelector(candidateWords, characters);
        assertNotNull(selector);

        Deque<String> chosenWords = selector.SelectWords();
        assertThat(chosenWords.size()).isEqualTo(1);
        assertThat(chosenWords.pop()).isEqualTo(
                "Unable to form a word square for this set of letters");
    }
}
