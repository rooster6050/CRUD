package service;

import javax.inject.Inject;

import repository.IAccountRepository;

public class AccountService implements IAccountService {
	
	
	@Inject private IAccountRepository repo;
	
	@Override
	public String getAllAccounts()
	{
		return repo.getAllAccounts();
	}
	
	@Override
	public String createAccount(String account)
	{
		return repo.createAccount(account);
	}

}
