package com.casestudy.controller;

import com.casestudy.model.contract.Contract;
import com.casestudy.service.furama_interface.contract.IAttachService;
import com.casestudy.service.furama_interface.contract.IContract;
import com.casestudy.service.furama_interface.customer.CustomerService;
import com.casestudy.service.furama_interface.employee.EmployeeService;
import com.casestudy.service.furama_interface.service.ServiceSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract-rest")
public class ContractRestController {
    @Autowired
    private IContract contractService;

    @GetMapping("")
    private ResponseEntity<Page<Contract>> showContractList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Contract> contractList = contractService.findAll(PageRequest.of(page, 4));
        if (contractList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractList, HttpStatus.OK);
        }
    }
//
//    @PostMapping("")
//    private ResponseEntity<?> create(@RequestBody)
}
