package com.criptocoinstests.criptotests.controller;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.criptocoinstests.criptotests.service.CriptoService;
@RestController
public class CriptoController {
    @Autowired
    CriptoService criptoService;

    @GetMapping("/all")
    public ResponseEntity<String> getGlobal() {
        return criptoService.searchCripto();
    }
}
