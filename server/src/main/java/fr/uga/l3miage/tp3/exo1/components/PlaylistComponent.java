package fr.uga.l3miage.tp3.exo1.components;


import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Set;
@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;
    public PlaylistEntity getPlaylist(String name){

        return playlistRepository.findById(name).orElseThrow();
    }
    public PlaylistEntity addNewPlaylist(PlaylistEntity playlistEntity){
        return this.playlistRepository.save(playlistEntity);
    }
    /*Récupérez toutes les playlists, sans doublons qui ont une chanson particulière.*/
    public Set<PlaylistEntity> playlistSearchSong(SongEntity s){
        return playlistRepository.findAllBySongEntitiesContaining(s);
    }
}
