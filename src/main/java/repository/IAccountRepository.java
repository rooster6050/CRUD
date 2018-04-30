package repository;

public interface IAccountRepository {
	
	String getAllAccounts();
	
	String createAccount(String account);
	
	String deleteAccount(long id);

}
