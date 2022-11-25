package com.co.tita.payments.core.service.credits;

import com.co.tita.payments.core.dtos.CreditDto;
import com.co.tita.payments.core.reports.CreditDetailReport;
import com.co.tita.payments.core.reports.CreditReport;

import java.text.ParseException;
import java.util.List;

public interface CreditService {
    Long saveCredit(CreditDto creditDto) throws ParseException;

    CreditReport getById(Long id) throws ParseException;

    List<CreditReport> findAllByBankIdAndUser(Long bankId, Long userId);

    List<CreditReport> findAllByUser(Long userId);

    CreditDetailReport getCreditDetail(Long crediId) throws ParseException;
}
