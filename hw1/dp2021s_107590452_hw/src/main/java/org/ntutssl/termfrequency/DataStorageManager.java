package org.ntutssl.termfrequency;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStorageManager{
    private List<String> words;

    public DataStorageManager(String filePath) {
        this.words = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(filePath))) {
            sc.useDelimiter("[\\W_]+");
            
            while(sc.hasNext()) {
                this.words.add(sc.next().toLowerCase());
            }
        } catch(IOException err) {
            System.out.println("File can't be found");
        }
    }

    public List<String> getWords() {
        return this.words;
    }
}