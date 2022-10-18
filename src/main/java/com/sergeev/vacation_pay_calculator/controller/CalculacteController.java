package com.sergeev.vacation_pay_calculator.controller;


import com.sergeev.vacation_pay_calculator.service.CalculacteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CalculacteController {

    @Autowired
    private CalculacteServiceImpl calculacteServiceImpl;

    @GetMapping("/calculacte")
    public String getCalculacte(@RequestParam(value = "vacation_days") Integer vacation_days,
                                @RequestParam(value = "average_salary") Integer average_salary,
                                @RequestParam(value = "holiday_start_date") String holiday_start_date) {


       return calculacteServiceImpl.calculate(vacation_days, average_salary, holiday_start_date);

    }


}
