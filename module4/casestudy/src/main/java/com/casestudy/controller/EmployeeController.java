package com.casestudy.controller;

import com.casestudy.model.dto.employee_dto.EmployeeCreateDto;
import com.casestudy.model.dto.employee_dto.EmployeeEditDto;
import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.EducationDegree;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.employee.Position;
import com.casestudy.model.login.Role;
import com.casestudy.model.login.User;
import com.casestudy.service.furama_interface.employee.DivisionService;
import com.casestudy.service.furama_interface.employee.EducationDegreeService;
import com.casestudy.service.furama_interface.employee.EmployeeService;
import com.casestudy.service.furama_interface.employee.PositionService;
import com.casestudy.service.furama_interface.login.RoleService;
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
import java.util.List;

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
    @Autowired
    private RoleService roleService;

    @ModelAttribute("divisionList")
    public List<Division> divisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> educationDegreeList() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("roleList")
    public List<Role> roleList() {
        return roleService.findAll();
    }

    @GetMapping("")
    public String showEmployeeList(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "name", defaultValue = "") String name,
                                   Model model) {
        Page<Employee> employeeList = employeeService.findByEmployeeName(name, PageRequest.of(page, 4));
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("name", name);
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
        return "views/employee/create-list";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employeeCreateDto") EmployeeCreateDto employeeCreateDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
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
                Double.parseDouble(employeeCreateDto.getEmployeeSalary()),
                employeeCreateDto.getEmployeePhone(),
                employeeCreateDto.getEmployeeEmail(),
                employeeCreateDto.getEmployeeAddress(),
                position,
                educationDegree,
                division,
                user);
        userService.save(user);
        userService.saveUserRole(employeeCreateDto.getRoleId(), employeeCreateDto.getUserName());
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employeeEditDto", new EmployeeEditDto(employee.getEmployeeId(),
                                                    employee.getEmployeeName(),
                                                    employee.getEmployeeBirthDay(),
                                                    employee.getEmployeeIdCard(),
                                                    employee.getEmployeeSalary() + "",
                                                    employee.getEmployeePhone(),
                                                    employee.getEmployeeEmail(),
                                                    employee.getEmployeeAddress(),
                                                    employee.getPosition().getPositionId(),
                                                    employee.getEducationDegree().getEducationDegreeId(),
                                                    employee.getDivision().getDivisionId(),
                                                    employee.getUser().getUsername()));
        return "views/employee/edit-list";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("employeeEditDto") EmployeeEditDto employeeEditDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "views/employee/edit-list";
        }

        Division division = divisionService.findById(employeeEditDto.getDivisionId());
        Position position = positionService.findById(employeeEditDto.getPositionId());
        EducationDegree educationDegree = educationDegreeService.findById(employeeEditDto.getEducationDegreeId());
        User user = userService.findById(employeeEditDto.getUserName());
        Employee employee = new Employee(employeeEditDto.getEmployeeId(),
                employeeEditDto.getEmployeeName(),
                employeeEditDto.getEmployeeBirthDay(),
                employeeEditDto.getEmployeeIdCard(),
                Double.parseDouble(employeeEditDto.getEmployeeSalary()),
                employeeEditDto.getEmployeePhone(),
                employeeEditDto.getEmployeeEmail(),
                employeeEditDto.getEmployeeAddress(),
                position,
                educationDegree,
                division,
                user);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công");
        return "redirect:/employee";
    }
}
