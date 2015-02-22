package com.evanlennick.spellcheck.model;

import java.util.List;

/**
 * Single suggestion.
 */
public class SpellcheckSuggestion {

    private String word;
    private boolean misspelled;
    private List<String> suggestions;

    public SpellcheckSuggestion() {
    }

    public SpellcheckSuggestion(String word, boolean misspelled, List<String> suggestions) {
        this.word = word;
        this.misspelled = misspelled;
        this.suggestions = suggestions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isMisspelled() {
        return misspelled;
    }

    public void setMisspelled(boolean misspelled) {
        this.misspelled = misspelled;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }
}
