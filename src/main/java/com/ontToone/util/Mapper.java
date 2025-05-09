package com.ontToone.util;

import com.ontToone.entity.Address;
import com.ontToone.entity.Student;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Mapper {
    public static Student convertDtoToEntity(StudentDTO studentDTO,boolean includeAddress){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setDepartment(studentDTO.getDepartment());
        student.setSubjects(studentDTO.getSubjects().stream().collect(Collectors.joining(",")));
        if (includeAddress && studentDTO.getAddressDTO() != null) {
            student.setAddress(ConvertAddressDTOToAddress(studentDTO.getAddressDTO(), false)); // ✅ correct direction
        }
        return student;
    }

    public static StudentDTO convertEntityToDto(Student student, boolean includeAddress){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setDepartment(student.getDepartment());
        studentDTO.setSubjects(Arrays.stream(student.getSubjects().split(",")).toList());
        if(includeAddress)
            studentDTO.setAddressDTO(convertAddressToAddressDTO(student.getAddress(),false));
        return studentDTO;
    }

    public static Address ConvertAddressDTOToAddress(AddressDTO addressDTO, boolean includeStudent){
        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setDistrict(addressDTO.getDistrict());
        address.setState(addressDTO.getState());
        if(includeStudent)
            address.setStudent(convertDtoToEntity(addressDTO.getStudentDTO(),false));
        return address;
    }

    public static AddressDTO convertAddressToAddressDTO(Address address, boolean includeStudent){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setDistrict(address.getDistrict());
        addressDTO.setState(address.getState());
        if (includeStudent && address.getStudent() != null) {
            addressDTO.setStudentDTO(convertEntityToDto(address.getStudent(), false)); // avoid infinite loop
        }
        return addressDTO;
    }

}
