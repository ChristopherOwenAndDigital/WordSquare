package com.chriso.wordsquare.selector;

import com.chriso.wordsquare.utility.LettersUtility;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class WordSelector {

    private final int dimension;
    private LinkedList<String> candidateWords;
    private final String characters;


    public WordSelector(LinkedList<String> candidateWords, String characters) {
        this.dimension = (int) Math.sqrt(characters.length());
        this.characters = characters;
        this.candidateWords = candidateWords;
    }

    public Deque<String> SelectWords() {
        Deque<String> selection = new LinkedList<>();
        for(int i = 0; i < 2000; i++) {
            selection.add(candidateWords.getFirst());
            collectWords(selection);

            if (isIncomplete(selection)) {
                selection = new LinkedList<>();
                Collections.shuffle(this.candidateWords);
                continue;
            }

            if (unusedLetters(selection)) {
                selection = new LinkedList<>();
                Collections.shuffle(this.candidateWords);
            } else {
                System.out.println("Took " + i + " shuffles");
                break;
            }
        }
        if (selection.isEmpty()) {
            selection.add("Unable to form a word square for this set of letters");
        }
        return selection;
    }

    private void collectWords(Deque<String> selection) {
        while (isIncomplete(selection)) {
            String word = findNextWord(selection);
            if (word != null) {
                selection.add(word);
            } else {
                break;
            }
        }
    }

    private String findNextWord(Deque<String> selection) {
        String prefix = derivePrefix(selection);
        String returnWord = null;
        for (String nextWord : candidateWords) {
            if (nextWord.startsWith(prefix)) {
                returnWord = nextWord;
                break;
            }
        }
        return returnWord;
    }

    private String derivePrefix(Deque<String> selection) {
        StringBuilder sb = new StringBuilder();
        int pos = selection.size();
        selection.forEach(word -> sb.append(word.charAt(pos)));
        return sb.toString();
    }

    private boolean isIncomplete(Deque<String> selection) {
        return selection.size() < dimension;
    }

    private boolean unusedLetters(Deque<String> selection) {
        String letters = characters;
        for (String word : selection) {
            for (int i = 0; i < dimension; i++) {
                letters = LettersUtility.removeLetter(letters, word.charAt(i));
            }
        }
        return !letters.isEmpty();
    }
}
