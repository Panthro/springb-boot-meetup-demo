package meetups.rafa.springbootdemo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import meetups.rafa.springbootdemo.domain.Hero;
import meetups.rafa.springbootdemo.repository.HeroRepository;

@RestController
public class HeroController {

    private final HeroRepository heroRepository;

    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @PostMapping("/heroes")
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        return new ResponseEntity<>(heroRepository.save(hero), HttpStatus.CREATED);
    }

    @GetMapping("/heroes")
    public ResponseEntity<Page<Hero>> getHeroes(Pageable pageRequest) {
        return ResponseEntity.ok(heroRepository.findAll(pageRequest));
    }


}
