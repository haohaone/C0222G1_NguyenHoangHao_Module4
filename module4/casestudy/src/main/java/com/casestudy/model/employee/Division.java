package com.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", columnDefinition = "INT")
    private Integer divisionId;

    @Column(name = "division_name", columnDefinition = "VARCHAR(45)")
    private String divisionName;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employeeList;

    public Division() {
    }

    public Division(Integer divisionId, String divisionName, Set<Employee> employeeList) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employeeList = employeeList;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
