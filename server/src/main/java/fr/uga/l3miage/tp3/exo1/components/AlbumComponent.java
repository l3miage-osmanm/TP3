package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;
    public AlbumEntity addAlbum(AlbumEntity almb){
        return this.albumRepository.save(almb);
    }
    public AlbumEntity getAlbum(String name){

        return albumRepository.findById(name).orElseThrow();
    }

}
