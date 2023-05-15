package com.chriso.wordsquare.dictionary.cache;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DictionaryCacheTest {

    public static final String DICTIONARY_PATH = "src/main/resources/dictionary.txt";

    private DictionaryCache cache;

    @BeforeAll
    public void setup() {
        // When
        cache = new DictionaryCache(DICTIONARY_PATH);

        // Then
        assertNotNull(cache);
    }

    @Test
    public void testCachingThreeByThree() {
        // Given
        int dimension = 3;
        String characters = "aaccrrtty"; // for act, car, try

        // When
        Deque<String> cacheList = cache.loadFor(dimension, characters);

        // Then
        assertEquals(15, cacheList.size());
    }

}
