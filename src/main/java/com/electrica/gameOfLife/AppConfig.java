package com.electrica.gameOfLife;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.electrica.gameOfLife.cellGeneratorSeeder.CellGeneratorSeeder;
import com.electrica.gameOfLife.cellGeneratorSeeder.ChessStyleCellGeneratorSeeder;
import com.electrica.gameOfLife.cellGeneratorSeeder.RandomCellGeneratorSeeder;
import com.electrica.gameOfLife.contracts.Ruleable;
import com.electrica.gameOfLife.models.Ecosystem;
import com.electrica.gameOfLife.rules.RulesOfLife;
import com.electrica.gameOfLife.ui.GameUI;

@Configuration
public class AppConfig {

    @Value("${spring.aplication.height: 20}")
    private int height;

    @Value("${spring.aplication.width: 20}")
    private int width;

    @Value("${spring.aplication.speed: 1000}")
    private int refreshRate;

    @Bean
    public Ruleable rulesOfLife() {
        return new RulesOfLife();
    }

    @Bean
    public CellGeneratorSeeder cellGeneratorSeeder() {
        return new RandomCellGeneratorSeeder();
        //return new ChessStyleCellGeneratorSeeder();
    }

    @Bean
    public Ecosystem ecosystem(Ruleable rulesOfLife, CellGeneratorSeeder generator) {
        return new Ecosystem(rulesOfLife, height, width, generator);
    }

    @Bean
    public GameUI gameUI(Ecosystem ecosystem) {
        return new GameUI(ecosystem, refreshRate);
    }

}
