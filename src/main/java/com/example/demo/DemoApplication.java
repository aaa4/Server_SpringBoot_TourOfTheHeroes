package com.example.demo;

import com.example.demo.logic.HeroTablePopulator;
import com.example.demo.logic.HeroUtilsService;
import com.example.demo.model.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    HeroTablePopulator heroPopService;
    HeroUtilsService heroUtilsService;

    public DemoApplication(HeroTablePopulator heroPopService, HeroUtilsService heroUtilsService) {
        this.heroPopService = heroPopService;
        this.heroUtilsService = heroUtilsService;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) {
        String heroId = "eb75c688-3696-451c-abec-c93c2553d72f";
        UUID battleId = UUID.fromString(heroId);
        Optional<Hero> hero = heroUtilsService.findDistinctByHeroId(battleId);
        if (hero.get() != null)
            log.debug("hero is {}",hero.get());
        else
            log.debug("hero is null");
        // heroPopService.populateHeroes();
        //eb75c688-3696-451c-abec-c93c2553d72f

    }
}
