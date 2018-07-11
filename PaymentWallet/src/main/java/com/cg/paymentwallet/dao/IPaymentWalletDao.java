package com.cg.paymentwallet.dao;

import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;

public interface IPaymentWalletDao {
	Wallet registerCustomer(Wallet wallet);
	Wallet depositMoney(String phone,BigDecimal balance);
	Wallet withdrawMoney(String phone,BigDecimal balance);
	Wallet fundTransfer(String sourcePhone,String targetPhone,BigDecimal balance);
	Wallet showBalance(String phone);
	Wallet printTransaction(String phone);
}
