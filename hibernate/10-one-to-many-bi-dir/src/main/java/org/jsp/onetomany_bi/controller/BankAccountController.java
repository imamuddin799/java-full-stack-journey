package org.jsp.onetomany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsp.onetomany_bi.dao.BankAccountDao;
import org.jsp.onetomany_bi.dto.Account;
import org.jsp.onetomany_bi.dto.Bank;

public class BankAccountController {

	public static void main(String[] args) {
		
//		Entry-1
		
//		Account account1 = new Account();
//		account1.setAid(1001);
//		account1.setName("Imamuddin");
//		account1.setAddress("Bihar");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1002);
//		account2.setName("Amir");
//		account2.setAddress("Delhi");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1003);
//		account3.setName("Salman");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(101);
//		bank.setName("SBI");
//		bank.setAddress("Bihar");
//		bank.setIfscCode("SBIN0006685");
//		
//		Entry-2

//		Account account1 = new Account();
//		account1.setAid(1004);
//		account1.setName("Imamuddin");
//		account1.setAddress("Bihar");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1005);
//		account2.setName("Amir");
//		account2.setAddress("Delhi");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1006);
//		account3.setName("Salman");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(102);
//		bank.setName("SBI");
//		bank.setAddress("Bihar");
//		bank.setIfscCode("SBIN0006685");
		
//		Entry-3
//
//		Account account1 = new Account();
//		account1.setAid(1007);
//		account1.setName("Imamuddin");
//		account1.setAddress("Bihar");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1008);
//		account2.setName("Amir");
//		account2.setAddress("Delhi");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1009);
//		account3.setName("Salman");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(103);
//		bank.setName("SBI");
//		bank.setAddress("Bihar");
//		bank.setIfscCode("SBIN0006685");
		
//		Entry-4

//		Account account1 = new Account();
//		account1.setAid(1010);
//		account1.setName("Imamuddin");
//		account1.setAddress("Bihar");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1011);
//		account2.setName("Amir");
//		account2.setAddress("Delhi");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1012);
//		account3.setName("Salman");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(104);
//		bank.setName("SBI");
//		bank.setAddress("Bihar");
//		bank.setIfscCode("SBIN0006685");
		
//		Update-1
		
//		Account account1 = new Account();
//		account1.setAid(1001);
//		account1.setName("Imamuddin Ansari");
//		account1.setAddress("Bihar Gopalganj");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1002);
//		account2.setName("Amir Khan");
//		account2.setAddress("Delhi Gurugram");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1003);
//		account3.setName("Salman Khan");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(101);
//		bank.setName("SBI");
//		bank.setAddress("Bihar Gopalganj");
//		bank.setIfscCode("SBIN0006688");
//		
//		Update-2
		
//		Account account1 = new Account();
//		account1.setAid(1004);
//		account1.setName("Imamuddin Ansari");
//		account1.setAddress("Bihar Gopalganj");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1005);
//		account2.setName("Amir Khan");
//		account2.setAddress("Delhi Gurugram");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1006);
//		account3.setName("Salman Khan");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(102);
//		bank.setName("SBI");
//		bank.setAddress("Bihar Patna");
//		bank.setIfscCode("SBIN0006685");
		
//		Update-3

//		Account account1 = new Account();
//		account1.setAid(1007);
//		account1.setName("Imamuddin Ansari");
//		account1.setAddress("Bihar Gopalganj");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1008);
//		account2.setName("Amir Khan");
//		account2.setAddress("Delhi Gurugram");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1009);
//		account3.setName("Salman Khan");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(103);
//		bank.setName("SBI");
//		bank.setAddress("Bihar Siwan");
//		bank.setIfscCode("SBIN0006686");
		
//		Update-4
		
//		Account account1 = new Account();
//		account1.setAid(1010);
//		account1.setName("Imamuddin Ansari");
//		account1.setAddress("Bihar Darbhanga");
//		account1.setMno(7033534143L);
//		
//		Account account2 = new Account();
//		account2.setAid(1011);
//		account2.setName("Amir Khan");
//		account2.setAddress("Delhi NCR");
//		account2.setMno(9876543210L);
//		
//		Account account3 = new Account();
//		account3.setAid(1012);
//		account3.setName("Salman Khan");
//		account3.setAddress("Mumbai");
//		account3.setMno(9087654321L);
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		Bank bank = new Bank();
//		bank.setId(104);
//		bank.setName("SBI");
//		bank.setAddress("Bihar Darbhanga");
//		bank.setIfscCode("SBIN0006689");
		
		
//		Save account
//		Account account1 = new Account();
//		account1.setAid(1012);
//		account1.setName("Imamuddin");
//		account1.setAddress("Bihar");
//		account1.setMno(7033534143L);
//		
//		Bank bank = new Bank();
//		bank.setId(104);
//		bank.setName("SBI");
//		bank.setAddress("Bihar Darbhanga");
//		bank.setIfscCode("SBIN0006689");
		
		BankAccountDao dao = new BankAccountDao();
		
//		Inserting data into the database
		
//		Case-1
//		Bank has Account as well as Account has Bank
//		bank.setAccounts(accounts);
//		account1.setBank(bank);
//		account2.setBank(bank);
//		account3.setBank(bank);
//		dao.saveBank(bank);
		
//		Case-2
//		Account has Bank as well as Bank has Account
//		bank.setAccounts(accounts);
//		account1.setBank(bank);
//		account2.setBank(bank);
//		account3.setBank(bank);
//		dao.saveAccount(account1);
//		dao.saveAccount(account2);
//		dao.saveAccount(account3);
		
//		Case-3
//		Bank has Account but Account does not have Bank
//		bank.setAccounts(accounts);
//		dao.saveBank(bank);
		
//		Case-4
//		Account has Bank but Bank does not have Account
//		account1.setBank(bank);
//		account2.setBank(bank);
//		account3.setBank(bank);
//		dao.saveAccount(account1);
//		dao.saveAccount(account2);
//		dao.saveAccount(account3);
		
//		Finding Bank by id
		
//		dao.findBankById(101);
//		dao.findBankById(102);
//		dao.findBankById(103);
//		dao.findBankById(104);
//		dao.findBankById(105);
		
//		Finding Account by id
		
//		dao.findAccountById(1001);
//		dao.findAccountById(1002);
//		dao.findAccountById(1003);
//		dao.findAccountById(1004);
//		dao.findAccountById(1005);
//		dao.findAccountById(1006);
//		dao.findAccountById(1007);
//		dao.findAccountById(1008);
//		dao.findAccountById(1009);
//		dao.findAccountById(1010);
//		dao.findAccountById(1011);
//		dao.findAccountById(1012);
//		dao.findAccountById(1013);
		
//		Finding all Banks
//		dao.displayAllBanks();
		
//		Finding all Accounts
//		dao.displayAllAccounts();
		
//		Updating Bank and Account by id
		
//		Case-1
//		Bank has Account as well as Account has Bank
//		bank.setAccounts(accounts);
//		account1.setBank(bank);
//		account2.setBank(bank);
//		account3.setBank(bank);
//		dao.updateBankById(bank);
		
//		Case-2
//		Account has Bank as well as Bank has Account
//		bank.setAccounts(accounts);
//		account1.setBank(bank);
//		account2.setBank(bank);
//		account3.setBank(bank);
//		dao.updateAccountById(account1);
//		dao.updateAccountById(account2);
//		dao.updateAccountById(account3);
		
//		Case-3
//		Bank has Account but Account does not have Bank
//		bank.setAccounts(accounts);
//		dao.updateBankById(bank);
		
//		Case-4
//		Account has Bank but Bank does not have Account
//		account1.setBank(bank);
//		account2.setBank(bank);
//		account3.setBank(bank);
//		dao.updateAccountById(account1);
//		dao.updateAccountById(account2);
//		dao.updateAccountById(account3);
		
//		Deleting Account by id
		
//		dao.deleteAccountById(1004);
		
//		Deleting Bank by id
		
//		dao.deleteBankById(101);
		
//		Saving account
//		account1.setBank(bank);
//		dao.addAccount(account1);
		
		
		
		
		
		
		
		
		
		dao.displayAllBanks();
		dao.displayAllAccounts();
	}
}