package org.ntutssl.termfrequency;

import java.util.List;
import java.util.Set;

public class StopWordManager implements IStopWordManager {

    private List<String> stopWordsList;
    private Set<String> stopWordsSet;

    public StopWordManager(String filePath, IOHandler ioHandler) {
        this.stopWordsList = ioHandler.handleInputAsList(filePath, ",");
        this.stopWordsSet = ioHandler.handleInputAsSet(filePath, ",");

        for(char c = 'a'; c <= 'z'; c++) {
            this.stopWordsList.add("" + c);
            this.stopWordsSet.add("" + c);
        }
    }

    public boolean isStopWordList(String word){ 
        return this.stopWordsList.contains(word);
    }

    public boolean isStopWordSet(String word){ 
        return this.stopWordsSet.contains(word);
    }
}
