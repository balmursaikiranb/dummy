package com.cg.mra.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.IMobileRechargeException;
import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MobileRechargeTest {

	private static AccountService recharge = null;

	@BeforeClass
	public static void setUpBeforeClass() throws MobileRechargeException {
		recharge = new AccountServiceImpl();
	}

	@Test
	public void testMobileNumberWhenInputIsCorrect() {
		Account dto = recharge.getAccountDetails("0123456789");
		assertNotNull(dto);
	}

	@Test
	public void testMobileNumberWhenInputWrong() {
		Account dto = recharge.getAccountDetails("dasa");
		assertNull(dto);
	}

	@Test
	public void testMobileNumberWhenNoInput() {
		Account dto = recharge.getAccountDetails(" ");
		assertNull(dto);
	}

	@Test(expected = MobileRechargeException.class)
	public void testRechargeAccountWhenNoInputs() throws MobileRechargeException {
		Account dto = recharge.rechargeAccount(" ",32);
		if (dto == null) {
			throw new MobileRechargeException(IMobileRechargeException.MESSAGE1);
		} else {
			assertNotNull(dto);
		}
	}

	@Test(expected = MobileRechargeException.class)
	public void testRechargeAccountWhenSpaceInput() throws MobileRechargeException {
		Account dto = recharge.rechargeAccount(" ", 2000);
		if (dto == null) {
			throw new MobileRechargeException(IMobileRechargeException.MESSAGE1);
		} else {
			assertNotNull(dto);
		}

	}

	@Test(expected = MobileRechargeException.class)
	public void testRechargeAccountWhenNoInput() throws MobileRechargeException {
		Account dto = recharge.rechargeAccount("", 2000);
		if (dto == null) {
			throw new MobileRechargeException(IMobileRechargeException.MESSAGE1);
		} else {
			assertNotNull(dto);
		}
	}

	@Test
	public void testRechargeAccountWhenCorrectInput() throws MobileRechargeException {
		Account dto = recharge.rechargeAccount("0123456789", 2000);
		assertNotNull(dto);
	}

}
