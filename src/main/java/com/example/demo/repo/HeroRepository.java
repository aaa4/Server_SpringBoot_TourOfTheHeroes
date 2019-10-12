package com.example.demo.repo;

import com.example.demo.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HeroRepository extends JpaRepository<Hero, UUID> {
    List<Hero> findByName(String name);
    Optional<Hero> findDistinctById(UUID id);
    List<Hero> findAllByNameContaining(String term);
}
