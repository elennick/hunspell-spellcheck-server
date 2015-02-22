package com.evanlennick.spellcheck.service;

import com.atlascopco.hunspell.Hunspell;
import com.evanlennick.spellcheck.model.SpellcheckSuggestions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Spellcheck service.
 */
@Service
@Scope("singleton")
public class SpellcheckService {

    private Hunspell speller;

    public SpellcheckService() {
        speller = new Hunspell("/Users/evan.lennick/Development/hunspell-test/dict/en_US.dic",
                                        "/Users/evan.lennick/Development/hunspell-test/dict/en_US.aff");
    }

    public SpellcheckSuggestions getSpellcheckSuggestions(String[] wordsToCheck) {
        return null;
    }

}
