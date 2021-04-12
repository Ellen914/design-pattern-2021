package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WordFrequencyManagerStreamTest {
    private IWordFrequencyManager wfm;

    @Before
    public void setup() {
        wfm = new WordFrequencyManager();
    }

    @Test
    public void testWordFrequencyListSize() {
        wfm.incrementCount("A");
        wfm.incrementCount("B");
        wfm.incrementCount("A");
        assertEquals(2, wfm.getNumOfWords());
    }
}
