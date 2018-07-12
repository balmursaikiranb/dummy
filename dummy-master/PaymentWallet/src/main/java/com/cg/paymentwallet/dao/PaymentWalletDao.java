package com.cg.paymentwallet.dao;

import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PaymentWalletDao implements IPaymentWalletDao{
  
        public static Map<String,Wallet> accounts=new HashMap<>();
        public static Map<LocalDateTime,String> transactions=new HashMap<>();
        
	public Wallet registerCustomer(Wallet wallet) {
		accounts.put(wallet.getPhoneNumber(),wallet);
		return wallet;
	}

	public Wallet depositMoney(String phone, BigDecimal balance) {
		Wallet wallet=accounts.get(phone);
                    if(wallet!=null)
                    {
                        BigDecimal updateBalance=((wallet.getBalance()).add(balance));
                        wallet.setBalance(updateBalance);
                        LocalDateTime now=LocalDateTime.now();
                        String action=("you have deposited money: ").concat(balance.toString());
                        transactions.put(now,action);
                        return wallet;
                    }
		return null;
	}

	public Wallet withdrawMoney(String phone, BigDecimal balance) {
		Wallet wallet=accounts.get(phone);
                    if(wallet!=null)
                    {
                        BigDecimal updateBalance=((wallet.getBalance()).subtract(balance));
                        wallet.setBalance(updateBalance);
                        LocalDateTime now=LocalDateTime.now();
                        String action=("you have withdrawed money: ").concat(balance.toString());
                        transactions.put(now,action);
                        return wallet;
                    }
                return null;
	}

	public Wallet fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance) {
		Wallet wallet =accounts.get(sourcePhone);
                Wallet wallet1=accounts.get(targetPhone);
                if((wallet!=null)&&(wallet1!=null))
                {
                      BigDecimal updateBalance=((wallet.getBalance()).subtract(balance));
                        wallet.setBalance(updateBalance);
                        BigDecimal updateBalance1=((wallet1.getBalance()).add(balance));
                        wallet.setBalance(updateBalance1);
                        LocalDateTime now=LocalDateTime.now();
                        String action=("you have made fund transfer to: ").concat(targetPhone);
                        String action1=action.concat(" of amount: ");
                        String action2=action1.concat(balance.toString());
                        transactions.put(now,action2);
                        return wallet;
                }
		return null;
	}

	public Wallet showBalance(String phone) {
		Wallet wallet=accounts.get(phone);
                if(wallet!=null)
                {
                    return wallet;
                }
		return null;
	}

	public HashMap<LocalDateTime,String> printTransaction(String phone) {
		Wallet wallet=accounts.get(phone);
                if(wallet!=null)
                {
                    return transactions;
                }
		return null;
	}

   

}
