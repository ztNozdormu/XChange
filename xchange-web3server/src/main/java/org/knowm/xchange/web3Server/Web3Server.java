package org.knowm.xchange.web3Server;


import org.knowm.xchange.web3Server.dto.Web3ServerResponse;
import org.knowm.xchange.web3Server.dto.web3.CandleStickDO;
import org.knowm.xchange.web3Server.service.params.MkCandleStickDTO;
import org.knowm.xchange.web3Server.service.params.MkLastCandleStickDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Set;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/market/history")
@Produces(APPLICATION_JSON)
public interface Web3Server {

  @POST
  @Path("/historyCandles")
  @Consumes(MediaType.APPLICATION_JSON)
  Web3ServerResponse<Set<CandleStickDO>> getHistoryCandles(MkCandleStickDTO candleStickBO)
          throws IOException;

  @POST
  @Path("/periodLastCandle")
  @Consumes(MediaType.APPLICATION_JSON)
  Web3ServerResponse<Set<CandleStickDO>> getPeriodLastCandle(MkLastCandleStickDTO lastCandleStickDTO)
          throws IOException;
}
