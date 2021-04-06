package pojo;


import lombok.*;

// we just want to represent the Employee data with these fields and ignore any other fields
@Getter @Setter
@ToString
public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;
    private int salary;
    private int department_id;

}
