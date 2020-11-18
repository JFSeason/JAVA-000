package io.kimmking.homework05.Impl;

import io.kimmking.homework05.CompactDisc;
import io.kimmking.homework05.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2020/11/16 19:44
 */
@Component
public class CDPlayer implements MediaPlayer {

    @Autowired
    CompactDisc cd;

    public CDPlayer(){

    }

    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
