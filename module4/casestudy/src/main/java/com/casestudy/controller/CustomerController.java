package com.casestudy.controller;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.model.dto.customer_dto.CustomerCreateDto;
import com.casestudy.model.dto.customer_dto.CustomerEditDto;
import com.casestudy.service.furama_interface.customer.CustomerService;
import com.casestudy.service.furama_interface.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String showCustomerList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> customerList = customerService.findAll(PageRequest.of(page, 4));
        model.addAttribute("customerList", customerList);
        return "views/customer/customer-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") String id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/customer";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name = "name") String name,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         Model model) {
        Page<Customer> customerList = customerService.findByCustomerName(name, PageRequest.of(page, 4));
        model.addAttribute("customerList", customerList);
        return "views/customer/customer-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customerCreateDto", new CustomerCreateDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "views/customer/create-list";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customerCreateDto") CustomerCreateDto customerCreateDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "views/customer/create-list";
        }

        CustomerType customerType = customerTypeService.findById(Integer.parseInt(customerCreateDTO.getCustomerTypeId()));

        Customer customer = new Customer(customerCreateDTO.getCustomerId(),
                customerType,
                customerCreateDTO.getCustomerName(),
                customerCreateDTO.getCustomerBirthDay(),
                customerCreateDTO.getCustomerGender(),
                customerCreateDTO.getCustomerIdCard(),
                customerCreateDTO.getCustomerPhone(),
                customerCreateDTO.getCustomerEmail(),
                customerCreateDTO.getCustomerAddress(), 0);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerEditDto customerEditDto = new CustomerEditDto(customer.getCustomerId(),
                String.valueOf(customer.getCustomerType().getCustomerTypeId()),
                customer.getCustomerName(),
                customer.getCustomerBirthDay(),
                customer.getCustomerIdCard(),
                customer.getCustomerPhone(),
                customer.getCustomerEmail(),
                customer.getCustomerAddress(),
                customer.getCustomerGender());
        model.addAttribute("customerEditDto", customerEditDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "views/customer/edit-list";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("customerEditDto") CustomerEditDto customerEditDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "views/customer/edit-list";
        }

        CustomerType customerType = customerTypeService.findById(Integer.parseInt(customerEditDto.getCustomerTypeId()));

        Customer customer = new Customer(customerEditDto.getCustomerId(),
                customerType,
                customerEditDto.getCustomerName(),
                customerEditDto.getCustomerBirthDay(),
                customerEditDto.getCustomerGender(),
                customerEditDto.getCustomerIdCard(),
                customerEditDto.getCustomerPhone(),
                customerEditDto.getCustomerEmail(),
                customerEditDto.getCustomerAddress(), 0);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }
}
