package com.example.calculator40;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/start")
    public String welcome() {
        return """
                <h1 style text-align: center> welcome to calculator
                """;
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildView("+", a, b);
    }
    @GetMapping(path = "/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildView("-", a, b);
    }
    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildView("*", a, b);
    }
    @GetMapping(path = "/divide")
    public String divide(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildView("/", a, b);
    }

    private String buildView(String operation, Float operand1, Float operand2) {
        if (operand1 == null) {
            return "не передано первое значение";
        } else if (operand2 == null) {
            return "не передано второе значение";
        }
        if ("/".equals(operation) && operand2 == 0) {
            return "на ноль делить нельзя";
        }
        float result;
        switch (operation) {
            default:
            case ("+"):
                result = Service.plus(operand1, operand2);
                break;
            case ("-"):
                result = Service.minus(operand1, operand2);
                break;
            case ("*"):
                result = Service.multiply(operand1, operand2);
                break;
            case ("/"):
                result = Service.divide(operand1, operand2);
                break;
        }
        return operand1 + " " + operation + " " + operand2 + " " + " = " + result;
    }

    float result;

}
