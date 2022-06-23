package com.demo_validation.validation.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Integer id;

    @Size(min = 5, max = 45, message = "Không được nhập dưới 5 và lớn hơn 45 ký tự")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 5, max = 45, message = "Không được nhập dưới 5 và lớn hơn 45 ký tự")
    @Column(name = "last_name")
    private String lastName;

    private String age;

    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$",
            message = "Nhập sai định dạng email")
    private String gmail;

    @Pattern(regexp = "^[0-9]{9}$", message = "Nhập sai định dạng số điện thoại")
    private String phone;

    public User(Integer id,
                @Size(min = 5, max = 45, message = "Không được nhập dưới 5 và lớn hơn 45 ký tự") String firstName,
                @Size(min = 5, max = 45, message = "Không được nhập dưới 5 và lớn hơn 45 ký tự") String lastName,
                String age,
                @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$",
                        message = "Nhập sai định dạng email") String gmail,
                @Pattern(regexp = "^[0-9]{9}$", message = "Nhập sai định dạng số điện thoại") String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gmail = gmail;
        this.phone = phone;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            int checkAge = Integer.parseInt(user.age);
            if (checkAge < 18) {
                errors.rejectValue("age", "age18.invalidFormat");
            }
        } catch (NumberFormatException e) {
            errors.rejectValue("age", "age.invalidFormat");
        }
    }
}
