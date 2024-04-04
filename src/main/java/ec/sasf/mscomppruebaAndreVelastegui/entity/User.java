package ec.sasf.mscomppruebaAndreVelastegui.entity;

import ec.sasf.mscomppruebaAndreVelastegui.dto.UserDto;
import ec.sasf.mscomppruebaAndreVelastegui.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "theusers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;


    private String email;

    private String password;
    private String name;
    private String lastname;
    private String phone;
    private UserRole role;


    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setEmail(email);  
        userDto.setRole(role);
        return userDto; 
      }
    
    
}
