package org.ntutssl.termfrequency;

import java.util.Map;
import java.util.Map.Entry;

public class WordFrequencyController {

    private DataStorageManager storageManager;
    private StopWordManager stopWordManager;
    private WordFrequencyManager wordFreqManager;
    private Integer range;
    private String sortOrder;
    
    public WordFrequencyController(String[] args) {
        this.storageManager = new DataStorageManager(args[0]);
        this.stopWordManager = new StopWordManager(args[1]);
        this.wordFreqManager = new WordFrequencyManager();
        this.range = Integer.parseInt(args[2]);
        this.sortOrder = args[3];
    }
    
    public void run() {
        int tempCount = 0;
        for (String word : this.storageManager.getWords()) {
            if (!this.stopWordManager.isStopWordList(word)) {
                this.wordFreqManager.incrementCount(word);
            }
        }
        
        if(this.sortOrder.equals("asc")) {
            for(Map.Entry<String, Integer> entry : this.wordFreqManager.getWordFrequencyAscending().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                tempCount++;
                if(tempCount >= this.range) {
                    break;
                }
            }

        } else if(this.sortOrder.equals("desc")) {
            for(Map.Entry<String, Integer> entry : this.wordFreqManager.getWordFrequencyDescending().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                tempCount++;
                if(tempCount >= this.range) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) { 
        System.out.println("run");
        new WordFrequencyController(args).run();
        
    }
}