package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;
    public SongEntity getUser(String name){
        return songRepository.findById(name).orElseThrow();
    }
    public SongEntity createSong(){
        long a=3;
        Duration s = Duration.ofMinutes(a);
        AlbumEntity alb=new AlbumEntity();
        ArtistEntity art=new ArtistEntity();
        SongEntity songEntity = SongEntity
                .builder()
                .duration(s)
                .title("song")
                .albumEntity(alb)
                .artistEntity(art)
                .build();
        return songRepository.save(songEntity);
    }
    public SongEntity updateAlbum(String name,AlbumEntity Almb){
        SongEntity songEntity = songRepository.findById(name).orElseThrow();
        songEntity.setAlbumEntity(Almb);
        return songRepository.save(songEntity);
    }
    public void deleteSong(String name){
        songRepository.deleteById(name);
    }

    /*Récupérez une chanson dont la durée est comprise dans un interval donné*/
    public Set<SongEntity> getSongInDuration(Duration start, Duration end ){
        return songRepository.findByDurationBetween(start,end);}

}
