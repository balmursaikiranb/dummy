package com.cg.mra.ui;

import java.util.Scanner;
import com.cg.mra.beans.Account;
import com.cg.mra.exception.IMobileRechargeException;
import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		AccountService accountservice = new AccountServiceImpl();
		int choice = 0;

		boolean error = false;
		boolean error1 = false;
		//double rechargeAmount;
		String ch;
		do {
			System.out.println(
					"     //------------------------    Mobile Recharge Application --------------------------");
			System.out.println(
					"/*******************************************************************************************************");
			System.out.println("1.Account Balance Enquiry");
			System.out.println("2.RechargeAccount");
			System.out.println("3.Exit");
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter The choice For Making Operations:");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Mobile No:");
				String mobileNo = scanner.next();
				try {
					error = accountservice.validateNumber(mobileNo);
				} catch (MobileRechargeException mobileRechargeException) {
					// TODO Auto-generated catch block
					System.out.println(IMobileRechargeException.MESSAGE1);
				}

				if (error) {
					Account account = accountservice.getAccountDetails(mobileNo);
					if (account != null) {
						System.out.println("Your Current Balance is: " + account.getAccountBalance());
					} else {
						System.out.println(IMobileRechargeException.MESSAGE1);
					}

				}
				break;
			case 2:
				System.out.println("Enter Mobile No:");
				String mobileNumber = scanner.next();
				try {
					error = accountservice.validateNumber(mobileNumber);

					if (error) {
						System.out.println("Enter Recharge Amount:");
						double rechargeAmount1 = scanner.nextDouble();

						error1 = accountservice.validateAmount(rechargeAmount1);

						if (error1) {

							Account details = accountservice.rechargeAccount(mobileNumber, rechargeAmount1);
							System.out.println("Your Account Recharged Successfully");
							System.out.println("Hello " + details.getCustomerName() + " ,Available Balance is "
									+ details.getAccountBalance());
						}
					} else {
						System.out.println(IMobileRechargeException.MESSAGE2);
					}

				} catch (MobileRechargeException mobileRechargeException) {

					System.out.println(IMobileRechargeException.MESSAGE1);

				}

				break;

			case 3:
				System.out.println("Thank You for Using Our Application");
				System.exit(0);

				break;
			default:
				System.out.println("enter correct value");

			}
			System.out.println("enter y or yes to continue and n or no to exit");
			ch = scanner.next();
		} while ((ch.equalsIgnoreCase("y")) || ch.equalsIgnoreCase("yes"));

	}

}
