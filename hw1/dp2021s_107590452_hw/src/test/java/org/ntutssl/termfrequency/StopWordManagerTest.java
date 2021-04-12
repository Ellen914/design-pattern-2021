package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class StopWordManagerTest {
    @Test
    public void test_is_stop_word(){
        StopWordManager stopWordManager = new StopWordManager("input/stop_words.txt");
        assertTrue(stopWordManager.isStopWordList("the"));
        assertTrue(stopWordManager.isStopWordSet("the"));
    }

    @Test
    public void test_is_stop_word_first_and_last(){
        StopWordManager stopWordManager = new StopWordManager("input/stop_words.txt");
        assertTrue(stopWordManager.isStopWordList("a"));
        assertTrue(stopWordManager.isStopWordSet("a"));
        assertTrue(stopWordManager.isStopWordList("your"));
        assertTrue(stopWordManager.isStopWordSet("your"));
    }
}
