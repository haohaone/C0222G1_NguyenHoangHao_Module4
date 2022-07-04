package com.casestudy.service.imp.contract;

import com.casestudy.model.contract.AttachService;
import com.casestudy.repository.furama_interface.contract.AttachServiceRepository;
import com.casestudy.service.furama_interface.contract.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceImp implements IAttachService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
