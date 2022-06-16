package com.mail_box.service;

import org.springframework.stereotype.Service;

@Service
public class MailBoxServiceImp implements MailBoxService {
    private String[] languages = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    private int [] pageSize = new int[]{5, 10, 15, 25, 50, 100};

    @Override
    public String[] findAllLanguages() {
        return languages;
    }

    @Override
    public int[] findAllPageSize() {
        return pageSize;
    }
}
