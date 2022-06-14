package com.currency_conversion.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    public int currency(String usd){
        int usdValue = Integer.parseInt(usd);
        int vnd = usdValue * 22000;
        return vnd;
    }
}
