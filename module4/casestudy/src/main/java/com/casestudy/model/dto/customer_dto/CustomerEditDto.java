package com.casestudy.model.dto.customer_dto;

import com.casestudy.utils.CheckAge18Constraint;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerEditDto {

    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Nhập sai định dạng mã khách hàng")
    private String customerId;

    private String customerTypeId;

    @NotEmpty(message = "Tên khách hàng không được để trống")
    private String customerName;

    @CheckAge18Constraint
    @NotEmpty(message = "Ngày sinh khách hàng không được để trống")
    private String customerBirthDay;

    @Pattern(regexp = "^[0-9]{9}$", message = "CMND phải đủ 9 số")
    private String customerIdCard;

    @Pattern(regexp = "^((090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7}))$",
            message = "Nhập sai định dạng SĐT 090-xxxxxxx 091-xxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx")
    private String customerPhone;

    @Pattern(regexp = "^([a-z0-9]{6,}@[a-z]+(.[a-z]+)+)$", message = "Nhập sai định dạng email")
    private String customerEmail;

    @NotEmpty(message = "Địa chỉ khách hàng không được để trống")
    private String customerAddress;

    private Integer customerGender;

    public CustomerEditDto() {
    }

    public CustomerEditDto(@Pattern(regexp = "^KH-[0-9]{4}$",
            message = "Nhập sai định dạng mã khách hàng") String customerId,
                           String customerTypeId,
                           @NotEmpty(message = "Tên khách hàng không được để trống") String customerName,
                           @NotEmpty(message = "Ngày sinh khách hàng không được để trống") String customerBirthDay,
                           @NotEmpty(message = "CMND khách hàng không được để trống") String customerIdCard,
                           @Pattern(regexp = "^((090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7}))$",
                                   message = "Nhập sai định dạng SĐT 090-xxxxxxxxx 091-xxxxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx") String customerPhone,
                           @Pattern(regexp = "^([a-z0-9]{6,}@[a-z]+(.[a-z]+)+)$",
                                   message = "Nhập sai định dạng email") String customerEmail,
                           @NotEmpty(message = "Địa chỉ khách hàng không được để trống") String customerAddress,
                           Integer customerGender) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerGender = customerGender;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
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

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }
}
