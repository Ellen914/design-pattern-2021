package org.ntutssl.termfrequency;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class StopWordManager{
    private List<String> stopWordsList;
    private Set<String> stopWordsSet;

    public StopWordManager(String filepath) {
        this.stopWordsList = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(filepath))){
            sc.useDelimiter(",");
            while(sc.hasNext()){
                this.stopWordsList.add(sc.next());
            }
        }catch(IOException e){
            System.out.println("cannot find the file.");
        }


        this.stopWordsSet = new HashSet<>();
        try(Scanner sc = new Scanner(new File(filepath))){
            sc.useDelimiter(",");
            while(sc.hasNext()){
                this.stopWordsSet.add(sc.next());
            }
        }catch(IOException e){
            System.out.println("cannot find the file.");
        }

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


