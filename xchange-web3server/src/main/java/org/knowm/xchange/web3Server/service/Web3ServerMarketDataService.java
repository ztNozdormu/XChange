package org.knowm.xchange.web3Server.service;

import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.dto.marketdata.*;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.instrument.Instrument;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.web3Server.Web3ServerExchange;
import org.knowm.xchange.web3Server.dto.web3.CandleStickDO;
import org.knowm.xchange.web3Server.service.params.MkCandleStickDTO;
import org.knowm.xchange.web3Server.service.params.MkLastCandleStickDTO;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/** Author: Max Gao (gaamox@tutanota.com) Created: 08-06-2021 */
public class Web3ServerMarketDataService extends Web3ServerMarketDataServiceRaw implements MarketDataService {

  public Web3ServerMarketDataService(Web3ServerExchange exchange, ResilienceRegistries resilienceRegistries) {
    super(exchange, resilienceRegistries);
  }

  @Override
  public Ticker getTicker(Instrument instrument, Object... args) throws IOException {
    throw new NotYetImplementedForExchangeException("Only DefaultCandleStickParam is supported");
  }


  @Override
  public Set<CandleStickDO> getHistoryCandle(MkCandleStickDTO params) {

    if (params == null) {
      throw new NotYetImplementedForExchangeException("Only DefaultCandleStickParam is supported");
    }
    Web3ServerCandleStickPeriodType periodType =
            Web3ServerCandleStickPeriodType.getPeriodTypeFromSecs(params.getPeriodInSecs());
    if (periodType == null) {
      throw new NotYetImplementedForExchangeException("Only discrete period values are supported;" +
              Arrays.toString(Web3ServerCandleStickPeriodType.getSupportedPeriodsInSecs()));
    }
    return super.getHistoryCandle(params);
  }
  @Override
  public CandleStickDO getPeriodLastCandle(MkLastCandleStickDTO lastCandleStickDTO) {
    CandleStickDO candleStickDO = super.getPeriodLastCandle(lastCandleStickDTO);
    return candleStickDO;
  }

}
