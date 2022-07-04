package com.casestudy.service.furama_interface.contract;

import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContract {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(Contract contract);

    Contract findById(int id);
}
