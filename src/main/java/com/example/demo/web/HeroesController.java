package com.example.demo.web;

import com.example.demo.logic.HeroUtilsService;
import com.example.demo.model.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = "http://localhost:4201")
public class HeroesController {

    private HeroUtilsService heroUtilsService;

    public HeroesController(HeroUtilsService heroUtilsService) {
        this.heroUtilsService = heroUtilsService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Hero> getHeroes() {
        return heroUtilsService.findAll();
    }


    @GetMapping("/{heroId}")
    public Hero getHero(@PathVariable("heroId") String heroId) {
        return heroUtilsService.findDistinctByHeroId(UUID.fromString(heroId)).get();
    }

    @DeleteMapping("/{heroId}")
    public ResponseEntity deleteHero(@PathVariable  String heroId){
        log.debug("delete activated");
        log.debug("Get delete request with hero id = {}", heroId);
        heroUtilsService.deleteDistinctById(UUID.fromString(heroId));
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{heroId}")
    public void updateHero(@PathVariable("heroId") String heroId,
                           @RequestBody Hero hero) {
        log.debug("updating hero with  id = {}", heroId);
        log.debug("post request with hero = {}", hero);

        Hero heroToUpdate = heroUtilsService.findDistinctByHeroId(hero.getId()).get();
        log.debug("hero to update is {}", heroToUpdate);

        heroToUpdate.setName(hero.getName());
        Hero updatedHero = heroUtilsService.save(heroToUpdate);

        log.debug("updated hero = {}", updatedHero);
    }

    //`${this.heroUrl}/?name=${term}`
    @GetMapping("/search")
    @ResponseBody
    public List<Hero> getSearchResult(@RequestParam ("name") String name){
        return heroUtilsService.findAllByNameContaining(name);
    }

}

