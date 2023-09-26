package com.mapping;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "hibernate_Countries")
public class Countries {
    @Id
    private int countryCode;
    private String countryName;

    @ManyToMany
    @JoinTable(name = "Countries_Languages" , joinColumns = @JoinColumn(name="countryCode"),inverseJoinColumns = @JoinColumn(name="languageId"))
    private Set<Languages> languageSet = new HashSet<Languages>();

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<Languages> getLanguageSet() {
        return languageSet;
    }

    public void setLanguageSet(Set<Languages> languageSet) {
        this.languageSet = languageSet;
    }

    public Countries(int countryCode, String countryName, Set<Languages> languageSet) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.languageSet = languageSet;
    }

    public Countries() {
    }

}
