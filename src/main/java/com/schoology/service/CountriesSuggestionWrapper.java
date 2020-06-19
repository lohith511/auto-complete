package com.schoology.service;

import java.util.List;

public class CountriesSuggestionWrapper
{
    List<String> suggestions;

    public List<String> getSuggestions()
    {
        return suggestions;
    }

    public CountriesSuggestionWrapper setSuggestions(List<String> suggestedCountries)
    {
        this.suggestions = suggestedCountries;
        return this;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CountriesSuggestionWrapper{");
        sb.append("suggestions=").append(suggestions);
        sb.append('}');
        return sb.toString();
    }
}