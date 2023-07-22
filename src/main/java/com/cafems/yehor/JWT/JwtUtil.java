package com.cafems.yehor.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

//    private final String secret = "be25f6473ae55b918a0e2357d943181e2a7981e05667f3750eed829d8f862fb1";
    private final String secret = "y.nmhrYcy\\#jHdB\\9.EbJv!]VJu;Jbc[]qR,}5M^rGJ*6(8/tmf.C/.&>AbfJmF\"VbUW9?VJ5zQprHCsQ&]k\"^5@'eK?NM=ZZ[Q*KeuZqu}}}+NK]UK~S_kpW4SBf[<c&P{@~*xU@cz4[a=Pn9\\rRJx\\;]r&.sN*~..=wJtyVa%Vj}RsG8%-?9)X{kFmkD%_$*YhYZvZ:n<}r9++YtT'7%@6P,B2Fgp<FS-%bY:w&{VWpVy'BGG{;JJ\"//((TT!&";

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username, String role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject){
        // String encodedString = Base64.getEncoder().encodeToString(secret.getBytes());
        // 10 hours
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
