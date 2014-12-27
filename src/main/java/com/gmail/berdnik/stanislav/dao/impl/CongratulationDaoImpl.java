package com.gmail.berdnik.stanislav.dao.impl;

import com.gmail.berdnik.stanislav.dao.CongratulationDao;
import com.gmail.berdnik.stanislav.model.Congratulation;
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

    @Override
    public Congratulation create(Congratulation congratulation) {

        return null;
    }
}
