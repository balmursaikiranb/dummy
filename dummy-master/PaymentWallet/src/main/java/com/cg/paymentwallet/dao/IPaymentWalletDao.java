package com.cg.paymentwallet.dao;

import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;
import java.time.LocalDateTime;

public interface IPaymentWalletDao {
	Wallet registerCustomer(Wallet wallet);
	Wallet depositMoney(String phone,BigDecimal balance);
	Wallet withdrawMoney(String phone,BigDecimal balance);
	Wallet fundTransfer(String sourcePhone,String targetPhone,BigDecimal balance);
	Wallet showBalance(String phone);
	HashMap<LocalDateTime,String> printTransaction(String phone);

    
}
