package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DataStorageManagerTest{ 
    @Test
    public void test_word_is_very(){
        DataStorageManager storageManager = new DataStorageManager("input/pride-and-prejudice.txt");
        for (String word : storageManager.getWords()) {
            if (word.equals("very")) {
                assertEquals(word,"very");
            }
        }
    }

    @Test
    public void test_word_is_such(){
        DataStorageManager storageManager = new DataStorageManager("input/pride-and-prejudice.txt");
        for (String word : storageManager.getWords()) {
            if (word.equals("such")) {
                assertEquals(word,"such");
            }
        }
    }

    @Test
    public void test_word_is_elizabeth(){
        DataStorageManager storageManager = new DataStorageManager("input/pride-and-prejudice.txt");
        for (String word : storageManager.getWords()) {
            if (word.equals("elizabeth")) {
                assertEquals(word,"elizabeth");
            }
        }
    }

    
}