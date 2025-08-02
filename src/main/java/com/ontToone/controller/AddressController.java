package com.ontToone.controller;

import com.ontToone.service.AddressService;
import com.ontToone.util.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("/add")
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO){
        AddressDTO addressResponse=addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }
}
