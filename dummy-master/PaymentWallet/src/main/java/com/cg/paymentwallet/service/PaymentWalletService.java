package com.cg.paymentwallet.service;

import com.cg.paymentwallet.dao.IPaymentWalletDao;
import com.cg.paymentwallet.dao.PaymentWalletDao;
import java.math.BigDecimal;

import com.cg.paymentwallet.dto.Customer;
import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class PaymentWalletService extends PaymentWalletDao implements IPaymentsWalletService{
IPaymentWalletDao dao=new PaymentWalletDao();
	public Wallet registerCustomer(Wallet wallet) {
		Wallet wallet1= dao.registerCustomer(wallet);
                if(wallet1!=null)
                {
                    return wallet1;
                }
                return null;
	}

	public Wallet depositMoney(String phone, BigDecimal balance) {
		Wallet wallet= dao.depositMoney(balance);
                if(wallet!=null)
                {
                    return wallet;
                }
		return null;
	}

	public Wallet withdrawMoney(String phone, BigDecimal balance) {
            HashMap<String,Wallet> money=(HashMap<String,Wallet>) PaymentWalletDao.accounts;
            Wallet wal=money.get(phone);
            if(wal!=null){
            if(wal.getBalance()>1000){
                Wallet wallet= dao.withdrawMoney(phone,balance);
                if(wallet!=null)
                {
                    return wallet;
                }
            }
            else{
                throw new PaymentWalletException();
            }
            }
		return null;
	}

	public Wallet fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance) {
		// TODO Auto-generated method stub
                HashMap<String,Wallet> money=(HashMap<String,Wallet>) PaymentWalletDao.accounts;
            Wallet wal=money.get(sourcePhone);
            Wallet wall=money.get(targetPhone);
            if((wal!=null)&&(wall!=null)){
            if(wal.getBalance()>1000){
                Wallet wallet= dao.fundTransfer(sourcePhone,targetPhone,balance);
                if(wallet!=null)
                {
                    return wallet;
                }
            }
            else{
                throw new PaymentWalletException();
            }
            }
		return null;
	}

	public Wallet showBalance(String phone) {
		// TODO Auto-generated method stub
		return dao.showBalance(phone);
	}

	public HashMap<LocalDateTime,String> printTransaction(String phone) {
		// TODO Auto-generated method stub
		return dao.printTransaction(phone);
	}

}
