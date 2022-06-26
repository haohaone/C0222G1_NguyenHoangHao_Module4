package com.casestudy.service.imp.employee;

import com.casestudy.service.furama_interface.employee.EmployeeService;

public class EmployeeServiceImp implements EmployeeService {
    private static final String ACCOUNT_REGEX = "^[a-z0-9]{6,}@furama.com$",
            PHONE_REGEX = "^((090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7}))$",
            EMAIL_REGEX = "^([a-z0-9]{6,}@[a-z]+(.[a-z]+)+)$",
            CMND_REGEX = "^[0-9]{9}$";;

}
