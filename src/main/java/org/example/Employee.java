package org.example;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private Integer id;
    private String name;
    private String department;
    private Boolean active;
    private Long salary;
    private String gender;

}
