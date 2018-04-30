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
		LOGGER.info("MovieDBRepository getAllMovies");
		Query query = manager.createQuery("Select m FROM Movie m");
		Collection<Account> accounts = (Collection<Account>)query.getResultList();

		return util.getJSONForObject(accounts);
	}
}
