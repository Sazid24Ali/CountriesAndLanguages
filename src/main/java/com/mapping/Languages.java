package com.mapping;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name = "hibernate_Languages")
public class Languages {
    @Id
    private int languageId;
    private String languageString;

    @ManyToMany(mappedBy = "languageSet")
    private Set<Countries> countrySet = new HashSet<Countries>();

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageString() {
        return languageString;
    }

    public void setLanguageString(String languageString) {
        this.languageString = languageString;
    }

    public Set<Countries> getCountrySet() {
        return countrySet;
    }

    public void setCountrySet(Set<Countries> countrySet) {
        this.countrySet = countrySet;
    }

    public Languages(int languageId, String languageString, Set<Countries> countrySet) {
        this.languageId = languageId;
        this.languageString = languageString;
        this.countrySet = countrySet;
    }

    public Languages() {
    }

}
