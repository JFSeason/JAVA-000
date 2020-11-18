package io.kimmking.homework05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring装配bean的三种方式
 * 1.自动化装配：组件扫描+自动装配（CDPlayerConfig类中包含@ComponentScan）
 * 2.通过java代码装配bean（注释CDPlayerConfig类中的@ComponentScan）
 * 3.通过xml装配Bean
 * @author
 * @date 2020/11/16 19:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CDPlayerConfig.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CDPlayerTest {

    @Autowired
    MediaPlayer mediaPlayer;

    @Test
    public void play(){
        mediaPlayer.play();
    }
}
