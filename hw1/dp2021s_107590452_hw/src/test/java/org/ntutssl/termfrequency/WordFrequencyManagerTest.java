package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordFrequencyManagerTest {
    @Test
    public void word_frequency_manager_works(){
        WordFrequencyManager wordFreqManager = new WordFrequencyManager();
        wordFreqManager.incrementCount("dog");
        wordFreqManager.incrementCount("cat");
        wordFreqManager.incrementCount("dog");
        assertEquals(Integer.valueOf(2), wordFreqManager.getCount("dog"));
        assertEquals(Integer.valueOf(1), wordFreqManager.getCount("cat"));
        assertEquals(Integer.valueOf(0), wordFreqManager.getCount("mouse"));
    }
}
