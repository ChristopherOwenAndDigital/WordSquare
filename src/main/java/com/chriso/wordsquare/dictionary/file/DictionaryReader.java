package com.chriso.wordsquare.dictionary.file;

import java.io.*;

public class DictionaryReader {

    private final BufferedReader bufferedReader;

    public DictionaryReader(final String filePath) {
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Dictionary file not found", e);
        }
    }

    public String readNextWord() {
        try {
            return bufferedReader.readLine();
        }
        catch(IOException e){
            throw new IllegalStateException("File reading failed", e);
        }
    }
}
