package com.chriso.wordsquare.dictionary.cache;

import com.chriso.wordsquare.dictionary.file.DictionaryReader;
import com.chriso.wordsquare.utility.LettersUtility;

import java.util.LinkedList;

public class DictionaryCache {
    private final DictionaryReader reader;

    public DictionaryCache(String dictionaryFilePath) {
        reader = new DictionaryReader(dictionaryFilePath);
    }

    public LinkedList<String> loadFor(int dimension, String characters) {
        LinkedList<String> cacheList = new LinkedList<>();
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
        String[] characters = word.split("");
        for (String ch: characters) {
            if (letters.contains(ch)) {
                letters = LettersUtility.updateLetters(letters, letters.indexOf(ch));
            }
            else {
                return false;
            }
        }
        return true;
    }
}
