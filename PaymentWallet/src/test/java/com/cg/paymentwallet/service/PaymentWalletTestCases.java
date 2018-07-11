package com.cg.paymentwallet.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;

public class PaymentWalletTestCases {
	private static IPaymentsWalletService paymentwalletservice = null;

	@BeforeClass
	public static void setUpBeforeClass() throws PaymentWalletException {
		paymentwalletservice = new PaymentWalletService();

	}

	@Test
	public void customerPassRegistrationtest() {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNotNull(customer);
	}

	@Test
	public void customerFailRegistrationtestWithPhoneNumber() {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test
	public void customerSecondFailRegistrationtestwithEmailId() {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test
	public void customerSecondFailRegistrationtestwithName() {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("sai");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test
	public void customerSecondFailRegistrationtestwithAge() {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(200);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test
	public void customerSecondFailRegistrationtestwithGender() {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("hai");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test
	public void depositMoneyFailWithPhone() {
		Wallet customer = paymentwalletservice.depositMoney("9703", new BigDecimal(2000));
		assertNull(customer);
	}

	@Test
	public void depositMoneyPassWithPhone() {
		Wallet customer = paymentwalletservice.depositMoney("9703806992", new BigDecimal(2000));
		assertNotNull(customer);
	}
	@Test
	public void withdrawMoneyFailWithPhone() {
		Wallet customer = paymentwalletservice.withdrawMoney("9703806", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test
	public void withdrawMoneyPassWithMoney() {
		Wallet customer = paymentwalletservice.withdrawMoney("9703806806992", new BigDecimal(2000));
		assertNotNull(customer);
	}
	@Test
	public void fundTransferFailWithsourcePhone() {
		Wallet customer = paymentwalletservice.fundTransfer("9703806","8341219705", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test
	public void fundTransferFailWithsourcePhoneMaxNumbers() {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992456","8341219705", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test
	public void fundTransferFailWithTargetPhoneMaxNumbers() {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992","8341219705123", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test
	public void fundTransferFailWithTargetPhone() {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992","834121", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test
	public void fundTransferPassWithAllCorrect() {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992","8341219705", new BigDecimal(2000));
		assertNotNull(customer);
	}

	@Test
	public void showBalanceFailWithPhone() {
		Wallet customer = paymentwalletservice.showBalance("9703806");
		assertNull(customer);
	}
	@Test
	public void showBalancePassWithPhone() {
		Wallet customer = paymentwalletservice.showBalance("9703806992");
		assertNotNull(customer);
	}
	@Test
	public void printStatementFailWithPhone() {
		Wallet customer = paymentwalletservice.showBalance("9703806");
		assertNull(customer);
	}
	@Test
	public void printStatementPassWithPhone() {
		Wallet customer = paymentwalletservice.showBalance("9703806992");
		assertNotNull(customer);
	}
}
