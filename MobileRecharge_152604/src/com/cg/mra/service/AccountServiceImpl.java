package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.IMobileRechargeException;
import com.cg.mra.exception.MobileRechargeException;

public class AccountServiceImpl implements AccountService {
	AccountDao accountdao = new AccountDaoImpl();

	// ------------------------ Mobile Recharge Application
	// --------------------------
	/*******************************************************************************************************
	 * - Method Name : validateNumber - Input Parameters : String number - Return
	 * Type : boolean - Throws : MobileRechargeException - Author : Sai kiran Balmur
	 * - Creation Date : 11/07/2018 - Description : It will check weather the
	 * inputted number is in correct format or not by matching it with the pattern.
	 * If it matches it will return true else it will throw exception that the
	 * entered number is in not correct format or not available.
	 ********************************************************************************************************/
	public boolean validateNumber(String number) throws MobileRechargeException {
		if (!(number.matches("[0-9]{10}"))) {
			throw new MobileRechargeException(IMobileRechargeException.MESSAGE1);
		}
		return true;
	}

	// ------------------------ Mobile Recharge Application
	// --------------------------
	/*******************************************************************************************************
	 * - Method Name : getAccountDetails - Input Parameters : String mobileNo -
	 * Return Type : accountdto Account - Throws : MobileRechargeException - Author
	 * : Sai kiran Balmur - Creation Date : 11/07/2018 - Description : It will call
	 * the AccountDao class getAccountDetails(String mobileNo) method.It will return
	 * details associated with the mobile number by getting values from AccountDao
	 * class getAccountDetails(String mobileNo) method if available. If mobile
	 * number is not available it will return null value.
	 ********************************************************************************************************/
	@Override
	public Account getAccountDetails(String mobileNo) {

		return accountdao.getAccountDetails(mobileNo);
	}

	// ------------------------ Mobile Recharge Application
	// --------------------------
	/*******************************************************************************************************
	 * - Method Name : rechargeAccount - Input Parameters : String mobileno,String
	 * rechargeAmount - Return Type : accountdto Account - Throws :
	 * MobileRechargeException - Author : Sai kiran Balmur - Creation Date :
	 * 11/07/2018 - Description : It will call the AccountDao class
	 * rechargeAccount(String mobileno,String rechargeAmount) method.It will return
	 * details associated with the mobile number by updating values
	 * inputted(rechargeAmount) in AccounttDao class rechargeAccount(String
	 * mobileno,String rechargeAmount) method if available. If mobile number is not
	 * available it will return null value.
	 ********************************************************************************************************/
	@Override
	public Account rechargeAccount(String mobileno, double rechargeAmount) throws MobileRechargeException {
		try {
			Account accountdto = accountdao.rechargeAccount(mobileno, rechargeAmount);
			if (accountdto == null) {
				throw new MobileRechargeException(IMobileRechargeException.MESSAGE1);
			}
			return accountdto;
		} catch (MobileRechargeException mobileRechargeException) {
			// TODO Auto-generated catch block
			System.out.println(IMobileRechargeException.MESSAGE1);
		}
		return null;
	}

	// ------------------------ Mobile Recharge Application
	// --------------------------
	/*******************************************************************************************************
	 * - Method Name : validateAmount - Input Parameters : String rechargeAmount -
	 * Return Type : boolean - Throws : MobileRechargeException - Author : Sai kiran
	 * Balmur - Creation Date : 11/07/2018 - Description : It will check weather the
	 * inputted amount is in correct format or not by matching it with the pattern
	 * of numbers. If it matches it will return true else it will throw exception
	 * that the entered amount is in not correct format or the mobile number entered
	 * is not available.
	 ********************************************************************************************************/
	@Override
	public boolean validateAmount(double rechargeAmount) throws MobileRechargeException {
		
		String balance = String.valueOf(rechargeAmount);
		
		if (!(balance.matches("\\d+"))) {
			throw new MobileRechargeException(IMobileRechargeException.MESSAGE3);
		}
		return true;

	}
}
