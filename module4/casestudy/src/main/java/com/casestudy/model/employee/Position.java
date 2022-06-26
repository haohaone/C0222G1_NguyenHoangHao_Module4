package com.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id", columnDefinition = "INT")
    private Integer positionId;

    @Column(name = "position_name", columnDefinition = "VARCHAR(45)")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employeeList;

    public Position() {
    }

    public Position(Integer positionId, String positionName, Set<Employee> employeeList) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employeeList = employeeList;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
