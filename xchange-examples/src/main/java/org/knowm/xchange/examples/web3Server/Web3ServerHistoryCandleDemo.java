package org.knowm.xchange.examples.web3Server;

import org.apache.commons.lang3.time.DateUtils;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;

import org.knowm.xchange.web3Server.Web3ServerExchange;
import org.knowm.xchange.web3Server.dto.web3.CandleStickDO;
import org.knowm.xchange.web3Server.service.Web3ServerMarketDataService;
import org.knowm.xchange.web3Server.service.params.MkCandleStickDTO;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class Web3ServerHistoryCandleDemo {

  public static void main(String[] args) throws IOException {

    ExchangeSpecification exSpec = new ExchangeSpecification(Web3ServerExchange.class);
    Exchange Web3ServerExchange = ExchangeFactory.INSTANCE.createExchange(exSpec);
    generic(Web3ServerExchange);

  }

  private static void generic(Exchange Web3ServerExchange) throws IOException {

    // Interested in the public market data feed (no authentication)
    Web3ServerMarketDataService marketDataService = (Web3ServerMarketDataService) Web3ServerExchange.getMarketDataService();
//    Date startDate = DateUtils.addDays(new Date(),-5);
//    MkCandleStickBO mkCandleStickBO = new MkCandleStickBO(startDate,
//            new Date(), Web3ServerCandleStickPeriodType.CANDLE_STICK_15M);
//    mkCandleStickBO.setCurrencyPair(CurrencyPair.BTC_USDT);
//    mkCandleStickBO.setExchangeType("okex");
    // TODO 通过策略配置信息构造
    Date startDate = DateUtils.addDays(new Date(),-60);

    MkCandleStickDTO mkCandleStickDTO = new MkCandleStickDTO();
    mkCandleStickDTO.setCurrencyPair(CurrencyPair.BTC_USDT);
    mkCandleStickDTO.setExchangeType("okex");
    mkCandleStickDTO.setStartDate(startDate);
    mkCandleStickDTO.setEndDate(new Date());
    mkCandleStickDTO.setPeriodInSecs(15000);
    Set<CandleStickDO> candleStickDOS = marketDataService.getHistoryCandle(mkCandleStickDTO);
    System.out.println(candleStickDOS.toString());
  }
}
