package com.authentification.login.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JWTUtil  {
    private String secretKey="123jjjj";
    public <T> T extractClaims(String token , Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);

    }

    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }

    public Date Expiration(String token){
        return extractClaims(token,Claims::getExpiration);
    }
    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    //cette methode montre si le token est validee ou nom
    public Boolean TockenExpiration(String token){
        return Expiration(token).before(new Date());
    }
    //generer token

    public String generateToken(String username, String role){

        Map<String,Object> claims =new HashMap<>();
        claims.put("role",role);
        return createToken(claims,username);
    }

    // creation du tocken
    private String createToken(Map<String,Object> claims,String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+10000*60*10))
                .signWith(SignatureAlgorithm.HS256,secretKey).compact();
    }

    public Boolean validationToken(String token , UserDetails userDetails){
        final String username= extractUsername(token);
        return (username.equals(userDetails.getUsername())&& !TockenExpiration(token));
    }


}
