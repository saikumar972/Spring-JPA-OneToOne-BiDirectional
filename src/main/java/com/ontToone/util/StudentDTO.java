package com.ontToone.util;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class StudentDTO {
    @JsonProperty(value = "student_id")
    private Long id;
    private String name;
    private String department;
    @JsonProperty(value="listOfSubjects")
    private List<String> subjects;
    //@JsonUnwrapped
    private AddressDTO addressDTO;
}
