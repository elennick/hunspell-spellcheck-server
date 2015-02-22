package com.evanlennick.spellcheck.service;

import com.evanlennick.spellcheck.model.SpellcheckSuggestions;
import dk.dren.hunspell.Hunspell;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Spellcheck service.
 */
@Service
@Scope("singleton")
public class SpellcheckService {

    public SpellcheckService() {
        try {
            Hunspell.getInstance().getDictionary("/Users/evan.lennick/Development/hunspell-test/dict/en_US/en_US");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public SpellcheckSuggestions getSpellcheckSuggestions(String[] wordsToCheck) {
        return null;
    }

}
