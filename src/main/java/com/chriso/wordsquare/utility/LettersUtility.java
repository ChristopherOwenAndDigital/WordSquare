package com.chriso.wordsquare.utility;

public class LettersUtility {

    public static String removeLetter(String letters, char letter) {
        int idx = letters.indexOf(letter);
        if (idx == -1) {
            return letters;
        }
        return updateLetters(letters, idx);
    }

    public static String updateLetters(String letters, int idx) {
        String s1 = letters.substring(0, idx);
        String s2 = letters.substring(idx+1);
        return s1 + s2;
    }
}
