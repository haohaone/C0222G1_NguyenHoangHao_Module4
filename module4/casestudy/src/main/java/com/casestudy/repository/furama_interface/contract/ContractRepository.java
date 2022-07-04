package com.casestudy.repository.furama_interface.contract;

import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT * FROM contract WHERE status_delete = 0", nativeQuery = true)
    Page<Contract> findAllContract(Pageable p);
}
