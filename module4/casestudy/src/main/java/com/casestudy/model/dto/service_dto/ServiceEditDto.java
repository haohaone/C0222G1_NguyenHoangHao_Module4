package com.casestudy.model.dto.service_dto;

import com.casestudy.utils.CheckDoubleConstraint;
import com.casestudy.utils.CheckIntegerConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class ServiceEditDto implements Validator {
    @Pattern(regexp = "^DV-[0-9]{4}$", message = "Mã dịch vụ sai định dạng")
    private String serviceId;

    private String serviceName;

    @CheckDoubleConstraint(message = "Nhập sai định dạng giá thuê")
    private String serviceCost;

    @CheckDoubleConstraint(message = "Nhập sai định dạng diện tích sử dụng")
    private String serviceArea;

    @CheckIntegerConstraint(message = "Nhập sai định dạng số người tối đa")
    private String serviceMaxPeople;

    private Integer rentTypeId;

    private Integer serviceTypeId;

    private String standardRoom;

    private String description;

    private String poolArea;

    private String floor;

    public ServiceEditDto() {
    }

    public ServiceEditDto(@Pattern(regexp = "^DV-[0-9]{4}$", message = "Mã dịch vụ ") String serviceId,
                            String serviceName,
                            String serviceCost,
                            String serviceArea,
                            String serviceMaxPeople,
                            Integer rentTypeId,
                            Integer serviceTypeId,
                            String standardRoom,
                            String description,
                            String poolArea, String floor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.serviceArea = serviceArea;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
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

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
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

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceEditDto serviceEditDto = (ServiceEditDto) target;
        if (serviceEditDto.getServiceName().equals("Villa")){
            try {
                double checkDouble = Double.parseDouble(serviceEditDto.poolArea);
                if (checkDouble < 0){
                    errors.rejectValue("poolArea", "poolAreaNegative.invalidFormat");
                }
            } catch (NumberFormatException e) {
                errors.rejectValue("poolArea", "poolAreaString.invalidFormat");
            }
        }

        if (serviceEditDto.getServiceName().equals("Villa") || serviceEditDto.getServiceName().equals("House")){
            try {
                double checkDouble = Double.parseDouble(serviceEditDto.floor);
                if (checkDouble < 0){
                    errors.rejectValue("floor", "floorNegative.invalidFormat");
                }
            } catch (NumberFormatException e) {
                errors.rejectValue("floor", "floorString.invalidFormat");
            }

            if (serviceEditDto.description.isEmpty()){
                errors.rejectValue("description", "description.invalidFormat");
            }

            if (serviceEditDto.standardRoom.isEmpty()){
                errors.rejectValue("standardRoom", "standardRoom.invalidFormat");
            }
        }
    }
}
