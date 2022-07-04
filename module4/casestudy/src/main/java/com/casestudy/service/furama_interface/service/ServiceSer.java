package com.casestudy.service.furama_interface.service;

import com.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceSer {
    Page<Service> findAll(Pageable p);

    List<Service> findAll();

    Service findById(String id);

    void delete(String serviceId);

    void save(Service service);

    Page<Service> findByServiceName(String name, String id,Pageable p);
}
