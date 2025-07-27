package com.electrica.gameOfLife;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.electrica.gameOfLife.ui.GameUI;

@SpringBootApplication
public class GameOfLifeApplication implements CommandLineRunner{
	@Autowired GameUI gameUI;
	public static void main(String[] args) {
		SpringApplication.run(GameOfLifeApplication.class, args);
	}

	@Override
    public void run(String... args) {
		new Thread(gameUI).start();
    }
}
