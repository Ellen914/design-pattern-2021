package org.ntutssl.termfrequency;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class WordFrequencyManager {
    private Map<String, Integer> words;

    public WordFrequencyManager() {
        this.words = new HashMap<>();
    }

    public void incrementCount(String word) {
        if(this.words.containsKey(word)) {
            this.words.put(word, this.words.get(word) + 1);
        } else {
            this.words.put(word, 1);
        }
    }

    public Integer getCount(String word) {
        return this.words.get(word) != null ? this.words.get(word) : 0;
    }

    public int getNumOfWords() {
        return this.words.size();
    }

    public Map<String, Integer> getWordFrequencyDescending() {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(this.words.entrySet()); 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { 
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 

        HashMap<String, Integer> wordFreqDesc = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> entry : list) { 
            wordFreqDesc.put(entry.getKey(), entry.getValue()); 
        } 
        return wordFreqDesc; 
    }

    public Map<String, Integer> getWordFrequencyAscending() { 
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(this.words.entrySet()); 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { 
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 

        HashMap<String, Integer> wordFreqAsc = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> entry : list) { 
            wordFreqAsc.put(entry.getKey(), entry.getValue()); 
        } 
        return wordFreqAsc;
    }
}
