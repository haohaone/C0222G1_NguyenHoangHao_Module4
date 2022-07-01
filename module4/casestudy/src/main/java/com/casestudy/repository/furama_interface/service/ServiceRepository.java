package com.casestudy.repository.furama_interface.service;

import com.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, String> {
    @Query(value = "SELECT * FROM service WHERE status_delete = 0", nativeQuery = true)
    Page<Service> findAllService(Pageable p);

    @Query(value = "SELECT * FROM service WHERE status_delete = 0 AND service_name LIKE :name AND rent_type_id LIKE :id", nativeQuery = true)
    Page<Service> search(@Param("name") String name, @Param("id") String id, Pageable p);
}
