package com.schoology;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schoology.constants.AutoCompleteProperties;
import com.schoology.service.CountriesAutoCompleteService;
import com.schoology.service.CountriesSuggestionWrapper;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AutoCompleteApp.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AutoCompleteAppTests
{
    @Autowired
    CountriesAutoCompleteService countriesAutoCompleteService;

    @Autowired
    AutoCompleteProperties autoCompleteProperties;


    @Test
    public void test_getSuggestions()
    {
        CountriesSuggestionWrapper im = countriesAutoCompleteService.getSuggestions("in");
        assertThat(im, is(notNullValue()));
        assertThat(im.getSuggestions(), is(notNullValue()));
    }

    @Test
    public void test_getSuggestions_Limit()
    {
        CountriesSuggestionWrapper im = countriesAutoCompleteService.getSuggestions("a");
        assertThat(im, is(notNullValue()));
        assertThat(im.getSuggestions(), is(notNullValue()));
        assertThat(im.getSuggestions(), is(hasSize(20)));
    }

    @Test
    public void test_getSuggestions_Custom_Limit()
    {
        autoCompleteProperties.setMaxSize(5);
        CountriesSuggestionWrapper im = countriesAutoCompleteService.getSuggestions("a");
        assertThat(im, is(notNullValue()));
        assertThat(im.getSuggestions(), is(notNullValue()));
        assertThat(im.getSuggestions(), is(hasSize(5)));
        autoCompleteProperties.setMaxSize(20);
    }
}
