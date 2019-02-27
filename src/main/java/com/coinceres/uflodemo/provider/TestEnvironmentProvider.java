package com.coinceres.uflodemo.provider;

import com.bstek.uflo.env.EnvironmentProvider;
import com.coinceres.uflodemo.holder.RequestHolder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.servlet.http.HttpServletRequest;

public class TestEnvironmentProvider implements EnvironmentProvider {

    private SessionFactory sessionFactory;
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public void setPlatformTransactionManager(
            PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    @Override
    public String getCategoryId() {
        return null;
    }

    @Override
    public String getLoginUser() {
        HttpServletRequest req = RequestHolder.getRequest();
        String username = (String) req.getSession().getAttribute("loginUser");
        return username;
    }
}