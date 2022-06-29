package com.casestudy.model.dto.employee_dto;

import com.casestudy.utils.CheckAge18Constraint;
import com.casestudy.utils.CheckDoubleConstraint;
import com.casestudy.utils.CheckUserNameConstraint;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeeEditDto {
    private Integer employeeId;

    @NotEmpty(message = "Tên nhân viên không được để trống")
    private String employeeName;

    @CheckAge18Constraint(message = "Ngày sinh nhân viên không đủ 18 tuổi")
    @NotEmpty(message = "Ngày sinh khách hàng không được để trống")
    private String employeeBirthDay;

    @Pattern(regexp = "^[0-9]{9}$", message = "CMND phải đủ 9 số")
    private String employeeIdCard;

    @CheckDoubleConstraint(message = "Lương nhân viên không được nhập số và phải lớn hơn 0")
    private String employeeSalary;

    @Pattern(regexp = "^((090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7}))$",
            message = "Nhập sai định dạng SĐT 090-xxxxxxx 091-xxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx")
    private String employeePhone;

    @Pattern(regexp = "^([a-z0-9]{6,}@[a-z]+(.[a-z]+)+)$", message = "Nhập sai định dạng email")
    private String employeeEmail;

    @NotEmpty(message = "Địa chỉ khách hàng không được để trống")
    private String employeeAddress;
    private Integer positionId;
    private Integer educationDegreeId;
    private Integer divisionId;

    private String userName;

    public EmployeeEditDto() {
    }

    public EmployeeEditDto(Integer employeeId, @NotEmpty(message = "Tên nhân viên không được để trống") String employeeName,
                             @NotEmpty(message = "Ngày sinh khách hàng không được để trống") String employeeBirthDay,
                             @Pattern(regexp = "^[0-9]{9}$", message = "CMND phải đủ 9 số") String employeeIdCard,
                             String employeeSalary,
                             @Pattern(regexp = "^((090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7}))$",
                                     message = "Nhập sai định dạng SĐT 090-xxxxxxx 091-xxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx") String employeePhone,
                             @Pattern(regexp = "^([a-z0-9]{6,}@[a-z]+(.[a-z]+)+)$", message = "Nhập sai định dạng email") String employeeEmail,
                             @NotEmpty(message = "Địa chỉ khách hàng không được để trống") String employeeAddress,
                             Integer positionId,
                             Integer educationDegreeId,
                             Integer divisionId,
                             String userName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthDay = employeeBirthDay;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.userName = userName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(String employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
