package com.sergeev.vacation_pay_calculator.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CalculacteServiceImpl implements CalculacteService {


    @Override
    public String calculate(Integer vacation_days, Integer average_salary, String holiday_start_date) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate_start = LocalDate.parse(holiday_start_date, dateTimeFormatter);
        LocalDate localDate_end = localDate_start.plusDays(vacation_days);



        int weekdays = 0;
        LocalDate start = localDate_start;
        LocalDate end = localDate_end;

        while (start.isBefore(end)) {
            if (DayOfWeek.SATURDAY.equals(start.getDayOfWeek())
                    || DayOfWeek.SUNDAY.equals(start.getDayOfWeek())) {
                weekdays++;
            }
            start = start.plusDays(1);
        }

        Integer vacation_pay_issued = (average_salary / 20) * (vacation_days - weekdays);


        return "Вам будет выдано: " + vacation_pay_issued + " рублей, за "
                + (vacation_days - weekdays) + " отпускных дней";
    }
}

