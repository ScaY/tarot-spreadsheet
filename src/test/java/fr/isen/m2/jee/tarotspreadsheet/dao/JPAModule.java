package fr.isen.m2.jee.tarotspreadsheet.dao;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.persistence.EntityManager;
import javax.transaction.*;

public class JPAModule extends AbstractModule {

    @Override
    protected void configure() {
        // TODO Auto-generated method stub

    }


    @Provides
    public UserTransaction getUserTransaction(final EntityManager em) {
        return new UserTransaction() {

            @Override
            public void setTransactionTimeout(int seconds) throws SystemException {
                // TODO Auto-generated method stub

            }

            @Override
            public void setRollbackOnly() throws IllegalStateException, SystemException {
                // TODO Auto-generated method stub

            }

            @Override
            public void rollback() throws IllegalStateException, SecurityException,
                    SystemException {
                // TODO Auto-generated method stub

            }

            @Override
            public int getStatus() throws SystemException {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public void commit() throws RollbackException, HeuristicMixedException,
                    HeuristicRollbackException, SecurityException,
                    IllegalStateException, SystemException {
                em.getTransaction().commit();

            }

            @Override
            public void begin() throws NotSupportedException, SystemException {
                em.getTransaction().begin();

            }
        };
    }


}
