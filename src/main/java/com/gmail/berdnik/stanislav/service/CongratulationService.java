package com.gmail.berdnik.stanislav.service;

import com.gmail.berdnik.stanislav.model.Congratulation;

/**
 * Created by Berdniky on 27.12.2014.
 */
public interface CongratulationService {
    Congratulation create(Congratulation congratulation);
    void update(Congratulation congratulation);
    Congratulation getById(long id);
    void delete(Congratulation congratulation);
}
