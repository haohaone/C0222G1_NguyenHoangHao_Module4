package com.casestudy.controller;

import com.casestudy.model.dto.employee_dto.EmployeeCreateDto;
import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.EducationDegree;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.employee.Position;
import com.casestudy.model.login.User;
import com.casestudy.service.furama_interface.employee.DivisionService;
import com.casestudy.service.furama_interface.employee.EducationDegreeService;
import com.casestudy.service.furama_interface.employee.EmployeeService;
import com.casestudy.service.furama_interface.employee.PositionService;
import com.casestudy.service.furama_interface.login.UserService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String showEmployeeList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Employee> employeeList = employeeService.findAll(PageRequest.of(page, 4));
        model.addAttribute("employeeList", employeeList);
        return "views/employee/employee-list";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         Model model) {
        Page<Employee> employeeList = employeeService.findByEmployeeName(name, PageRequest.of(page, 4));
        model.addAttribute("employeeList", employeeList);
        return "views/employee/employee-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/employee";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeCreateDto", new EmployeeCreateDto());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        return "views/employee/create-list";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employeeCreateDto") EmployeeCreateDto employeeCreateDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            return "views/employee/create-list";
        }

        Division division = divisionService.findById(employeeCreateDto.getDivisionId());
        Position position = positionService.findById(employeeCreateDto.getPositionId());
        EducationDegree educationDegree = educationDegreeService.findById(employeeCreateDto.getEducationDegreeId());
        User user = new User(employeeCreateDto.getUserName(), employeeCreateDto.getPassword());
        Employee employee = new Employee(null,
                employeeCreateDto.getEmployeeName(),
                employeeCreateDto.getEmployeeBirthDay(),
                employeeCreateDto.getEmployeeIdCard(),
                employeeCreateDto.getEmployeeSalary(),
                employeeCreateDto.getEmployeePhone(),
                employeeCreateDto.getEmployeeEmail(),
                employeeCreateDto.getEmployeeAddress(),
                position,
                educationDegree,
                division,
                user,
                0);
        userService.save(new User(employeeCreateDto.));
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/employee";
    }
}
