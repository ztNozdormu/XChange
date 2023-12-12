package org.knowm.xchange.examples.web3Server;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.web3Server.Web3ServerExchange;

public class Web3ServerExampleUtils {

  private Web3ServerExampleUtils() {}

  public static Exchange createTestExchange() {

    Exchange web3ServerExchange = ExchangeFactory.INSTANCE.createExchange(Web3ServerExchange.class);
    web3ServerExchange.getExchangeSpecification().setApiKey("");
    web3ServerExchange.getExchangeSpecification().setSecretKey("");
    web3ServerExchange.getExchangeSpecification().setUserName("");
    web3ServerExchange.applySpecification(web3ServerExchange.getExchangeSpecification());
    return web3ServerExchange;
  }
}
