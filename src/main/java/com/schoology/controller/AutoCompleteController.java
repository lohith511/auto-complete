package com.schoology.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoology.service.CountriesAutoCompleteService;
import com.schoology.service.CountriesSuggestionWrapper;

@Controller
public class AutoCompleteController
{
    private final Logger logger = LoggerFactory.getLogger(AutoCompleteController.class);

    @Autowired
    CountriesAutoCompleteService countriesAutoCompleteService;

    @GetMapping("/")
    public String autocomplete(Model model)
    {
        model.addAttribute("title", "autocomplete");

        return "autocomplete";
    }

    /**
     *
     * Returns matching countries based on the input.
     * @param searchStr
     * @return
     */
    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CountriesSuggestionWrapper autoCompleteSuggestion(@RequestParam("searchStr") String searchStr)
    {
        logger.trace((">> autoCompleteSuggestion"));
        CountriesSuggestionWrapper suggestions = countriesAutoCompleteService.getSuggestions(searchStr);

        logger.trace(("<< autoCompleteSuggestion"));
        return suggestions;
    }
}