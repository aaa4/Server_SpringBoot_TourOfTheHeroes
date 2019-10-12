package com.example.demo.logic;

import com.example.demo.model.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HeroTablePopulator {

    private HeroUtilsService heroService;
    
    public HeroTablePopulator(HeroUtilsService heroService) {
        this.heroService = heroService;
    }


    private void createTeamOfHeroes(){
        heroService.save(new Hero("IronMan"));
        heroService.save(new Hero("Halk"));
        heroService.save(new Hero("Dr.Strange"));
        heroService.save(new Hero("SpiderMan"));
        heroService.save(new Hero("StarLord"));
        heroService.save(new Hero("Captain Amerika"));
        heroService.save(new Hero("AquaMan"));
        heroService.save(new Hero("AntMan"));
    }

    private boolean checkStarLord(){
        int size =  heroService.findByName("IronMan").size();
        if (size > 0){
            return true;
        }
        return false;
    }

    public void populateHeroes(){
        if (!checkStarLord()){
            createTeamOfHeroes();
            log.info("populating database");
        }
        else{
            log.debug("Table is populated yet.");
        }
    }



}
