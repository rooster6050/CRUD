package interoprability;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import service.IAccountService;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private IAccountService service;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getAllAccounts()
	{
		return service.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.createAccount(account);
	}

}
