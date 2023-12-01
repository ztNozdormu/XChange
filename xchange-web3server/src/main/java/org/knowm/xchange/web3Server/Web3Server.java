package org.knowm.xchange.web3Server;

import org.knowm.xchange.web3Server.dto.Web3ServerException;
import org.knowm.xchange.web3Server.dto.Web3ServerResponse;
import org.knowm.xchange.web3Server.dto.web3.CandleStickDO;
import org.knowm.xchange.web3Server.service.params.MkCandleStickBO;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/v5")
@Produces(APPLICATION_JSON)
public interface Web3Server {
  String instrumentsPath = "/public/instruments"; // Stated as 20 req/2 sec

  // To avoid 429s, actual req/second may need to be lowered!
  Map<String, List<Integer>> publicPathRateLimits =
      new HashMap<String, List<Integer>>() {
        {
          put(instrumentsPath, Arrays.asList(8, 1));
        }
      };
  @GET
  @Path("/market/history-candles")
  Web3ServerResponse<Set<CandleStickDO>> getHistoryCandles(MkCandleStickBO candleStickBO)
          throws IOException, Web3ServerException;

}
