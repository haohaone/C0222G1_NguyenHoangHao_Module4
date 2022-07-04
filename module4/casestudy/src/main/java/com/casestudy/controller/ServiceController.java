package com.casestudy.controller;

import com.casestudy.model.dto.service_dto.ServiceCreateDto;
import com.casestudy.model.dto.service_dto.ServiceEditDto;
import com.casestudy.model.service.RentType;
import com.casestudy.model.service.Service;
import com.casestudy.model.service.ServiceType;
import com.casestudy.service.furama_interface.service.RentTypeService;
import com.casestudy.service.furama_interface.service.ServiceSer;
import com.casestudy.service.furama_interface.service.ServiceTypeSer;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceSer serviceSer;

    @Autowired
    private ServiceTypeSer serviceTypeSer;

    @Autowired
    private RentTypeService rentTypeService;

    @ModelAttribute("serviceTypeList")
    private List<ServiceType> serviceTypeList() {
        return serviceTypeSer.findAll();
    }

    @ModelAttribute("rentTypeList")
    private List<RentType> rentTypeList() {
        return rentTypeService.findAll();
    }

    @GetMapping("")
    public String showServiceList(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "name", defaultValue = "") String name,
                                  @RequestParam(name = "id", defaultValue = "") String id,
                                  Model model) {
        Page<Service> serviceList = serviceSer.findByServiceName(name, id, PageRequest.of(page, 4));
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("name", name);
        model.addAttribute("id", id);
        return "views/service/service-list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        serviceSer.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/service";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name,
                         @RequestParam("id") String id,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         Model model) {
        Page<Service> serviceList = serviceSer.findByServiceName(name, id, PageRequest.of(page, 4));
        model.addAttribute("serviceList", serviceList);
        return "views/service/service-list";
    }

    @GetMapping("/create/{name}")
    public String showCreateList(@PathVariable("name") String name, Model model) {
        ServiceCreateDto serviceCreateDto = new ServiceCreateDto();
        serviceCreateDto.setServiceName(name);
        model.addAttribute("service", serviceCreateDto);
        model.addAttribute("name", name);
        return "views/service/create-list";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("service") ServiceCreateDto serviceCreateDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new ServiceCreateDto().validate(serviceCreateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("name", serviceCreateDto.getServiceName());
            return "views/service/create-list";
        } else {
            RentType rentType = rentTypeService.findById(serviceCreateDto.getRentTypeId());
            ServiceType serviceType = serviceTypeSer.findById(serviceCreateDto.getServiceTypeId());
            Service service;
            if (serviceCreateDto.getServiceName().equals("Villa")) {
                service = new Service(serviceCreateDto.getServiceId(),
                        serviceCreateDto.getServiceName(),
                        Double.parseDouble(serviceCreateDto.getServiceCost()),
                        Double.parseDouble(serviceCreateDto.getServiceArea()),
                        Integer.parseInt(serviceCreateDto.getServiceMaxPeople()),
                        rentType,
                        serviceType,
                        serviceCreateDto.getStandardRoom(),
                        serviceCreateDto.getDescription(),
                        Double.parseDouble(serviceCreateDto.getPoolArea()),
                        Integer.parseInt(serviceCreateDto.getFloor()), 0);
            } else if (serviceCreateDto.getServiceName().equals("House")) {
                service = new Service(serviceCreateDto.getServiceId(),
                        serviceCreateDto.getServiceName(),
                        Double.parseDouble(serviceCreateDto.getServiceCost()),
                        Double.parseDouble(serviceCreateDto.getServiceArea()),
                        Integer.parseInt(serviceCreateDto.getServiceMaxPeople()),
                        rentType,
                        serviceType,
                        serviceCreateDto.getStandardRoom(),
                        serviceCreateDto.getDescription(),
                        Integer.parseInt(serviceCreateDto.getFloor()), 0);
            } else {
                service = new Service(serviceCreateDto.getServiceId(),
                        serviceCreateDto.getServiceName(),
                        Double.parseDouble(serviceCreateDto.getServiceCost()),
                        Double.parseDouble(serviceCreateDto.getServiceArea()),
                        Integer.parseInt(serviceCreateDto.getServiceMaxPeople()),
                        rentType,
                        serviceType, 0);
            }
            serviceSer.save(service);
            redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
            return "redirect:/service";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model){
        Service service = serviceSer.findById(id);
        ServiceEditDto serviceEditDto = new ServiceEditDto(service.getServiceId(),
                service.getServiceName(),
                String.valueOf(service.getServiceCost()),
                String.valueOf(service.getServiceArea()),
                String.valueOf(service.getServiceMaxPeople()),
                service.getRentType().getRentTypeId(),
                service.getServiceType().getServiceTypeId(),
                service.getStandardRoom(),
                service.getDescription(),
                String.valueOf(service.getPoolArea()),
                String.valueOf(service.getFloor()));
        model.addAttribute("service", serviceEditDto);
        model.addAttribute("name", serviceEditDto.getServiceName());
        return "views/service/edit-list";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("service") ServiceEditDto serviceEditDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new ServiceEditDto().validate(serviceEditDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("name", serviceEditDto.getServiceName());
            return "views/service/create-list";
        } else {
            RentType rentType = rentTypeService.findById(serviceEditDto.getRentTypeId());
            ServiceType serviceType = serviceTypeSer.findById(serviceEditDto.getServiceTypeId());
            Service service;
            if (serviceEditDto.getServiceName().equals("Villa")) {
                service = new Service(serviceEditDto.getServiceId(),
                        serviceEditDto.getServiceName(),
                        Double.parseDouble(serviceEditDto.getServiceCost()),
                        Double.parseDouble(serviceEditDto.getServiceArea()),
                        Integer.parseInt(serviceEditDto.getServiceMaxPeople()),
                        rentType,
                        serviceType,
                        serviceEditDto.getStandardRoom(),
                        serviceEditDto.getDescription(),
                        Double.parseDouble(serviceEditDto.getPoolArea()),
                        Integer.parseInt(serviceEditDto.getFloor()), 0);
            } else if (serviceEditDto.getServiceName().equals("House")) {
                service = new Service(serviceEditDto.getServiceId(),
                        serviceEditDto.getServiceName(),
                        Double.parseDouble(serviceEditDto.getServiceCost()),
                        Double.parseDouble(serviceEditDto.getServiceArea()),
                        Integer.parseInt(serviceEditDto.getServiceMaxPeople()),
                        rentType,
                        serviceType,
                        serviceEditDto.getStandardRoom(),
                        serviceEditDto.getDescription(),
                        Integer.parseInt(serviceEditDto.getFloor()), 0);
            } else {
                service = new Service(serviceEditDto.getServiceId(),
                        serviceEditDto.getServiceName(),
                        Double.parseDouble(serviceEditDto.getServiceCost()),
                        Double.parseDouble(serviceEditDto.getServiceArea()),
                        Integer.parseInt(serviceEditDto.getServiceMaxPeople()),
                        rentType,
                        serviceType, 0);
            }
            serviceSer.save(service);
            redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công");
            return "redirect:/service";
        }
    }
}
