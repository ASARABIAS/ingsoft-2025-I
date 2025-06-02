package com.example.demo_singleton.controller;

import com.example.demo_singleton.config.ConfigurationManager;
import com.example.demo_singleton.service.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingletonController {

    @Autowired
    private SingletonService configService;

    @GetMapping("/")
    public ResponseEntity<?> config(@RequestParam(required = false,defaultValue = "app.name") String key){


        try{
            //String keyValue = this.configService.getKeyValue(key);
            String keyValue = this.configService.getDIKeyValue(key);
            return ResponseEntity.ok("Key value: "+keyValue);

        }catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }


    }

}
