package com.gmail.berdnik.stanislav.dao;

import com.gmail.berdnik.stanislav.model.Congratulation;

/**
 * Created by Berdniky on 27.12.2014.
 */
public interface CongratulationDao {
    Congratulation create(Congratulation congratulation);
    void update (Congratulation congratulation);
    Congratulation getById (long id);
    void delete(Congratulation congratulation);

}
