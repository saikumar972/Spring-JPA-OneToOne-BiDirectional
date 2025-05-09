package com.ontToone.service;

import com.ontToone.dao.AddressRepository;
import com.ontToone.entity.Address;
import com.ontToone.util.AddressDTO;
import com.ontToone.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public AddressDTO getAddressById(Long id){
        Address address= addressRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
        return Mapper.convertAddressToAddressDTO(address,true);
    }
}
