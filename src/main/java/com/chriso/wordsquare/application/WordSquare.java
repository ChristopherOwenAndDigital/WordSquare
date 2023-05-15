package com.chriso.wordsquare.application;

import com.chriso.wordsquare.dictionary.cache.DictionaryCache;
import com.chriso.wordsquare.selector.WordSelector;

import java.util.Deque;

public class WordSquare {

    public static final String DICTIONARY_PATH = "src/main/resources/dictionary.txt";

    public static void main(String[] args) {

        int dimension = Integer.parseInt(args[0]);
        String letters = args[1];

        Deque<String> cacheList = new DictionaryCache(DICTIONARY_PATH).loadFor(dimension, letters);

        Deque<String> chosenWords = new WordSelector(cacheList, letters).SelectWords();

        chosenWords.forEach(System.out::println);
    }
}
