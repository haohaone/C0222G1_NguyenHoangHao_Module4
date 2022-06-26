package com.casestudy.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id", columnDefinition = "INT")
    private Integer serviceTypeId;

    @Column(name = "service_type_name", columnDefinition = "VARCHAR(45)")
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(Integer serviceTypeId, String serviceTypeName, Set<Service> serviceList) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.serviceList = serviceList;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Set<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
