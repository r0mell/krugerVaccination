package com.kruger.krugerVaccination.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${security.jwt.secret}")
    private String key;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    private final Logger log = LoggerFactory
            .getLogger(JWTUtil.class);

    public JWTUtil() {
    }

    public String create(String id, String subject) {

        // The JWT signature algorithm used to sign the token

        System.out.println(subject);
        // new form JwT
        String builder1 = Jwts.builder().setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + ttlMillis * 1000))
                .signWith(SignatureAlgorithm.HS256, key).compact();

        return builder1;

    }

    public String getValue(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as
        // expected)
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(jwt).getBody();

        return claims.getSubject();
    }

    public String getKey(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as
        // expected)
        String claims = Jwts.parser().setSigningKey(key)
                .parseClaimsJws(jwt).getBody().getSubject();

        return claims;
    }
}