package org.ntutssl.termfrequency;

import java.io.IOException;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class IOHandler {

    private List<String> ListWords;
    private Set<String> SetWords;

    public IOHandler() {
        this.ListWords = new ArrayList<>();
        this.SetWords = new HashSet<>();
    }

    public List<String> handleInputAsList(String filePath, String pattern) {
        try(Scanner sc = new Scanner(new File(filePath))) {
            sc.useDelimiter(pattern);
            
            while(sc.hasNext()) {
                this.ListWords.add(sc.next().toLowerCase());
            }
        } catch(IOException err) {
            throw new WordFrequencyException("File not found.", err);
        }
        return this.ListWords;
     }

    public Set<String> handleInputAsSet(String filePath, String pattern) { 
        try(Scanner sc = new Scanner(new File(filePath))) {
            sc.useDelimiter(pattern);
            
            while(sc.hasNext()) {
                this.SetWords.add(sc.next().toLowerCase());
            }
        } catch(IOException err) {
            throw new WordFrequencyException("File not found.", err);
        }
        return this.SetWords;
    }

    public void handleOutput(String outputPath, int range, List<String> data) {
        try(FileWriter fw = new FileWriter(new File(outputPath))) {
            for(int i = 0; i < range; i++) {
                fw.write(data.get(i));
                fw.flush();
            }
        } catch(IndexOutOfBoundsException | IOException err) {
            err.printStackTrace();
        }
    }
}