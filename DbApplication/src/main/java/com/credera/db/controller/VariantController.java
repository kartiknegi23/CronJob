package com.credera.db.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credera.db.model.Variant;
import com.credera.db.service.VariantService;

@RestController
@RequestMapping("/api/variant")
public class VariantController {

	@Autowired
    private VariantService variantService;

    @PostMapping("/add")
    public ResponseEntity<Optional<Variant>> addVariant(@RequestBody Variant variant) {
        return ResponseEntity.ok(variantService.saveVariant(variant));
    }
}
