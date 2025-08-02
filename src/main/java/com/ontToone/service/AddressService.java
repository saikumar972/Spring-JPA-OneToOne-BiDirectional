package com.ontToone.service;

import com.ontToone.dao.AddressRepository;
import com.ontToone.dao.StudentRepository;
import com.ontToone.entity.Address;
import com.ontToone.entity.Student;
import com.ontToone.util.AddressDTO;
import com.ontToone.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    StudentRepository studentRepository;

    public AddressDTO addAddress(AddressDTO addressDTO){
        Address address=Mapper.ConvertAddressDtoToEntity(addressDTO,true);
        Student student=address.getStudent();
        if(student!=null){
            student.setAddress(address);
            Student savedStudent=studentRepository.save(student);
            return Mapper.convertAddressEntityToDto(savedStudent.getAddress(),true);
        }
        else {
            Address savedAddress = addressRepository.save(address);
            return Mapper.convertAddressEntityToDto(savedAddress, true);
        }
    }

    public AddressDTO getAddressById(Long id){
        Address address= addressRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
        return Mapper.convertAddressEntityToDto(address,true);
    }
}
