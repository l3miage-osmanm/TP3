package fr.uga.l3miage.tp3.exo1.repositories;
import javax.persistence.*;
import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    public Set<UserEntity> findAllByMailContaining(String domaine);
}
