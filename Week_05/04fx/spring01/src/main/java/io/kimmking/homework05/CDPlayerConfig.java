package io.kimmking.homework05;

import io.kimmking.homework05.Impl.CDPlayer;
import io.kimmking.homework05.Impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author
 * @date 2020/11/16 19:45
 */
@Configuration
//@ComponentScan（第一种bean装配方式）
public class CDPlayerConfig {

    /**
     * 第二种bean装配方式
     * @return
     */
    @Bean
    public CompactDisc SgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc cd){
        return new CDPlayer(cd);
    }

}
