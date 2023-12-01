package org.knowm.xchange.web3Server.service;

import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.web3Server.Web3ServerExchange;
import org.knowm.xchange.web3Server.dto.Web3ServerException;
import org.knowm.xchange.web3Server.dto.Web3ServerResponse;
import org.knowm.xchange.web3Server.dto.web3.CandleStickDO;
import org.knowm.xchange.web3Server.service.params.MkCandleStickBO;

import java.io.IOException;
import java.util.Set;


/** Author: Max Gao (gaamox@tutanota.com) Created: 08-06-2021 */
public abstract class Web3ServerMarketDataServiceRaw extends Web3ServerBaseService {
  public Web3ServerMarketDataServiceRaw(
          Web3ServerExchange exchange, ResilienceRegistries resilienceRegistries) {
    super(exchange, resilienceRegistries);
  }

  public Web3ServerResponse<Set<CandleStickDO>> getHistoryCandle(MkCandleStickBO candleStickBO)
      throws Web3ServerException, IOException {
    return web3Server.getHistoryCandles(candleStickBO);
  }
}
