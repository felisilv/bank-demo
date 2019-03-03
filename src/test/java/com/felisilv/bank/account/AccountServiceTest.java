package com.felisilv.bank.account;

import com.felisilv.bank.account.models.Account;
import com.felisilv.bank.account.models.CurrentAccount;
import com.felisilv.bank.account.models.SavingsAccount;
import com.felisilv.bank.account.utils.AccountUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@Import(ValidationAutoConfiguration.class)
@ContextConfiguration(classes = AccountService.class)
public class AccountServiceTest {

  @MockBean
  private AccountRepository accountRepositoryMock;

  @Autowired
  private AccountService accountService;

  @Test
  public void shouldSaveToRepositoryOnCreateCurrentAccount() {
    CurrentAccount currentAccount = AccountUtils.getDefaultCurrentAccount();
    CurrentAccount returnedCurrentAccount = AccountUtils.getDefaultCurrentAccount();
    when(accountRepositoryMock.save(any(CurrentAccount.class))).thenReturn(returnedCurrentAccount);

    Account createdAccount = accountService.createAccount(currentAccount);

    assertThat(createdAccount).isNotNull();
    assertThat(createdAccount.getId()).isEqualTo(returnedCurrentAccount.getId());
    verify(accountRepositoryMock, times(1)).save(any(CurrentAccount.class));
  }

  @Test
  public void shouldSaveToRepositoryOnCreateSavingsAccount() {
    SavingsAccount savingsAccount = AccountUtils.getDefaultSavingsAccount();
    SavingsAccount returnedsavingsAccount = AccountUtils.getDefaultSavingsAccount();
    when(accountRepositoryMock.save(any(SavingsAccount.class))).thenReturn(returnedsavingsAccount);

    Account createdAccount = accountService.createAccount(savingsAccount);

    assertThat(createdAccount).isNotNull();
    assertThat(createdAccount.getId()).isEqualTo(returnedsavingsAccount.getId());
    verify(accountRepositoryMock, times(1)).save(any(SavingsAccount.class));
  }

  @Test(expected = ConstraintViolationException.class)
  public void shouldRejectNullOwnerOnCreateCurrentAccount() {
    CurrentAccount currentAccount = new CurrentAccount();

    accountService.createAccount(currentAccount);
  }

  @Test(expected = ConstraintViolationException.class)
  public void shouldRejectNullOwnerOnCreateSavingsAccount() {
    SavingsAccount savingsAccount = new SavingsAccount();

    accountService.createAccount(savingsAccount);
  }
}