package com.evanlennick.spellcheck.service;

import com.evanlennick.spellcheck.model.SpellcheckSuggestion;
import com.evanlennick.spellcheck.model.SpellcheckSuggestions;
import dk.dren.hunspell.Hunspell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Spellcheck service.
 */
@Service
@Scope("singleton")
public class SpellcheckService {

    private String dictionaries;

    private String rootDictDirectory;

    private List<Hunspell.Dictionary> loadedDictionaries;

    private final static Logger LOGGER = LoggerFactory.getLogger(SpellcheckService.class);

    @Autowired
    public SpellcheckService(@Value("${spellcheck.dictionaries}") String dictionaries,
                             @Value("${spellcheck.rootdir}") String rootDictDirectory) {

        this.dictionaries = dictionaries;
        this.rootDictDirectory = rootDictDirectory;

        loadedDictionaries = new ArrayList<Hunspell.Dictionary>();
        loadDictionaries();
    }

    public void loadDictionaries() {
        List<String> dictList = getDictionariesAsList();
        loadedDictionaries.clear();

        for (String dict : dictList) {
            try {
                loadedDictionaries.add(Hunspell.getInstance().getDictionary(getDictionaryPath(dict)));
                LOGGER.info("Loaded dictionary successfully: " + dict);
            } catch(Exception e) {
                LOGGER.error("Error instantiating dictionary: " + dict, e);
            }
        }
    }

    public SpellcheckSuggestions getSpellcheckSuggestions(String[] wordsToCheck) {
        SpellcheckSuggestions suggestions = new SpellcheckSuggestions();

        for (String s : wordsToCheck) {
            boolean misspelled = true;
            List<String> allSuggestionsForThisWord = new ArrayList<String>();

            for (Hunspell.Dictionary dict : loadedDictionaries) {
                if(misspelled && !dict.misspelled(s)) {
                    misspelled = false;
                }
                if(misspelled) {
                    allSuggestionsForThisWord.addAll(dict.suggest(s));
                }
            }

            SpellcheckSuggestion suggestion = new SpellcheckSuggestion();
            suggestion.setWord(s);
            suggestion.setMisspelled(misspelled);
            suggestion.setSuggestions(allSuggestionsForThisWord);
            suggestions.add(suggestion);
        }

        return suggestions;
    }

    public List<String> getDictionariesAsList() {
        List<String> dictList = new ArrayList<String>();
        String[] dictArray = dictionaries.split(",");
        for (String s : dictArray) {
            dictList.add(s.trim());
        }
        return dictList;
    }

    public List<Hunspell.Dictionary> getLoadedDictionaries() {
        return loadedDictionaries;
    }

    private String getDictionaryPath(String dict) {
        return rootDictDirectory + dict;
    }
}
