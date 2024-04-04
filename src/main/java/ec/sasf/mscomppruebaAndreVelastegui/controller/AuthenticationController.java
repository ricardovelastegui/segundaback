package ec.sasf.mscomppruebaAndreVelastegui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RestController;

import ec.sasf.mscomppruebaAndreVelastegui.dto.SignupRequestDTO;
import ec.sasf.mscomppruebaAndreVelastegui.dto.UserDto;
import ec.sasf.mscomppruebaAndreVelastegui.services.authentication.AuthService;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/company/signup")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO){
        if(authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("Email already in use", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/client/signup")
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO){
        if(authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("Company already in use", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
    
}
