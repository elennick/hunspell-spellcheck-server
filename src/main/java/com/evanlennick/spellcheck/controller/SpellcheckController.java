package com.evanlennick.spellcheck.controller;

import com.evanlennick.spellcheck.model.SpellcheckSuggestions;
import com.evanlennick.spellcheck.service.SpellcheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Spellcheck controller.
 */
@RestController
@RequestMapping("/spellcheck")
public class SpellcheckController {

    @Autowired
    private SpellcheckService service;

    @RequestMapping("/words/{words}")
    public SpellcheckSuggestions words(@PathVariable(value="words") String words) {
        String[] wordsArray = words.split(",");
        return service.getSpellcheckSuggestions(wordsArray);
    }
}
