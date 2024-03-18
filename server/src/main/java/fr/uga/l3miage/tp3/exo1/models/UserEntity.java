package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.Set;
/*Dans l'entité UserEntity ajoutez l'annotation @Builder qui permet la création d'un builder(voir le patron builder).
Cependant, si vous n'ajoutez que cette annotation, vous allez avoir une erreur, vous devez donc utiliser les annotations @NoArgsConstructor,
qui va générer un constructeur sans paramètres, et l'annotation @AllArgsConstructor qui génère un constructeur avec tous les attributs de la classe en paramètres.*/
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String name;
    @Email
    private String mail;

    @OneToMany
    @JoinColumn(name = "name")
    private Set<PlaylistEntity> playlistEntities;


}
