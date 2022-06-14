package com.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CurrencyDictionaryService implements DictionaryService {
    private static Map<String, String> dictionary = new LinkedHashMap<>();

    static {
        dictionary.put("book", "sách");
        dictionary.put("dog", "chó trung");
        dictionary.put("cat", "mèo");
        dictionary.put("snake", "rắn");
        dictionary.put("table", "bàn");
        dictionary.put("blue", "màu xanh");
        dictionary.put("red", "màu đỏ");
    }

    @Override
    public String dictionary(String english) {
        return dictionary.get(english);
    }
}
