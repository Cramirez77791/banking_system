package com.co.tita.payments.core.repository.credits;

import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.credits.Credit;
import com.co.tita.payments.core.reports.CreditDetailReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CreditRepository extends JpaRepository<Credit,Long> {

    Optional<Credit> findCreditById(Long id);

    Optional<List<Credit>> findAllCreditByBankIdAndUserId(Bank bankId, Long userId);

    Optional<List<Credit>> findAllByUserId(Long userId);

    Optional<Credit> findById(Long id);

}
