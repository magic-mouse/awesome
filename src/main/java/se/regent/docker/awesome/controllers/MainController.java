package se.regent.docker.awesome.controllers;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    private static final String key = "dksladksuiods98dsa0+90q343n32m32";

    @RequestMapping("login")
    @GetMapping()
    public ResponseEntity login(@RequestParam String username, @RequestParam String password ){


       if(username.equals("Hello") && password.equals("World")){
           String jwtString = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, key).compact();

           return ResponseEntity.ok("{\"token\":\"" + jwtString + "\"}");
       }


        return ResponseEntity.status(403).body("Nope no access");
    }

}
