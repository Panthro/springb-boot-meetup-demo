package meetups.rafa.springbootdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import meetups.rafa.springbootdemo.domain.Hero;
import meetups.rafa.springbootdemo.repository.HeroRepository;

import static meetups.rafa.springbootdemo.domain.Hero.Universe.DC;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Autowired
    HeroRepository heroRepository;


    @Before
    public void setUp() {
        heroRepository.deleteAll();
    }

    @After
    public void tearDown() {
        heroRepository.deleteAll();
    }

    private void addBatman() {
        final Hero hero = new Hero();
        hero.setName("Batman");
        hero.setUniverse(DC);
        heroRepository.save(hero);
    }

    @Test
    public void createHero() {
        final long initialCount = heroRepository.count();

        addBatman();

        assertThat(heroRepository.count()).isGreaterThan(initialCount);

    }


}
