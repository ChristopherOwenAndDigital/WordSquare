package com.chriso.wordsquare.dictionary.file;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DictionaryReaderTest {
    public static final String TEST_DICTIONARY_PATH = "src/test/resources/test_dictionary.txt";
    private DictionaryReader reader;

    @BeforeAll
    public void setup() {
        reader = new DictionaryReader(TEST_DICTIONARY_PATH);
    }

    @Test
    public void readsDataLines() {
        Assertions.assertThat(reader.readNextWord()).isEqualTo("abluents");
        Assertions.assertThat(reader.readNextWord()).isEqualTo("absorbants");
        Assertions.assertThat(reader.readNextWord()).isEqualTo("accepters");

        // Skip to last line
        skipWords(686);
        Assertions.assertThat(reader.readNextWord()).isEqualTo("zilches");

        // Detect end
        Assertions.assertThat(reader.readNextWord()).isNull();
    }

    private void skipWords(int skips) {
        for (int i=0; i < skips; i++) {
            reader.readNextWord();
        }
    }
}