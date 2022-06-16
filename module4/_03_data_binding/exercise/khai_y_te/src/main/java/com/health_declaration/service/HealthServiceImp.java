package com.health_declaration.service;

import org.springframework.stereotype.Service;

@Service
public class HealthServiceImp implements HealthService {
    private static String[] dateOfBirth = new String[]{"1997", "1998", "1999", "2000", "2001", "2002"};
    private static String[] nationality = new String[]{"Việt Nam",
                                                        "Nhật bản",
                                                        "Thái Lan",
                                                        "Lào",
                                                        "Campuchia",
                                                        "Indonesia"};
    @Override
    public String[] findAllNationality(){
        return nationality;
    }

    @Override
    public String[] findAllDayOfBirth(){
        return dateOfBirth;
    }
}
