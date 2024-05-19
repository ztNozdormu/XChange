package org.knowm.xchange.examples.okex.v5.marketdata;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.derivative.FuturesContract;
import org.knowm.xchange.dto.marketdata.CandleStickData;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.okex.OkexExchange;
import org.knowm.xchange.okex.service.OkexCandleStickPeriodType;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.params.CandleStickDataParams;
import org.knowm.xchange.service.trade.params.DefaultCandleStickParam;
import org.knowm.xchange.service.trade.params.DefaultCandleStickParamWithLimit;

public class OkexDepthDemo {

  public static void main(String[] args) throws IOException {

    ExchangeSpecification exSpec = new ExchangeSpecification(OkexExchange.class);
    exSpec.setProxyHost("localhost");
    exSpec.setProxyPort(10900);
    Exchange okexExchange = ExchangeFactory.INSTANCE.createExchange(exSpec);
    generic(okexExchange);
  }

  private static void generic(Exchange okexExchange) throws IOException {

    // Interested in the public market data feed (no authentication)
    MarketDataService marketDataService = okexExchange.getMarketDataService();
//
//    FuturesContract contract = new FuturesContract(CurrencyPair.BTC_USDT, "SWAP");
//
//    // Get the latest full order book data for BTC/USDT Perpetual Swap
//    OrderBook orderBook = marketDataService.getOrderBook(contract);
//    System.out.println(orderBook.toString());
//    System.out.println("full orderbook size: " + (orderBook.getAsks().size() + orderBook.getBids().size()));
//    Date startDate = new Date();
//    Date endDate = DateUtils.addDays(startDate,-5);
//    CandleStickDataParams candleStickDataParams = new DefaultCandleStickParam(endDate,startDate, OkexCandleStickPeriodType.CANDLE_STICK_4H.getPeriodInSecs());
//
//    CandleStickData candleStickData = marketDataService.getCandleStickData(CurrencyPair.BTC_USDT, candleStickDataParams);
//    System.out.println(candleStickData.toString());

    Date startDate = new Date();
    Date endDate = DateUtils.addMinutes(startDate,-18);
    CandleStickDataParams params = new DefaultCandleStickParamWithLimit(endDate,startDate,OkexCandleStickPeriodType.CANDLE_STICK_15M.getPeriodInSecs(),1);

    CandleStickData candleStickData = marketDataService.getCandleStickData(CurrencyPair.BTC_USDT, params);
    System.out.println(candleStickData.toString());
  }
}
