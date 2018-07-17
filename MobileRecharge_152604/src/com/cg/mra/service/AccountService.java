package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountService {
	Account getAccountDetails(String mobileNo);

	Account rechargeAccount(String mobileno, double rechargeAmount1) throws MobileRechargeException;

	boolean validateNumber(String mobileNumber) throws MobileRechargeException;

	boolean validateAmount(double rechargeAmount1) throws MobileRechargeException;

}
