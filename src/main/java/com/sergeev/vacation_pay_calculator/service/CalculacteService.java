package com.sergeev.vacation_pay_calculator.service;

public interface CalculacteService {

    public String calculate(Integer vacation_days, Integer average_salary, String holiday_start_date);
}
