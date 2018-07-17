/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cg.paymentwallet.ui;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;


import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.IPaymentWalletException;
import com.cg.paymentwallet.exception.PaymentWalletException;
import com.cg.paymentwallet.service.IPaymentsWalletService;
import com.cg.paymentwallet.service.PaymentWalletService;

/**
 *
 * @author narendrula's
 */
public class MyMainApplication {
    public static void main(String args[])
    {
    	
    	IPaymentsWalletService paymentwalletservice=new PaymentWalletService();
    	int choice = 0;

		boolean error = false;
		String money;
		String ch;
		do {
			
			System.out.println("1.register customer");
			System.out.println("2. withdraw amount");
			System.out.println("3.deposit amount");
			System.out.println("4.fund transfer");
			System.out.println("5. show balance");
			System.out.println("6.print transactions");
			System.out.println("7.exit");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Scanner scanner =new Scanner(System.in);
		        
		        System.out.println("enter phone number");
		        String phone=scanner.next();
		        System.out.println("enter email");
		        String email=scanner.next();
		        System.out.println("enter gender");
		        String gender=scanner.next();
		        System.out.println("enter name");
		        String name=scanner.next();
		        System.out.println("enter age");
		        int age=scanner.nextInt();
		        System.out.println("enter balance");
		        BigDecimal balance=scanner.nextBigDecimal();
		        Wallet wallet =new Wallet();
		        wallet.setAge(age);
		        wallet.setBalance(balance);
		        wallet.setGender(gender);
		        wallet.setName(name);
		        wallet.setPhoneNumber(phone);
		        wallet.setEmailId(email);
		       
				try {
					error=paymentwalletservice.validatePhone(wallet.getPhoneNumber());
					if(error)
					{
						error=paymentwalletservice.validateMoney(wallet.getBalance());
					}
				}	catch (PaymentWalletException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
				try {
						if(error)
						{
							error=paymentwalletservice.validateAge(wallet.getAge());
						}}
			catch (PaymentWalletException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}try {
							if(error)
							{
								error=paymentwalletservice.validateGender(wallet.getGender());
							}
			}	catch (PaymentWalletException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}try {
					
								if(error)
								{
									error=paymentwalletservice.validateName(wallet.getName());
								}
			}	catch (PaymentWalletException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}try {
									if(error)
									{
										error=paymentwalletservice.validateEmail(wallet.getEmailId());
									}
			}	catch (PaymentWalletException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}try {
										if(error)
										{
					 Wallet wall = paymentwalletservice.registerCustomer(wallet);
					 System.out.println(wall.getEmailId());
				       System.out.println(wall.getGender());
				       System.out.println(wall.getName());
				       System.out.println(wall.getBalance());
					
					}
				} catch (PaymentWalletException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
		       
				break;
			case 2:
				
				try {
					 System.out.println("enter phone number");
				        String phone1=sc.next();
				        System.out.println("enter balance");
				        BigDecimal balance1=sc.nextBigDecimal();  
					 Wallet wall5;
				
					error=paymentwalletservice.validatePhone(phone1);
					if(error)
					{
						error=paymentwalletservice.validateMoney(balance1);
						if(error)
						{
					wall5 = paymentwalletservice.withdrawMoney(phone1, balance1);
					  System.out.println(wall5.getEmailId());
				       System.out.println(wall5.getGender());
				       System.out.println(wall5.getName());
				       System.out.println(wall5.getBalance());
					}
					}
				} catch (PaymentWalletException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			     
				break;
			case 3:
				
				try {
					System.out.println("enter phone number");
			        String phone2=sc.next();
			        System.out.println("enter balance");
			        BigDecimal balance2=sc.nextBigDecimal();  
					 Wallet wall3;
					 error=paymentwalletservice.validatePhone(phone2);
						if(error)
						{
							error=paymentwalletservice.validateMoney(balance2);
							if(error)
							{
					wall3 = paymentwalletservice.depositMoney(phone2, balance2);
					 System.out.println(wall3.getEmailId());
				       System.out.println(wall3.getGender());
				       System.out.println(wall3.getName());
				       System.out.println(wall3.getBalance());
							}
						}
				} catch (PaymentWalletException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			      
				break;
			case 4:
				
				try {
					System.out.println("enter phone number");
			        String phone3=sc.next();
			        System.out.println("enter phone number");
			        String phone4=sc.next();
			        System.out.println("enter balance");
			        BigDecimal balance3=sc.nextBigDecimal();  
					  Wallet wall4;
					  error=paymentwalletservice.validatePhone(phone3);
						if(error)
						{
							
							 error=paymentwalletservice.validatePhone(phone4);
								if(error)
								{
							error=paymentwalletservice.validateMoney(balance3);
							if(error)
							{
					wall4 = paymentwalletservice.fundTransfer(phone3, phone4, balance3);
					 System.out.println(wall4.getEmailId());
				       System.out.println(wall4.getGender());
				       System.out.println(wall4.getName());
				       System.out.println(wall4.getBalance());
							}
								}
						}
				} catch (PaymentWalletException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			      
				break;
			case 5:
				System.out.println("enter phone number");
		        String phone5=sc.next();
				  Wallet wall1;
				try {
					 error=paymentwalletservice.validatePhone(phone5);
						if(error)
						{
					wall1 = paymentwalletservice.showBalance(phone5);
					  System.out.println(wall1.getEmailId());
				       System.out.println(wall1.getGender());
				       System.out.println(wall1.getName());
				       System.out.println(wall1.getBalance());
						}
				} catch (PaymentWalletException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			     
				break;
			case 6:
				System.out.println("enter phone number");
		        String phone6=sc.next();
				 HashMap<String, String> result;
				try {
					 error=paymentwalletservice.validatePhone(phone6);
						if(error)
						{
					result = paymentwalletservice.printTransaction(phone6);
					System.out.println(result);
					Set<Entry<String,String>> set = result.entrySet();
					Iterator<Entry<String, String>> it = set.iterator();
					while (it.hasNext()) {
						Entry<String, String> entry = it.next();
						if((entry.getKey())==phone6)
						{
						
						//String id11 = entry.getKey();
						String dto = entry.getValue();
					Scanner	scanner2=new Scanner(dto).useDelimiter("*");
					while(scanner2.hasNext())
					{
						System.out.println(scanner2.next());
					}
						System.out.println(dto);
						break;
					}
					}
						}
				} catch (PaymentWalletException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					
					
				break;
			case 7:
				System.out.println("thankyou for using");
				System.exit(0);
				break;
			default:
				System.out.println("enter correct value");
				
			}
			System.out.println("enter y or yes to continue and n or no to exit");
			ch = sc.next();
		} while ((ch.equalsIgnoreCase("y")) || ch.equalsIgnoreCase("yes"));

	}

}


    	/*Scanner scanner =new Scanner(System.in);
        
        System.out.println("enter phone number");
        String phone=scanner.next();
        System.out.println("enter email");
        String email=scanner.next();
        System.out.println("enter gender");
        String gender=scanner.next();
        System.out.println("enter name");
        String name=scanner.next();
        System.out.println("enter age");
        int age=scanner.nextInt();
        System.out.println("enter balance");
        BigDecimal balance=scanner.nextBigDecimal();
        Wallet wallet =new Wallet();
        wallet.setAge(age);
        wallet.setBalance(balance);
        wallet.setGender(gender);
        wallet.setName(name);
        wallet.setPhoneNumber(phone);
        wallet.setEmailId(email);
        Wallet wall=paymentwalletservice.registerCustomer(wallet);
        System.out.println(wall.getEmailId());
        System.out.println(wall.getGender());
        System.out.println(wall.getName());
        
        
        
        System.out.println("enter phone number");
        String phone1=scanner.next();
        System.out.println("enter email");
        String email1=scanner.next();
        System.out.println("enter gender");
        String gender1=scanner.next();
        System.out.println("enter name");
        String name1=scanner.next();
        System.out.println("enter age");
        int age1=scanner.nextInt();
        System.out.println("enter balance");
        BigDecimal balance1=scanner.nextBigDecimal();
        Wallet wallet1 =new Wallet();
        wallet1.setAge(age1);
        wallet1.setBalance(balance1);
        wallet1.setGender(gender1);
        wallet1.setName(name1);
        wallet1.setPhoneNumber(phone1);
        wallet1.setEmailId(email1);
        Wallet wall2=paymentwalletservice.registerCustomer(wallet1);
        System.out.println(wall2.getEmailId());
        System.out.println(wall2.getGender());
        System.out.println(wall2.getName());
        
        
        
       Wallet wall1=paymentwalletservice.showBalance(phone);
       System.out.println(wall1.getEmailId());
       System.out.println(wall1.getGender());
       System.out.println(wall1.getName());
       System.out.println(wall1.getBalance());
       
       
       Wallet wall3=paymentwalletservice.depositMoney(phone, balance);
       System.out.println(wall3.getEmailId());
       System.out.println(wall3.getGender());
       System.out.println(wall3.getName());
       System.out.println(wall3.getBalance());
       
     
       Wallet wall4=paymentwalletservice.fundTransfer(phone, phone1, balance);
       System.out.println(wall4.getEmailId());
       System.out.println(wall4.getGender());
       System.out.println(wall4.getName());
       System.out.println(wall4.getBalance());
       
       
       Wallet wall5=paymentwalletservice.withdrawMoney(phone, balance);
       System.out.println(wall5.getEmailId());
       System.out.println(wall5.getGender());
       System.out.println(wall5.getName());
       System.out.println(wall5.getBalance());
       
       HashMap<String,String> result = paymentwalletservice.printTransaction(phone);
		Set<Entry<String,String>> set = result.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String id11 = entry.getKey();
			String dto = entry.getValue();
		Scanner	scanner2=new Scanner(dto).useDelimiter("*");
		while(scanner2.hasNext())
		{
			System.out.println(scanner.next());
		}
		}	
       */
       
    


