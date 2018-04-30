package service;

public interface IAccountService {
	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(long id);
	String updateAccount(long id, String newAccount);
}
