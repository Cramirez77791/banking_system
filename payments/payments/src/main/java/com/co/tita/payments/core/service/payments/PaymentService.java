package com.co.tita.payments.core.service.payments;

import com.co.tita.payments.core.dtos.PaymentDto;
import com.co.tita.payments.core.entity.credits.Credit;
import com.co.tita.payments.core.reports.PaymentReport;

import java.text.ParseException;

public interface PaymentService {

    Long savePayment(PaymentDto paymentDto) throws ParseException;

    PaymentReport getById(Long Id) throws ParseException;

}
