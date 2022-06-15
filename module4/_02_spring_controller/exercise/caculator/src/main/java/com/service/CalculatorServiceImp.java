package com.service;

import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Service
public class CalculatorServiceImp implements CalculatorService {

    @Override
    public Object calculator(String string) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = null;
        try {
            result = engine.eval(string);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }
}
