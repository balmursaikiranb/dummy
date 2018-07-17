package com.cg.mra.dao;

import java.util.HashMap;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {
	private static HashMap<String, Account> records = null;
	static {
		records = new HashMap<>();
		Account account = new Account();
		account.setMobileNo("0123456789");
		account.setCustomerName("Sai");
		account.setAccountBalance(50);
		Account account1 = new Account();
		account1.setMobileNo("0012345678");
		account1.setCustomerName("Kiran");
		account1.setAccountBalance(100);
		Account account2 = new Account();
		account2.setMobileNo("0001234567");
		account2.setCustomerName("Balmur");
		account2.setAccountBalance(20);
		records.put(account.getMobileNo(), account);
		records.put(account1.getMobileNo(), account1);
		records.put(account2.getMobileNo(), account2);
	}

	// ------------------------ Mobile Recharge Application
	// --------------------------
	/*******************************************************************************************************
	 * - Method Name : getAccountDetails - Input Parameters : String mobileNo -
	 * Return Type : accountdto Account - Throws : MobileRechargeException - Author
	 * : Sai kiran Balmur - Creation Date : 11/07/2018 - Description : It will
	 * return details associated with the mobile number. If mobile number is not
	 * available it will return null value.
	 ********************************************************************************************************/
	@Override
	public Account getAccountDetails(String mobileNo) {
		Account accountdto = records.get(mobileNo);
		if (accountdto != null) {
			return accountdto;
		}
		return null;
	}

	// ------------------------ Mobile Recharge Application
	// --------------------------
	/*******************************************************************************************************
	 * - Method Name : rechargeAccount - Input Parameters : String mobileno,String
	 * rechargeAmount - Return Type : accountdto Account - Throws :
	 * MobileRechargeException - Author : Sai kiran Balmur - Creation Date :
	 * 11/07/2018 - Description : It will check weather the mobile number is
	 * available or not. If available it will take the rechargeAmount for that
	 * object and add the rechargeAmount that inputted by the user to actual balance
	 * and return the object. If mobile number is not available it will return null
	 * value.
	 ********************************************************************************************************/
	@Override
	public Account rechargeAccount(String mobileno, double rechargeAmount) {

		Account accountdto = records.get(mobileno);
		if (accountdto != null) {
			double updateBal =(accountdto.getAccountBalance() +rechargeAmount);
			
			accountdto.setAccountBalance(updateBal);
			return accountdto;
		}
		return null;
	}

}
