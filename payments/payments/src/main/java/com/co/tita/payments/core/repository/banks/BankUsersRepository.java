package com.co.tita.payments.core.repository.banks;

import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankUsersRepository extends JpaRepository<BanksUsers,Long> {

    Optional<List<BanksUsers>> findBanksUsersByIdUser(User userId);

    Optional<BanksUsers> findById(Long id);

}
