package org.jsp.onetomany_bi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomany_bi.dto.Account;
import org.jsp.onetomany_bi.dto.Bank;

public class BankAccountDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	method to save a new Bank
	public void saveBank(Bank bank) {

//		Checking if any bank is saved with the given id or not
		Bank bankFromDatabase = manager.find(Bank.class, bank.getId());
		if (bankFromDatabase == null) {

//			Checking whether user is providing any account or not
			if (bank.getAccounts() != null) {

//				list of accounts provided by user to insert
				List<Account> accounts = bank.getAccounts();

//				List of accounts present in database
				Query query = manager.createQuery("select account from Account account");
				List<Account> accountsFromDatabase = query.getResultList();

//				List of account id's present in the database
				List<Integer> accountIdFromDatabse = new ArrayList<Integer>();
				for (Account account : accountsFromDatabase) {
					accountIdFromDatabse.add(account.getAid());
				}

//				Checking if there is an account already present in database
				Account alreadyPresentAccount = null;
				for (Account account : bank.getAccounts()) {
					if (accountIdFromDatabse.contains(account.getAid())) {
						alreadyPresentAccount = account;
						break;
					}
				}

//				if there is no account already present in database
				if (alreadyPresentAccount == null) {

//					Setting bank to each and every accounts
					for (Account account : accounts) {
						account.setBank(bank);
					}

//					saving bank
					transaction.begin();
					manager.persist(bank);
					transaction.commit();
					System.out.println("Bank saved");
				} else {
					System.out.println("The Account id : " + alreadyPresentAccount.getAid()
							+ " is already present in the database");
				}
			}
			else {
//				When user is not providing any account so creating a bank without any initial user
				transaction.begin();
				manager.persist(bank);
				transaction.commit();
				System.out.println("Bank saved");
			}
		} else {
			System.out.println("The Bank is already present with id : " + bank.getId());
		}
	}

	public void addAccount(Account account) {

//		checking if there is an account present or not with the same id given by user
		Account accountFromDatabase = manager.find(Account.class, account.getAid());
		if (accountFromDatabase == null) {

//			Checking whether bank is given by the user or not
			if (account.getBank() != null) {

//				checking whether the bank which is given by user is present of not
				Bank bankFromDatabase = manager.find(Bank.class, account.getBank().getId());
				if (bankFromDatabase != null) {

//					fetching all the accounts from database to add one more account
					List<Account> accounts = bankFromDatabase.getAccounts();
					accounts.add(account);
					bankFromDatabase.setAccounts(accounts);

//					updating bank by adding one account to it
					transaction.begin();
					manager.merge(bankFromDatabase);
					transaction.commit();
				} else {
					System.out.println("The given bank does not exists first add a bank with id : "
							+ account.getBank().getId() + " and then try to add this account");
				}
			} else {
				System.out.println("You cannot add an account without bank, bank is mandatory");
			}
		} else {
			System.out.println("The Account is already present with id : " + account.getAid());
		}
	}

	public void findBankById(int bankId) {
		Bank bank = manager.find(Bank.class, bankId);
		if (bank != null) {
			System.out.println(bank);
		} else {
			System.out.println("Bank not found with id : " + bankId);
		}
	}

	public void findAccountById(int accountId) {
		Account account = manager.find(Account.class, accountId);
		if (account != null) {
			System.out.println(account);
		} else {
			System.out.println("Account not found with id : " + accountId);
		}
	}

	public void displayAllBanks() {
		Query query = manager.createQuery("select bank from Bank bank");
		List<Bank> banks = query.getResultList();

		if (!banks.isEmpty()) {
			for (Bank bank : banks) {
				System.out.println(bank);
			}
		} else {
			System.out.println("There is no bank present");
		}
	}

	public void displayAllAccounts() {
		Query query = manager.createQuery("select account From Account account");
		List<Account> accounts = query.getResultList();
		if (!accounts.isEmpty()) {
			for (Account account : accounts) {
				System.out.println(account);
			}
		} else {
			System.out.println("There is no account persent");
		}
	}

	public void updateBankById(Bank bank) {

//		Fetching bank from database which we have to update
		Bank bankFromDatabase = manager.find(Bank.class, bank.getId());

//		Checking if the database has the given bank id or not
		if (bankFromDatabase != null) {

//			Collecting all the accounts from the database
			Query query = manager.createQuery("select account from Account account");
			List<Account> accounts = query.getResultList();

//			Collecting all the account's id in a list which are present in database
			List<Integer> accountsIdFromDatabase = new ArrayList<Integer>();
			for (Account account : accounts) {
				accountsIdFromDatabase.add(account.getAid());
			}

//			Iterating Accounts which are given by user
			for (Account account : bank.getAccounts()) {

//				Checking if any Account id is already present in the database which are given by user
				if (accountsIdFromDatabase.contains(account.getAid())) {

//					Since 'if' condition is true, means there is an account present in database with the same account id as user has given
//					Now iterating all the accounts which all are present in database
					for (Account account2 : accounts) {

//						Checking if user given account id and already present account id is same or not 
						if (account.getAid() == account2.getAid()) {

//							now first i am removing account which is already present
							accounts.remove(account2);

//							and setting new account with same id
							accounts.add(account);
						}
					}
				} else {
//					Since there is no account with account id which is provided by the user
//					now i am adding that account to the bank
					accounts.add(account);
				}
			}

//			Finally setting all the updated as well as new accounts to the bank
			bank.setAccounts(accounts);

//			assigning bank to all the user to make it bidirectional
			for (Account account : accounts) {
				account.setBank(bank);
			}

//			now updating the bank
			transaction.begin();
			manager.merge(bank);
			transaction.commit();
			System.out.println("Bank updated successfully");
		} else {
			System.out.println("There is no bank with id : " + bank.getId());
		}
	}

	public void updateAccountById(Account account) {
		
//		Checking user is providing bank or not
		if(account.getBank() != null) {
			Bank bankFromDatabase = manager.find(Bank.class, account.getBank());
			
//			Checking given bank is valid or not
			if(bankFromDatabase != null) {
				
//				Checking Account is present or not
				Account accountFromDatabase = manager.find(Account.class, account.getAid());
				if(accountFromDatabase != null) {
					transaction.begin();
					manager.merge(account);
					transaction.commit();
					System.out.println("Account updated successfully");
				}
				else {
					System.out.println("There is no account present with id : "+ account.getAid());
				}
			}
			else {
				System.out.println("There is no bank found with id : "+ account.getBank().getId());
			}
		}
		else {
			System.out.println("To update an account bank cannot be empty or null");
		}
	}

	public void deleteBankById(int bankId) {
		
//		Checking given bank is present or not
		Bank bank = manager.find(Bank.class, bankId);
		if (bank != null) {
			
//			deleting bank by id
			transaction.begin();
			manager.remove(bank);
			transaction.commit();
			System.out.println("Bank with id : " + bankId + " deleted successfully");
		} else {
			System.out.println("Bank not found with id " + bankId);
		}
	}

	public void deleteAccountById(int accountId) {
		
//		Verifying whether there is an account present in the database or not
		Account account = manager.find(Account.class, accountId);
		if(account != null) {
			
//			Checking that the given account is associated with any bank
			if(account.getBank() != null) {
				
//				Removing the account from the bank which we have to delete
				Bank bank = account.getBank();
				List<Account> accounts = bank.getAccounts();
				accounts.remove(account);
				bank.setAccounts(accounts);
				
//				Setting bank as null to the account otherwise we will get an Exception called java.lang.IllegalArgumentException: org.hibernate.ObjectDeletedException: deleted instance passed to merge: [org.jsp.onetomany_bi.dto.Bank#<null>]
				account.setBank(null);
				
				transaction.begin();
				
//				Removing account along with bank
				manager.remove(account);
				
//				Now re-inserting the bank along with other accounts witch we don't have to delete
				manager.merge(bank);
				transaction.commit();
				System.out.println("Account with id : " + accountId + " deleted successfully");
			}
			else {
//				When bank is not assigned then directly deleting the account
				transaction.begin();
				manager.remove(account);
				transaction.commit();
				System.out.println("Account with id : " + accountId + " deleted successfully");
			}
		}
		else {
			System.out.println("Account not found with id " + accountId);
		}
	}
}