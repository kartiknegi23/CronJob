package com.credera.db.controller;

import com.credera.db.model.MasterVariant;
import com.credera.db.service.MasterVariantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/masterVariant")
public class MasterVariantController {

    @Autowired
    private MasterVariantService masterVariantService;

    @PostMapping("/add")
    public ResponseEntity<Optional<MasterVariant>> addMasterVariant(@RequestBody MasterVariant masterVariant) {
        return ResponseEntity.ok(masterVariantService.saveMasterVariant(masterVariant));
    }
}
