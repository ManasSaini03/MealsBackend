package com.manas.meals.Clients;

public class Constants {

    public static final String BASE_URL =
            "https://www.themealdb.com/api/json/v1/1";

    public static final String SEARCH_BY_NAME =
            BASE_URL + "/search.php?s=%s";

    public static final String LOOKUP_BY_ID =
            BASE_URL + "/lookup.php?i=%s";

    public static final String RANDOM_MEAL =
            BASE_URL + "/random.php";

    public static final String CATEGORIES =
            BASE_URL + "/categories.php";

    public static final String FILTER_BY_CATEGORY =
            BASE_URL + "/filter.php?c=%s";
}
