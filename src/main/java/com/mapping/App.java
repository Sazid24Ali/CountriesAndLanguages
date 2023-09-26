package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ){

        // Setting Up the COnnection
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sFactory = cfg.buildSessionFactory();

        // Generating Data And Storing The Data
        Countries country1 = new Countries();
        country1.setCountryCode(1);
        country1.setCountryName("Usa");
        Countries country2 = new Countries();
        country2.setCountryCode(2);
        country2.setCountryName("China");

        Languages lang1 = new Languages();
        lang1.setLanguageId(1001);
        lang1.setLanguageString("ENglish");
        Languages lang2 = new Languages();
        lang2.setLanguageId(1002);
        lang2.setLanguageString("Spanish");

        Languages lang3 = new Languages();
        lang3.setLanguageId(1003);
        lang3.setLanguageString("Mandarin");

        Languages lang4 = new Languages();
        lang4.setLanguageId(1004);
        lang4.setLanguageString("Cantonese");

        country1.getLanguageSet().add(lang1);
        country1.getLanguageSet().add(lang2);

        country2.getLanguageSet().add(lang3);
        country2.getLanguageSet().add(lang4);

        // Opening a Session and Begining Transaction
        Session session = sFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //Saving the data
        
        session.persist(country1);
        session.persist(country2);

        session.persist(lang1);
        session.persist(lang2);
        session.persist(lang3);
        session.persist(lang4);

        // Commiting the Data To Table ( Permenant Save )
        transaction.commit();
        session.close();
        sFactory.close();
        
    }
}
