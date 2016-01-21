package fr.isen.m2.jee.tarotspreadsheet.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 * Created by stephane on 21/01/16.
 */
public class DAO {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction ut;
}
