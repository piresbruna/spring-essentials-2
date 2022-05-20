package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
//        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 8L);
//        log.info(entity);
//
//        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 10L);
//        log.info(object);
//
//        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
//        log.info(Arrays.toString(animes));
//
//        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
//        });
//        log.info(exchange.getBody());

//        Anime captainTsubasa = Anime.builder().name("Captain Tsubasa").build();
//        Anime captainTsubasaSaved = new RestTemplate().postForObject("http://localhost:8080/animes/", captainTsubasa, Anime.class);
//        log.info("saved anime {}", captainTsubasaSaved);

        Anime samuraiX = Anime.builder().name("Samurai X").build();
        ResponseEntity<Anime> samuraiXSaved = new RestTemplate().exchange("http://localhost:8080/animes/", HttpMethod.POST, new HttpEntity<>(samuraiX, createJasonHeader()), Anime.class);
        log.info("saved anime {}", samuraiXSaved);

        Anime animeToBeUpdated = samuraiXSaved.getBody();
        animeToBeUpdated.setName("Samurai X 2");

        ResponseEntity<Void> samuraiXUpdated = new RestTemplate().exchange("http://localhost:8080/animes/", HttpMethod.PUT, new HttpEntity<>(animeToBeUpdated, createJasonHeader()), Void.class);
        log.info(samuraiXUpdated);

        ResponseEntity<Void> samuraiXDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}", HttpMethod.DELETE, null, Void.class, animeToBeUpdated.getId());
        log.info(samuraiXDeleted);
    }

    private static HttpHeaders createJasonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
