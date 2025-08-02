package com.ontToone.entity;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="address_oneToOne")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long id;
    private String street;
    private String district;
    private String state;
    @OneToOne(mappedBy = "address",fetch = FetchType.EAGER)
    private Student student;

    public void setStudent(Student student){
        this.student=student;
        if(student!=null&& student.getAddress()!=this){
            student.setAddress(this);
        }
    }
}
