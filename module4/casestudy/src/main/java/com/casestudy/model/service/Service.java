package com.casestudy.model.service;

import javax.persistence.*;

@Entity(name = "service")
public class Service {

    @Id
    @Column(name = "service_id", columnDefinition = "VARCHAR(45)")
    private String serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45)")
    private String serviceName;

    @Column(name = "service_cost", columnDefinition = "DOUBLE")
    private Double serviceCost;

    @Column(name = "service_area", columnDefinition = "DOUBLE")
    private Double serviceArea;

    @Column(name = "service_max_people", columnDefinition = "INT")
    private Integer serviceMaxPeople;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @Column(name = "standard_room", columnDefinition = "VARCHAR(45)")
    private String standardRoom;

    @Column(name = "description_other_convenience", columnDefinition = "VARCHAR(45)")
    private String description;

    @Column(name = "pool_area", columnDefinition = "DOUBLE")
    private Double poolArea;

    @Column(name = "number_of_floors", columnDefinition = "INT")
    private Integer floor;

    @Column(name = "status_delete", columnDefinition = "INT")
    private Integer statusDelete;

    public Service() {
    }

    public Service(String serviceId,
                   String serviceName,
                   Double serviceCost,
                   Double serviceArea,
                   Integer serviceMaxPeople,
                   RentType rentType,
                   ServiceType serviceType,
                   String standardRoom,
                   String description,
                   Double poolArea,
                   Integer floor,
                   Integer statusDelete) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.serviceArea = serviceArea;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
        this.statusDelete = statusDelete;
    }

    public Service(String serviceId,
                   String serviceName,
                   Double serviceCost,
                   Double serviceArea,
                   Integer serviceMaxPeople,
                   RentType rentType,
                   ServiceType serviceType,
                   String standardRoom,
                   String description,
                   Integer floor,
                   Integer statusDelete) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.serviceArea = serviceArea;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.floor = floor;
        this.statusDelete = statusDelete;
    }

    public Service(String serviceId,
                   String serviceName,
                   Double serviceCost,
                   Double serviceArea,
                   Integer serviceMaxPeople,
                   RentType rentType,
                   ServiceType serviceType,
                   Integer statusDelete) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.serviceArea = serviceArea;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.statusDelete = statusDelete;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }
}
