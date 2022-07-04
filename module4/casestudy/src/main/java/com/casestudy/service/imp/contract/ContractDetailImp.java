package com.casestudy.service.imp.contract;

import com.casestudy.model.contract.ContractDetail;
import com.casestudy.repository.furama_interface.contract.ContractDetailRepository;
import com.casestudy.service.furama_interface.contract.IContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailImp implements IContractDetail {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
