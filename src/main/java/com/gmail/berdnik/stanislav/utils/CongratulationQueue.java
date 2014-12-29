package com.gmail.berdnik.stanislav.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Berdniky on 28.12.2014.
 */
@Component
@Scope("singleton")
public class CongratulationQueue {
    private ConcurrentLinkedQueue<Long> congratIdQueue = new ConcurrentLinkedQueue<Long>();

    public void addCongratulationId(long id) throws InterruptedException {
        congratIdQueue.offer(id);
    }

    public long getCongratulationId() throws InterruptedException {
        return congratIdQueue.poll();
    }

    public boolean isEmpty() {
        return congratIdQueue.isEmpty();
    }
}
