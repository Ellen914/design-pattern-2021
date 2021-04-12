package org.ntutssl.termfrequency;

import java.util.List;
import java.util.Set;

public class DataStorageManager implements IDataStorageManager {
    private List<String> ListWords;
    private Set<String> SetWords;

    public DataStorageManager(String filePath, IOHandler ioHandler) {
        this.ListWords = ioHandler.handleInputAsList(filePath, "[\\W_]+");
        this.SetWords = ioHandler.handleInputAsSet(filePath, "[\\W_]+");
    }

    public List<String> getWords() {
        return this.ListWords;
    }
}