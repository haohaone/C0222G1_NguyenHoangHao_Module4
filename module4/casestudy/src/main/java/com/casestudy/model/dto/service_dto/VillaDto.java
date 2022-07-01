package com.casestudy.model.dto.service_dto;

import javax.validation.constraints.Pattern;

public class VillaDto {
    @Pattern(regexp = "^DV-[0-9]{4}$", message = "Mã dịch vụ ")
    private String serviceId;

    private String serviceName;

    private Double serviceCost;

    private Double serviceArea;

    private Integer serviceMaxPeople;

    private Integer rentTypeId;

    private Integer serviceTypeId;

    private String standardRoom;

    private String description;

    private Double poolArea;

    private Integer floor;


}
