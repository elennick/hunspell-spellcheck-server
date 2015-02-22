package com.evanlennick.spellcheck.model;

import java.util.ArrayList;
import java.util.List;

/**
 * List of suggestions.
 */
public class SpellcheckSuggestions {
    private List<SpellcheckSuggestion> suggestions;

    public SpellcheckSuggestions() {
        this.suggestions = new ArrayList<SpellcheckSuggestion>();
    }

    public SpellcheckSuggestions(List<SpellcheckSuggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public List<SpellcheckSuggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<SpellcheckSuggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public void add(SpellcheckSuggestion suggestion) {
        this.suggestions.add(suggestion);
    }
}
