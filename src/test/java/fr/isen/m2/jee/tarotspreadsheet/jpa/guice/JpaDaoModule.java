package fr.isen.m2.jee.tarotspreadsheet.jpa.guice;

import com.google.inject.AbstractModule;
import fr.isen.m2.jee.tarotspreadsheet.jpa.SpreadsheetDAO;


public class JpaDaoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SpreadsheetDAO.class).to(JPASpreadsheetDAO.class);
    }

}
