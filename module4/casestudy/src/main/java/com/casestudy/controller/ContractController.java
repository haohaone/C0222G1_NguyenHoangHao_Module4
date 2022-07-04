package com.casestudy.controller;

import com.casestudy.model.contract.AttachService;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Service;
import com.casestudy.service.furama_interface.contract.IAttachService;
import com.casestudy.service.furama_interface.contract.IContractDetail;
import com.casestudy.service.furama_interface.contract.IContract;
import com.casestudy.service.furama_interface.customer.CustomerService;
import com.casestudy.service.furama_interface.employee.EmployeeService;
import com.casestudy.service.furama_interface.service.ServiceSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContract contractService;

    @Autowired
    private IAttachService attachService;


    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceSer serviceSer;

    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("attachServiceList")
    private List<AttachService> attachServiceList(){
        return attachService.findAll();
    }

    @ModelAttribute("customerList")
    private List<Customer> customerList(){
        return customerService.findAll();
    }

    @ModelAttribute("serviceList")
    private List<Service> serviceList(){
        return serviceSer.findAll();
    }

    @ModelAttribute("employeeList")
    private List<Employee> employeeList(){
        return employeeService.findAll();
    }

    @GetMapping("")
    private String showContractList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Contract> contractList = contractService.findAll(PageRequest.of(page, 4));
        model.addAttribute("contractList", contractList);
        return "views/contract/contract-list";
    }

    @GetMapping("/detail/{id}")
    private String contractDetail(@PathVariable("id") int id, Model model) {
        Contract contract = contractService.findById(id);
        List<ContractDetail> contractDetailList = contract.getContractDetailList();
        model.addAttribute("contractDetailList", contractDetailList);
        model.addAttribute("contract", contract);
        return "views/contract/attach-service-list";
    }
}
