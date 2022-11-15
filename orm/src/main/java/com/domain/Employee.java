package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlEnum;
import java.time.LocalDate;

@XmlEnum
enum Gender {
    Male,
    Female
}

@XmlEnum
enum EmployeeStatus {
    Active,
    Inactive
}

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstname;

    @NotNull
    @Column(name = "last_name")
    private String lastname;

    @NotNull
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "employee_status")
    private EmployeeStatus employeeStatus;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = Gender.valueOf(String.valueOf(gender));}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public LocalDate getJoiningDate() {return joiningDate;}
    public void setJoiningDate(LocalDate email) {this.joiningDate = joiningDate;}

    public EmployeeStatus getEmployeeStatus() {return employeeStatus;}
    public void setEmployeeStatus(EmployeeStatus EmployeeStatus) {this.employeeStatus = EmployeeStatus.valueOf(String.valueOf(employeeStatus));}
}
