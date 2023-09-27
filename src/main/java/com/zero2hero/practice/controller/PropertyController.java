package com.zero2hero.practice.controller;

import com.zero2hero.practice.dto.PropertyDTO;
import com.zero2hero.practice.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        return new ResponseEntity<>(propertyService.saveProperty(propertyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        return new ResponseEntity<>(propertyService.updateProperty(propertyDTO,propertyId), HttpStatus.OK);
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePartialProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        return new ResponseEntity<>(propertyService.updatePartialProperty(propertyDTO,propertyId), HttpStatus.OK);
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> deleteProperty(@PathVariable Long propertyId){
        return new ResponseEntity<>(propertyService.deleteProperty(propertyId), HttpStatus.OK);
    }
}
