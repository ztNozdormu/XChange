package org.knowm.xchange.examples.web3Server;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.derivative.FuturesContract;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.web3Server.Web3ServerExchange;
import org.knowm.xchange.web3Server.service.Web3ServerMarketDataService;

import java.io.IOException;

public class Web3ServerHistoryCandleDemo {

  public static void main(String[] args) throws IOException {

    ExchangeSpecification exSpec = new ExchangeSpecification(Web3ServerExchange.class);
    Exchange Web3ServerExchange = ExchangeFactory.INSTANCE.createExchange(exSpec);
    generic(Web3ServerExchange);
  }

  private static void generic(Exchange Web3ServerExchange) throws IOException {

    // Interested in the public market data feed (no authentication)
    Web3ServerMarketDataService marketDataService = (Web3ServerMarketDataService) Web3ServerExchange.getMarketDataService();
  // TODO测试
    FuturesContract contract = new FuturesContract(CurrencyPair.BTC_USDT, "SWAP");
    // Get the latest full order book data for BTC/USDT Perpetual Swap
    OrderBook orderBook = marketDataService.getOrderBook(contract);
    System.out.println(orderBook.toString());
    System.out.println(
        "full orderbook size: " + (orderBook.getAsks().size() + orderBook.getBids().size()));
  }
}
