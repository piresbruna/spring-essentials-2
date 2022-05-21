package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved(){
        return Anime.builder().name("Hajime no Ippo").build();
    }

    public static Anime createValidAnime(){
        return Anime.builder().id(1L).name("Hajime no Ippo").build();
    }

    public static Anime createValidUpdatedAnime(){
        return Anime.builder().id(1L).name("Hajime no Ippo 2").build();
    }
}
