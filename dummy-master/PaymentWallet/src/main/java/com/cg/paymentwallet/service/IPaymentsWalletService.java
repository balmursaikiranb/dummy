package com.cg.paymentwallet.service;

import java.math.BigDecimal;

import com.cg.paymentwallet.dto.Customer;
import com.cg.paymentwallet.dto.Wallet;
import java.time.LocalDateTime;

public interface IPaymentsWalletService {
	Wallet registerCustomer(Wallet wallet);
	Wallet depositMoney(String phone,BigDecimal balance);
	Wallet withdrawMoney(String phone,BigDecimal balance);
	Wallet fundTransfer(String sourcePhone,String targetPhone,BigDecimal balance);
	Wallet showBalance(String phone);
	HashMap<LocalDateTime,String> printTransaction(String phone);
}
