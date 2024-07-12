import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String,ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }

    public void add(String word, String translation) {
        if (this.dictionary.keySet().contains(word)) {
            ArrayList<String> translations = this.dictionary.get(word);
            translations.add(translation);
        } else {
            ArrayList<String> translations = new ArrayList<>();
            translations.add(translation);
            this.dictionary.put(word, translations);
        }
    }

    public ArrayList<String> translate(String word) {
        return this.dictionary.getOrDefault(word, new ArrayList<>());
    }

    public void remove(String word) {
        if (this.dictionary.keySet().contains(word)) {
            this.dictionary.remove(word);
        }
    }  

}

// public void add(String word, String translation) {
//     this.dictionary.putIfAbsent(word, new ArrayList<>());
//     this.dictionary.get(word).add(translation);
// }
