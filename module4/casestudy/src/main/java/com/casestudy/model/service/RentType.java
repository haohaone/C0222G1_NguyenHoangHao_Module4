package com.casestudy.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id", columnDefinition = "INT")
    private Integer rentTypeId;

    @Column(name = "rent_type_name", columnDefinition = "VARCHAR(45)")
    private String rentTypeName;

    @Column(name = "rent_type_cost", columnDefinition = "DOUBLE")
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> serviceList;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, Double rentTypeCost, Set<Service> serviceList) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.serviceList = serviceList;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Set<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
