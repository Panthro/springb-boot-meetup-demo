package meetups.rafa.springbootdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import meetups.rafa.springbootdemo.domain.Hero;
import meetups.rafa.springbootdemo.repository.HeroRepository;

import static meetups.rafa.springbootdemo.domain.Hero.Universe.DC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootDemoApplicationTests {

    @Autowired
    HeroRepository heroRepository;


    @Autowired
    MockMvc mockMvc;

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


    @Test
    public void webGetHeroes() throws Exception {

        addBatman();

        mockMvc
                .perform(get("/heroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].name").value("Batman"));


    }


}
