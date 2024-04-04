package ec.sasf.mscomppruebaAndreVelastegui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.sasf.mscomppruebaAndreVelastegui.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findFirstByEmail(String email);
    
}
