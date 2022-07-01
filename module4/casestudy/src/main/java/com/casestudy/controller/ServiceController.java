package com.casestudy.controller;

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
import org.springframework.web.bind.annotation.*;

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
    public String showServiceList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Service> serviceList = serviceSer.findAll(PageRequest.of(page, 4));
        model.addAttribute("serviceList", serviceList);
        return "views/service/service-list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        serviceSer.delete(id);
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

    @GetMapping("create/{name}")
    public String showCreateList(@PathVariable("name") String name, Model model){
        if (new )
    }
}
