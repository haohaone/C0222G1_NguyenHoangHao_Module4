package com.casestudy.model.customer;

import com.casestudy.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id", columnDefinition = "VARCHAR(45)")
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id", columnDefinition = "INT")
    private CustomerType customerType;

    @Column(name = "customer_name", columnDefinition = "VARCHAR(45)")
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String customerBirthDay;

    @Column(name = "customer_gender", columnDefinition = "BIT(1)")
    private Integer customerGender;

    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(45)")
    private String customerIdCard;

    @Column(name = "customer_phone", columnDefinition = "VARCHAR(45)")
    private String customerPhone;

    @Column(name = "customer_email", columnDefinition = "VARCHAR(45)")
    private String customerEmail;

    @Column(name = "customer_address", columnDefinition = "VARCHAR(45)")
    private String customerAddress;

    @Column(name = "status_delete", columnDefinition = "BIT(1)")
    private Integer statusDelete;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractList;

    public Customer() {
    }

    public Customer(String customerId,
                    CustomerType customerType,
                    String customerName,
                    String customerBirthDay,
                    Integer customerGender,
                    String customerIdCard,
                    String customerPhone,
                    String customerEmail,
                    String customerAddress,
                    Integer statusDelete) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.statusDelete = statusDelete;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }
}
