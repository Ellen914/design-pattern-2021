package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
public class StopWordManagerTest {
    private IOHandler handler;
    private IStopWordManager swm;
    
    @Before
    public void setup() {
        handler = new IOHandler();
        swm = new StopWordManager("input/stop_words.txt", handler);
    }

    @Test
    public void isStopWordList() {
        assertTrue(swm.isStopWordList("the"));
    }

    @Test
    public void isStopWordSet() {
        assertTrue(swm.isStopWordSet("the"));
    }

    @Test
    public void isNotExistsInStopWordList() {
        assertFalse(swm.isStopWordList("mr"));
    }

    @Test
    public void isNotExistsInStopWordSet() {
        assertFalse(swm.isStopWordSet("mr"));
    }

    @Test
    public void testCompareSetIsFasterThanList() {
        long listTimeStart = System.nanoTime();
        swm.isStopWordList("the");
        long listTimeEnd = System.nanoTime();
        long listTimeResult = listTimeEnd - listTimeStart;

        long setTimeStart = System.nanoTime();
        swm.isStopWordSet("the");
        long setTimeEnd = System.nanoTime();
        long setTimeResult = setTimeEnd - setTimeStart;

        assertTrue(setTimeResult < listTimeResult);
    }
}
