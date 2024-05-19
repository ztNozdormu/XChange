package org.knowm.xchange.web3Server.service;

import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.web3Server.Web3ServerExchange;
import org.knowm.xchange.web3Server.dto.Web3ServerException;
import org.knowm.xchange.web3Server.dto.web3.CandleStickDO;
import org.knowm.xchange.web3Server.service.params.MkCandleStickDTO;
import org.knowm.xchange.web3Server.service.params.MkLastCandleStickDTO;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.EMPTY_SET;


/** Author: Max Gao (gaamox@tutanota.com) Created: 08-06-2021 */
public abstract class Web3ServerMarketDataServiceRaw extends Web3ServerBaseService {
  public Web3ServerMarketDataServiceRaw(
          Web3ServerExchange exchange, ResilienceRegistries resilienceRegistries) {
    super(exchange, resilienceRegistries);
  }

    public Set<CandleStickDO> getHistoryCandle(MkCandleStickDTO candleStickDTO) {
        Set<CandleStickDO> candleStickDOSet;
        try {
            candleStickDOSet = web3Server.getHistoryCandles(candleStickDTO).getData();
            candleStickDOSet = candleStickDOSet.stream().sorted(Comparator.comparing(CandleStickDO::getTsTime)).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (IOException e) {
            candleStickDOSet = EMPTY_SET;
        }
        return candleStickDOSet;
    }

    public CandleStickDO getPeriodLastCandle(MkLastCandleStickDTO lastCandleStickDTO){

        try {
            Set<CandleStickDO> candleStickDOS = web3Server.getPeriodLastCandle(lastCandleStickDTO).getData();
            return !candleStickDOS.isEmpty()?candleStickDOS.stream().collect(Collectors.toList()).get(0):null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
