package com.example.demo.logic;

import com.example.demo.model.Hero;
import com.example.demo.repo.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HeroUtilsService {

    private HeroRepository repository;


    public Hero save(Hero hero) {
       return repository.save(hero);
    }

    public List<Hero> findByName(String name) {
        return repository.findByName(name);
    }

    public HeroUtilsService(HeroRepository repository) {
        this.repository = repository;
    }

    public Optional<Hero> findDistinctByHeroId(UUID id) {
        return repository.findDistinctById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Hero> findAll() {
        return repository.findAll();
    }

    public void deleteDistinctById(UUID id){
        repository.deleteById(id);
    }

    public List<Hero> findAllByNameContaining(String term){
        return repository.findAllByNameContaining(term);
    }
}
