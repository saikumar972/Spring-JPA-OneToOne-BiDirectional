package com.ontToone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "student_oneToOne")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
/*@JsonIdentityInfo(
          generator = ObjectIdGenerators.PropertyGenerator.class,
          property = "id"
)*/
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Long id;
    private String name;
    private String department;
    private String subjects;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="address_fk_id",referencedColumnName = "address_id")
    private Address address;

    public void setAddress(Address address){
        this.address=address;
        if(address!=null&&address.getStudent()!=this){
            address.setStudent(this);
        }
    }
}
