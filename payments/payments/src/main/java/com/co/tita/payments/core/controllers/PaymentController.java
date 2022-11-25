package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.PaymentDto;
import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.reports.BankReport;
import com.co.tita.payments.core.reports.PaymentReport;
import com.co.tita.payments.core.reports.ResponseReport;
import com.co.tita.payments.core.service.payments.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentReport> addPayment(@RequestBody PaymentDto paymentDto) throws ParseException {
        PaymentReport paymentReport = new PaymentReport();
        Long id = paymentService.savePayment(paymentDto);
        paymentReport = paymentService.getById(id);
        return new ResponseEntity<>(paymentReport,null,HttpStatus.OK);
    }


}
