package ec.sasf.mscomppruebaAndreVelastegui.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    public static final String SECRET = "secretKey";

    private String createToken( Map<String, Object> claims, String userName){

        return Jwts.builder()
        .setClaims(claims)
        .setSubject(userName)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() +1000*60*30 ))
        .signWith(SignatureAlgorithm.HS256, getSignKey()).compact();
        
    }

    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);

    }

    public String generateToken(String userName){

        Map<String,Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token).getBody();
    }
    
}
