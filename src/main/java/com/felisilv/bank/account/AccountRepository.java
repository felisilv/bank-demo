package com.felisilv.bank.account;

import com.felisilv.bank.account.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AccountRepository extends CrudRepository<Account, Long> {
}
