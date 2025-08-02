package com.ontToone.util;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
