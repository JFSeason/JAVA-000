package io.kimmking.homework05.Impl;

import io.kimmking.homework05.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2020/11/16 19:44
 */
@Component
public class SgtPeppers implements CompactDisc {

    @Override
    public void play() {
        System.out.println("playing");
    }
}
