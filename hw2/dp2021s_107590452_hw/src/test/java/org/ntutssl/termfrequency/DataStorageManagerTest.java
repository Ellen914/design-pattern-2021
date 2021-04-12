package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DataStorageManagerTest {
    private IDataStorageManager dsm;
    private IOHandler handler;
    private List<String> words;

    @Before
    public void setup() {
        handler = new IOHandler();
        dsm = new DataStorageManager("input/pride-and-prejudice.txt", handler);
        words = new ArrayList<>(dsm.getWords());
    }

    @Test
    public void testGetWords() {
        assertTrue(words.contains("mr"));
    }
}
