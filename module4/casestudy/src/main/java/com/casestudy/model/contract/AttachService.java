package com.casestudy.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id", columnDefinition = "INT")
    private Integer attachServiceId;

    @Column(name = "attach_service_name", columnDefinition = "VARCHAR(45)")
    private String attachServiceName;

    @Column(name = "attach_service_cost", columnDefinition = "DOUBLE")
    private Double attachServiceCost;

    @Column(name = "attach_service_unit", columnDefinition = "VARCHAR(45)")
    private String attachServiceUnit;

    @Column(name = "attach_service_status", columnDefinition = "VARCHAR(45)")
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetailList;

    public AttachService() {
    }

    public AttachService(Integer attachServiceId,
                         String attachServiceName,
                         Double attachServiceCost,
                         String attachServiceUnit,
                         String attachServiceStatus,
                         Set<ContractDetail> contractList) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetailList = contractList;
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractList() {
        return contractDetailList;
    }

    public void setContractList(Set<ContractDetail> contractList) {
        this.contractDetailList = contractList;
    }
}
