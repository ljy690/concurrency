package com.jy.concurrency.aboutatomic;

import com.jy.concurrency.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class SafeAtomicIntegerFieldUpdater {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(1);

    public static void main(String[] args) {
        atomicReference.compareAndSet(1,2);
        atomicReference.compareAndSet(1,3);
        atomicReference.compareAndSet(2,4);
        atomicReference.compareAndSet(3,5);
        System.out.println(atomicReference.get());
    }

}
