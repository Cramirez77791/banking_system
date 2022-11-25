package com.co.tita.payments.core.repository.banks;

import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Long> {
}
