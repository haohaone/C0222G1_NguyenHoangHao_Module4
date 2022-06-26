package com.casestudy.model.contract;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Service;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", columnDefinition = "INT")
    private int contractId;

    @Column(name = "contract_start_date", columnDefinition = "DATE")
    private String startDate;

    @Column(name = "contract_end_date", columnDefinition = "DATE")
    private String endDate;

    @Column(name = "status_detail", columnDefinition = "BIT(1)")
    private Integer statusDetail;

    @Column(name = "status_delete", columnDefinition = "BIT(1)")
    private Integer statusDelete;

    @Column(name = "contract_deposit", columnDefinition = "DOUBLE")
    private String deposit;

    @Column(name = "contract_total_money", columnDefinition = "DOUBLE")
    private String totalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id", columnDefinition = "INT", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", columnDefinition = "VARCHAR(45)", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", columnDefinition = "VARCHAR(45)", referencedColumnName = "service_id")
    private Service service;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetailList;

    public int getContractId() {
        return contractId;
    }

    public Contract() {
    }

    public Contract(int contractId,
                    String startDate,
                    String endDate,
                    Integer statusDetail,
                    Integer statusDelete,
                    String deposit,
                    String totalMoney,
                    Employee employee,
                    Customer customer,
                    Service service) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statusDetail = statusDetail;
        this.statusDelete = statusDelete;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }


    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(Integer statusDetail) {
        this.statusDetail = statusDetail;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(Set<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
