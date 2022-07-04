package com.casestudy.service.imp.service;

import com.casestudy.model.service.Service;
import com.casestudy.repository.furama_interface.service.ServiceRepository;
import com.casestudy.service.furama_interface.service.ServiceSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceSerImp implements ServiceSer {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAll(Pageable p) {
        return serviceRepository.findAllService(p);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String serviceId) {
        Service service = findById(serviceId);
        service.setStatusDelete(1);
        serviceRepository.save(service);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Page<Service> findByServiceName(String name, String id,Pageable p) {
        return serviceRepository.search("%"+name+"%", "%"+id+"%", p);
    }
}
