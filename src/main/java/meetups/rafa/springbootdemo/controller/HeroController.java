package meetups.rafa.springbootdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import meetups.rafa.springbootdemo.domain.Hero;

@RestController
public class HeroController {

    private List<Hero> heroes = new ArrayList<>();

    @PostMapping("/heroes")
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        heroes.add(hero);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getHeroes(){
        return ResponseEntity.ok(heroes);
    }


}
