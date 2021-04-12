package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.SortOrder;

public class WordFrequencyManager implements IWordFrequencyManager {
    private Map<String, Integer> wordFreq;
    private SortOrder order;

    public WordFrequencyManager() {
        this.wordFreq = new HashMap<>();
        this.order = SortOrder.UNSORTED;
    }

    public void incrementCount(String word) {
        if(this.wordFreq.containsKey(word)) {
            this.wordFreq.put(word, this.wordFreq.get(word) + 1);
        } else {
            this.wordFreq.put(word, 1);
        }
    }

    public int getNumOfWords() {
        return this.wordFreq.size();
    }

    public List<String> getWordFrequency(SortOrder order) {
        List<String> wordFreqSort = new ArrayList<>();

        List<Map.Entry<String, Integer>> tempList = new LinkedList<Map.Entry<String, Integer>>(this.wordFreq.entrySet()); 

        if(order.equals(SortOrder.ASCENDING)) {
            Collections.sort(tempList, new Comparator<Map.Entry<String, Integer>>() { 
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue()); 
                } 
            }); 
        } else {
            Collections.sort(tempList, new Comparator<Map.Entry<String, Integer>>() { 
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue()); 
                } 
            }); 
        }

        for(Map.Entry<String, Integer> entry : tempList) {
            wordFreqSort.add(entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n");
        }

        return wordFreqSort;
    }

    public void output(String outputPath, String order, int range, IOHandler handler) {
        if(getNumOfWords() == 0) {
            throw new WordFrequencyException("Word not found.");
        }

        if(!order.equals("asc") && !order.equals("des")) {
            throw new WordFrequencyException("The order should be" + " \"asc\" " + "or " + "\"des\"" + ".");
        }

        if(range <= 0) {
            throw new WordFrequencyException("Out of range! The range should be from 1 to " + String.valueOf(getNumOfWords()) + ".");
        } else if(range > getNumOfWords()) {
            throw new WordFrequencyException("Out of range! The range should be from 1 to " + String.valueOf(getNumOfWords()) + ".");
        }

        if(order.equals("asc")) {
            this.order = SortOrder.ASCENDING;
        } else {
            this.order = SortOrder.DESCENDING;
        }

        handler.handleOutput(outputPath, range, getWordFrequency(this.order));
    }
}