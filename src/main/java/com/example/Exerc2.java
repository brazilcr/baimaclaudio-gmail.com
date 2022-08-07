package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.model.Country;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Exerc2 {

    public static final String JSON_DATA_FILE = "countries.json";
    Object data;

    static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param args
     * @throws IOException
     *                     objetives
     *                     OK - returns the number of countries in the world
     *                     OK - finds the country with the most official languages,
     *                     where they officially speak German (de).
     *                     OK - that counts all the official languages spoken in the
     *                     listed countries.
     *                     OK - to find the country with the highest number of
     *                     official languages.
     *                     OK - to find the most common official language(s), of all
     *                     countries.
     */
    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(JSON_DATA_FILE));
        ObjectMapper objectMapper = new ObjectMapper();

        Country[] shipDataArray = objectMapper.readValue(jsonData, Country[].class);

        System.out.println("Number of countries in the world : " + shipDataArray.length);

        String highestL = "";
        String highestlDe = "";
        Integer qtde = 0;
        Integer qtdeDe = 0;
        Map<String, ArrayList<String>> lstbyLanguage = new HashMap<String, ArrayList<String>>();

        for (int x = 0; x < shipDataArray.length; x++) {
            Country shiphistory = shipDataArray[x];
            Integer nrlanguages = shiphistory.getLanguages().size();
            String presentcountry = shiphistory.getCountry();
            List<String> alllangs = shiphistory.getLanguages();

            // add into array by language
            for (int k = 0; k < alllangs.size(); k++) {
                // lstbyLanguage.put(alllangs.get(k), presentcountry);
                if  ( lstbyLanguage.get(alllangs.get(k) ) != null ) {
                } else {
                    lstbyLanguage.put(alllangs.get(k), new ArrayList<String>());
                }
                lstbyLanguage.get( alllangs.get(k) ).add(presentcountry);
            }
            //System.out.println("Languages : " + alllangs);
            if (nrlanguages > qtde) {
                highestL = presentcountry;
                qtde = nrlanguages;
            }
            Integer idetimes = cntlanguage("de", alllangs);
            if (idetimes > 0) {
                if (nrlanguages > qtdeDe) {
                    highestlDe = presentcountry;
                    qtdeDe = nrlanguages;
                }
            }
            System.out.println("Country : " + presentcountry);
            System.out.println("Qty Languages : " + nrlanguages + "\n\n");
        }
        System.out.println("Country with the highest number of official languages: " + highestL);
        System.out
                .println("country with the most official languages, where they officially speak German: " + highestlDe);

        System.out.println("most common official language: " + lstbyLanguage);
    }

    /**
     * @return
     */
    public static Integer cntlanguage(String StrCountry, List<String> lLanguages) {
        Set<String> unique = new HashSet<String>(lLanguages);
        Integer ret = Collections.frequency(unique, StrCountry);
        return ret;
    }
    
}
