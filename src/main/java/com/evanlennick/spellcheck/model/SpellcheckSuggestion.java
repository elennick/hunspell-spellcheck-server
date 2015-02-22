package com.evanlennick.spellcheck.model;

/**
 * Single suggestion.
 */
public class SpellcheckSuggestion {

    private String word;
    private boolean misspelled;
    private String[] suggestions;

    public SpellcheckSuggestion(String word, boolean misspelled, String[] suggestions) {
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

    public String[] getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String[] suggestions) {
        this.suggestions = suggestions;
    }
}
