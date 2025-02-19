package com.credera.db.controller;

import com.credera.db.model.Price;
import com.credera.db.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/add")
    public ResponseEntity<Optional<Price>> addPrice(@RequestBody Price price){
        return ResponseEntity.ok(priceService.savePrice(price));
    }
}
