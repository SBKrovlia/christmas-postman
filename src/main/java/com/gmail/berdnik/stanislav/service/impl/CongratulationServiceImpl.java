package com.gmail.berdnik.stanislav.service.impl;

import com.gmail.berdnik.stanislav.dao.CongratulationDao;
import com.gmail.berdnik.stanislav.model.Congratulation;
import com.gmail.berdnik.stanislav.service.CongratulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Berdniky on 27.12.2014.
 */
@Service
@Transactional
public class CongratulationServiceImpl implements CongratulationService {

    @Autowired
    private CongratulationDao congratulationDao;

    @Override
    public Congratulation create(final Congratulation congratulation) {
        return congratulationDao.create(congratulation);
    }

    @Override
    public void update(final Congratulation congratulation) {
        congratulationDao.update(congratulation);
    }
}
