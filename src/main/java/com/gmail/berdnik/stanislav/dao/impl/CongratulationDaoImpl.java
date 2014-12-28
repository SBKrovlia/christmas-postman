package com.gmail.berdnik.stanislav.dao.impl;

import com.gmail.berdnik.stanislav.dao.CongratulationDao;
import com.gmail.berdnik.stanislav.model.Congratulation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Berdniky on 27.12.2014.
 */
@Repository
public class CongratulationDaoImpl implements CongratulationDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Congratulation create(Congratulation congratulation) {

        getCurrentSession().save(congratulation);
        return congratulation;
    }

    @Override
    public void update(Congratulation congratulation) {
        getCurrentSession().update(congratulation);
    }

    @Override
    public Congratulation getById(long id) {
         return (Congratulation)getCurrentSession().get(Congratulation.class,id);
    }

    @Override
    public void delete(Congratulation congratulation) {
        getCurrentSession().delete(congratulation);
    }
}
