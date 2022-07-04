package com.casestudy.service.furama_interface.contract;

import com.casestudy.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetail {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
