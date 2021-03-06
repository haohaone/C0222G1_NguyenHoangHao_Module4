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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private CustomerService customerService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList(){
        return customerTypeService.findAll();
    }

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

    @GetMapping("/search")
    public String search(@RequestParam(name = "search", required = false, defaultValue = "none") String search,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         Model model,
                         @CookieValue(value = "cookieSearch", defaultValue = "0") String cookieSearch,
                         HttpServletResponse response) {
        Page<Customer> customerList;
        if (search.equals("none")){
            customerList = customerService.findByCustomerName(cookieSearch, PageRequest.of(page, 2));
            model.addAttribute("customerList", customerList);
            Cookie cookie = new Cookie("cookieSearch", cookieSearch);
            cookie.setMaxAge(60 * 5);
            response.addCookie(cookie);
            model.addAttribute("cookieSearch", cookieSearch);
            return "views/customer/customer-list";
        }else {
            customerList = customerService.findByCustomerName(search, PageRequest.of(page, 2));
            model.addAttribute("customerList", customerList);
            Cookie cookie = new Cookie("cookieSearch", search);
            cookie.setMaxAge(60 * 5);
            response.addCookie(cookie);
            model.addAttribute("cookieSearch", cookieSearch);
            return "views/customer/customer-list";
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customerCreateDto", new CustomerCreateDto());
        return "views/customer/create-list";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customerCreateDto") CustomerCreateDto customerCreateDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
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
                customerCreateDTO.getCustomerAddress());
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
        return "views/customer/edit-list";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("customerEditDto") CustomerEditDto customerEditDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
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
                customerEditDto.getCustomerAddress());
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }
}
