package meetups.rafa.springbootdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import meetups.rafa.springbootdemo.domain.Hero;

public interface HeroRepository extends MongoRepository<Hero,String> {
}
