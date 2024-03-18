package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;


import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;
    public ArtistEntity getArtist(String name){

        return artistRepository.findById(name).orElseThrow();
    }
    public ArtistEntity addNewArtist(ArtistEntity artistEntity){
        return this.artistRepository.save(artistEntity);
    }
    /*Récupérez le nombre d'artistes en fonction de leur genre musical.*/
    public int nbArtisteGenre(GenreMusical g){
        return artistRepository.findAllByGenreMusical(g).size();
    }
}
