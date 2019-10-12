package com.example.demo;

import com.example.demo.logic.HeroTablePopulator;
import com.example.demo.logic.HeroUtilsService;
import com.example.demo.repo.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPopulate {


    @Autowired
    HeroTablePopulator heroPopulator;

    @Autowired
    HeroUtilsService heroUtilsService;



    @Test
    public void checkThatEmpty(){
        heroUtilsService.deleteAll();
        assertEquals(0, heroUtilsService.findAll().size());
    }

    @Test
    public void checkThatDbPopulated(){
        heroPopulator.populateHeroes();
        assertNotEquals(0, heroUtilsService.findAll().size());
    }




}
