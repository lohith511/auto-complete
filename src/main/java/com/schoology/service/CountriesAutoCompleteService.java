package com.schoology.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.schoology.constants.AutoCompleteProperties;

@Component
public class CountriesAutoCompleteService implements ApplicationRunner
{
    @Autowired
    AutoCompleteProperties autoCompleteProperties;

    private List<String> countries = new ArrayList<>();

    /**
     * On application startup populates the countries info.
     * @param args
     */
    @Override
    public void run(ApplicationArguments args)
    {
        String[] locales = Locale.getISOCountries();
        countries = Arrays.stream(locales)
                .map(countryCode ->
                {
                    Locale obj = new Locale("", countryCode);
                    return obj.getDisplayCountry();
                }).
                collect(Collectors.toList());
    }

    /**
     * Filters the countries matching the input
     * Limits the count based on  configuration  {@link AutoCompleteProperties#getMaxSize()} ()}
     * @param searchStr
     * @return
     */
    public CountriesSuggestionWrapper getSuggestions(String searchStr)
    {
        CountriesSuggestionWrapper countriesSuggestionWrapper = new CountriesSuggestionWrapper();
        if (searchStr != null)
        {
            String searchStr0 = searchStr.toLowerCase();
            List<String> suggestingCountries = countries.stream()
                    .filter(country -> country.toLowerCase().contains(searchStr0))
                    .limit(autoCompleteProperties.getMaxSize())
                    .collect(Collectors.toList());
            countriesSuggestionWrapper.setSuggestions(suggestingCountries);
        }
        return countriesSuggestionWrapper;
    }
}