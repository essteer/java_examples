package dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintWriter;

public class SaveableDictionary {

    private HashMap<String,String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.file = file;
        this.dictionary = new HashMap<>();
    }

    public void add(String words, String translation) {
        // adds a word to the dictionary 
        // every word has just one translation, 
        // and if the same word is added for the second time, nothing happens
        this.dictionary.putIfAbsent(words, translation);
        this.dictionary.putIfAbsent(translation, words);
    }

    public String translate(String word) {
        // returns the translation for the given word
        // returns null if the word is not in the dictionary
        return this.dictionary.getOrDefault(word, null);
    }

    public void delete(String word) {
        // deletes the given word and its translation from the dictionary
        if (this.dictionary.containsKey(word)) {
            String translation = this.dictionary.get(word);
            this.dictionary.remove(word);
            this.dictionary.remove(translation);
        }
    }

    public boolean load() {
        // loads the dictionary from the file given to the constructor as a parameter
        // returns false if the program is unable to open the file or read from it
        // returns true if successful
        try {
            Files.lines(Paths.get(this.file))
            .map(row -> row.split(":"))
            .forEach(translation -> this.add(translation[0], translation[1]));
            return true;
        
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        // saves the dictionary to the file given to the dictionary as a parameter to the constructor
        // returns false if the program cannot save to the file
        // returns true if successful
        try {
            PrintWriter writer = new PrintWriter(this.file);
            ArrayList<String> savedWords = new ArrayList<>();
            for (String key : this.dictionary.keySet()) {
                if (savedWords.contains(this.dictionary.get(key))) {
                    continue;
                } else {
                    writer.println(key + ":" + this.dictionary.get(key));
                    savedWords.add(key);
                    savedWords.add(this.dictionary.get(key));
                }
            }
            writer.close();
            return true;
        
        } catch (Exception e) {
            return false;
        }
    }

}
