package com.co.tita.payments.core.repository.payments;

import com.co.tita.payments.core.entity.payments.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Optional<Payment> findById(Long Id);

}
