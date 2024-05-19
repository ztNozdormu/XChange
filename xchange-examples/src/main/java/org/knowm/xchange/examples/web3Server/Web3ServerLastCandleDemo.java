package org.knowm.xchange.examples.web3Server;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.web3Server.Web3ServerExchange;
import org.knowm.xchange.web3Server.dto.web3.CandleStickDO;
import org.knowm.xchange.web3Server.service.Web3ServerMarketDataService;
import org.knowm.xchange.web3Server.service.params.MkLastCandleStickDTO;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class Web3ServerLastCandleDemo {

  public static void main(String[] args) throws IOException {

    ExchangeSpecification exSpec = new ExchangeSpecification(Web3ServerExchange.class);
    Exchange Web3ServerExchange = ExchangeFactory.INSTANCE.createExchange(exSpec);
    generic(Web3ServerExchange);

  }

  private static void generic(Exchange Web3ServerExchange) {

    // Interested in the public market data feed (no authentication)
    Web3ServerMarketDataService marketDataService = (Web3ServerMarketDataService) Web3ServerExchange.getMarketDataService();


    MkLastCandleStickDTO lastCandleStickDTO = new MkLastCandleStickDTO();
    lastCandleStickDTO.setCurrencyPair(CurrencyPair.BTC_USDT);
    lastCandleStickDTO.setExchangeType("okex");
    lastCandleStickDTO.setPeriodInSecs(15000);
    CandleStickDO candleStickDO = marketDataService.getPeriodLastCandle(lastCandleStickDTO);
    System.out.println(candleStickDO.toString());
  }
}
