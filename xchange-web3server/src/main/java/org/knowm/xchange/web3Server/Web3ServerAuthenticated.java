package org.knowm.xchange.web3Server;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/api/v5")
@Produces(MediaType.APPLICATION_JSON)
public interface Web3ServerAuthenticated extends Web3Server {

}
