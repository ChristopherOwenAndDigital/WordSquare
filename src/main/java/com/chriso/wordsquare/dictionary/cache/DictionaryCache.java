package com.chriso.wordsquare.dictionary.cache;

import com.chriso.wordsquare.dictionary.file.DictionaryReader;
import com.chriso.wordsquare.utility.LettersUtility;

import java.util.Deque;
import java.util.LinkedList;

public class DictionaryCache {
    private final DictionaryReader reader;

    public DictionaryCache(String dictionaryFilePath) {
        reader = new DictionaryReader(dictionaryFilePath);
    }

    public Deque<String> loadFor(int dimension, String characters) {
        Deque<String> cacheList = new LinkedList<>();
        String word = reader.readNextWord();
        while (word != null) {
            boolean include = isWordRelevant(word, dimension, characters);
            if (include) {
                cacheList.add(word);
            }
            word = reader.readNextWord();
        }
        return cacheList;
    }

    private boolean isWordRelevant(String word, int dimension, String letters) {
        boolean relevant = false;
        if (word.length() == dimension) {
            relevant = doWeHaveLettersFor(word, letters);
        }

        return relevant;
    }

    private boolean doWeHaveLettersFor(String word, String letters) {
        for (int i=0; i < word.length(); i++) {
            String curChar = String.valueOf(word.charAt(i));
            int idx = letters.indexOf(curChar);
            if (idx != -1) {
                letters = LettersUtility.updateLetters(letters, idx);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
