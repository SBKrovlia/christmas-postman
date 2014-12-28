package com.gmail.berdnik.stanislav.utils;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Berdniky on 28.12.2014.
 */
public class CongratulationQueue {
    private LinkedBlockingQueue<Long> congratIdQueue = new LinkedBlockingQueue<Long>();

    public void addCongratulationId(long id) throws InterruptedException {
        congratIdQueue.put(id);
    }

    public long getCongratulationId() throws InterruptedException {
        return congratIdQueue.take();
    }
}
