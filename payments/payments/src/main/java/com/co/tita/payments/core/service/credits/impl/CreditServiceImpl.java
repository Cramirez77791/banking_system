package com.co.tita.payments.core.service.credits.impl;

import com.co.tita.payments.core.dtos.CreditDto;
import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.credits.Credit;
import com.co.tita.payments.core.reports.CreditDetailReport;
import com.co.tita.payments.core.reports.CreditReport;
import com.co.tita.payments.core.reports.PaymentCreditReport;
import com.co.tita.payments.core.repository.credits.CreditRepository;
import com.co.tita.payments.core.service.credits.CreditService;
import com.co.tita.payments.core.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Long saveCredit(CreditDto creditDto) throws ParseException {
        Credit credit = new Credit();
        credit.setAmount(creditDto.getAmount());
        credit.setCreditDate(Utils.formatDate(creditDto.getCreditDate()));
        credit.setUserId(credit.getUserId());
        Bank bank = new Bank();
        bank.setId(creditDto.getBankId());
        credit.setBankId(bank);
        credit.setQuotaQuantity(credit.getQuotaQuantity());
        credit.setQuotaAmount(credit.getQuotaAmount());

        creditRepository.saveAndFlush(credit);

        return credit.getId();
    }

    @Override
    public CreditReport getById(Long id) throws ParseException {
     CreditReport creditReport = new CreditReport();
     Optional<Credit> creditOptional = creditRepository.findCreditById(id);
     if(creditOptional.isPresent()){
         Credit credit = creditOptional.get();
         creditReport.setId(credit.getId());
         creditReport.setQuotaQuantity(credit.getQuotaQuantity());
         creditReport.setAmount(credit.getAmount());
         creditReport.setUserId(credit.getUserId());
         creditReport.setBankId(credit.getBankId());
     }

        return creditReport;
    }

    @Override
    public List<CreditReport> findAllByBankIdAndUser(Long bankId, Long userId) {
        List<CreditReport> creditReportList = new ArrayList<>();
        Bank bank = new Bank();
        bank.setId(bankId);
        Optional<List<Credit>> optionalCredits = creditRepository.findAllCreditByBankIdAndUserId(bank,userId);
        if(optionalCredits.isPresent()){
            List<Credit> creditList = optionalCredits.get();
            creditList.forEach(credit -> {
                CreditReport creditReport = new CreditReport();
                creditReport.setId(credit.getId());
                try {
                    creditReport.setCreditDate(Utils.formatDate(credit.getCreditDate()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                creditReport.setQuotaAmount(credit.getQuotaAmount());
                creditReport.setAmount(credit.getAmount());
                creditReport.setUserId(credit.getUserId());
                creditReport.setBankId(credit.getBankId());
                creditReportList.add(creditReport);
            });

        }


        return creditReportList;
    }

    @Override
    public List<CreditReport> findAllByUser(Long userId) {
        List<CreditReport> creditReportList = new ArrayList<>();
        Optional<List<Credit>> optionalCredits = creditRepository.findAllByUserId(userId);
        if(optionalCredits.isPresent()){
            List<Credit> creditList = optionalCredits.get();
            creditList.forEach(credit -> {
                CreditReport creditReport = new CreditReport();
                creditReport.setId(credit.getId());
                try {
                    creditReport.setCreditDate(Utils.formatDate(credit.getCreditDate()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                creditReport.setQuotaAmount(credit.getQuotaAmount());
                creditReport.setAmount(credit.getAmount());
                creditReport.setUserId(credit.getUserId());
                creditReport.setBankId(credit.getBankId());
                creditReportList.add(creditReport);
            });

        }


        return creditReportList;
    }

    @Override
    public CreditDetailReport getCreditDetail(Long crediId) throws ParseException {
        CreditDetailReport creditDetailReport = new CreditDetailReport();
        Optional<Credit> creditOptional = creditRepository.findCreditById(crediId);
        if(creditOptional.isPresent()){
            Credit credit = creditOptional.get();
            creditDetailReport.setId(credit.getId());
            creditDetailReport.setQuotaQuantity(credit.getQuotaQuantity());
            creditDetailReport.setAmount(credit.getAmount());
            creditDetailReport.setUserId(credit.getUserId());
            creditDetailReport.setBankId(credit.getBankId());
            List<PaymentCreditReport> paymentReportList = new ArrayList<>();
            credit.getPayments().forEach(payment -> {
                PaymentCreditReport paymentCreditReport = new PaymentCreditReport();

                paymentCreditReport.setId(payment.getId());
                paymentCreditReport.setCreditId(payment.getCreditId().getId());
                paymentCreditReport.setAmountPayment(payment.getAmountPayment());
                try {
                    paymentCreditReport.setPaymentDate(Utils.formatDate(payment.getPaymentDate()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                paymentCreditReport.setUserId(payment.getUserId());
                paymentReportList.add(paymentCreditReport);
            });


        }

        return creditDetailReport;
    }
}
