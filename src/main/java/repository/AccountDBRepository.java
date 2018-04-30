package repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import persistence.Account;
import util.JSONUtil;

public class AccountDBRepository implements IAccountRepository {
	private static final Logger LOGGER = Logger.getLogger(AccountDBRepository.class);
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	

	@Override
	public String getAllAccounts() {
		LOGGER.info("AccountDBRepository getAllAccounts");
		Query query = manager.createQuery("Select m FROM Account m");
		Collection<Account> accounts = (Collection<Account>)query.getResultList();

		return util.getJSONForObject(accounts);
	}
	
	@Override
	public String createAccount(String account)
	{
		LOGGER.info("AccountDBRepository createAccount");
		manager.persist(util.getObjectForJSON(account, Account.class));
		return "Added account";
	}
	
	@Override
	public String deleteAccount(long id)
	{
		LOGGER.info("In AccountDBRepository deleteAccount");
		Account ac = manager.find(Account.class, id);
		if(ac != null)
		{
			manager.remove(manager.find(Account.class, id));
			return "Deleted successfully";
		}
		else return "Account not found";
	}
	
	@Override
	public String updateAccount(long id, String newAccount)
	{
		LOGGER.info("AccountDBRepository updateeAccount");
		Account ac = manager.find(Account.class, id);
		if(ac != null)
		{
			manager.remove(manager.find(Account.class, id));
			manager.persist(util.getObjectForJSON(newAccount, Account.class));
			return "Account updated";
		}
		return "Account not found";
	}
}
