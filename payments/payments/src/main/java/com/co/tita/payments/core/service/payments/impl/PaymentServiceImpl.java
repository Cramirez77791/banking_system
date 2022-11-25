package com.co.tita.payments.core.service.payments.impl;

import com.co.tita.payments.core.dtos.PaymentDto;
import com.co.tita.payments.core.entity.credits.Credit;
import com.co.tita.payments.core.entity.payments.Payment;
import com.co.tita.payments.core.reports.PaymentReport;
import com.co.tita.payments.core.repository.payments.PaymentRepository;
import com.co.tita.payments.core.service.payments.PaymentService;
import com.co.tita.payments.core.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Long savePayment(PaymentDto paymentDto) throws ParseException {
        Payment payment = new Payment();
        payment.setAmountPayment(paymentDto.getAmountPayment());
        payment.setPaymentDate(Utils.formatDate(paymentDto.getPaymentDate()));

        Credit credit = new Credit();
        credit.setId(paymentDto.getCreditId());
        payment.setCreditId(credit);

        payment.setUserId(paymentDto.getUserId());
        payment.setQuantityQuotas(paymentDto.getQuantityQuotas());

        paymentRepository.saveAndFlush(payment);

        return payment.getId();

    }

    @Override
    public PaymentReport getById(Long Id) throws ParseException {
        PaymentReport paymentReport = new PaymentReport();
        Optional<Payment> optionalPayment = paymentRepository.findById(Id);

        if(optionalPayment.isPresent()){
            Payment payment = optionalPayment.get();
            paymentReport.setAmountPayment(payment.getAmountPayment());
            paymentReport.setId(payment.getId());
            paymentReport.setUserId(payment.getUserId());
            paymentReport.setPaymentDate(Utils.formatDate(payment.getPaymentDate()));
            paymentReport.setQuantityQuotas(payment.getQuantityQuotas());
            paymentReport.setCreditId(payment.getCreditId());

        }
        return paymentReport;
    }
}
