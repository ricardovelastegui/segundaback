package ec.sasf.mscomppruebaAndreVelastegui.services.authentication;

import ec.sasf.mscomppruebaAndreVelastegui.dto.SignupRequestDTO;
import ec.sasf.mscomppruebaAndreVelastegui.dto.UserDto;

public interface AuthService {

    UserDto signupClient(SignupRequestDTO signupRequestDTO);
    Boolean presentByEmail(String email);

    UserDto signupCompany(SignupRequestDTO signupRequestDTO);
    
}
