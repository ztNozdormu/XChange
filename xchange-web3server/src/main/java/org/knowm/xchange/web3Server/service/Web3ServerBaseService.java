package org.knowm.xchange.web3Server.service;

import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.InternalServerException;
import org.knowm.xchange.exceptions.RateLimitExceededException;
import org.knowm.xchange.service.BaseResilientExchangeService;
import org.knowm.xchange.service.BaseService;
import org.knowm.xchange.web3Server.Web3Server;
import org.knowm.xchange.web3Server.Web3ServerExchange;
import org.knowm.xchange.web3Server.dto.Web3ServerException;

/** Author: Max Gao (gaamox@tutanota.com) Created: 08-06-2021 */
public class Web3ServerBaseService extends BaseResilientExchangeService<Web3ServerExchange>
    implements BaseService {

  protected final Web3Server web3Server;

  public Web3ServerBaseService(Web3ServerExchange exchange, ResilienceRegistries resilienceRegistries) {
    super(exchange, resilienceRegistries);
    web3Server =
        ExchangeRestProxyBuilder.forInterface(Web3Server.class, exchange.getExchangeSpecification())
            .build();

  }

  /** <a href="https://www.okex.com/docs-v5/en/#error-code">...</a> * */
  protected ExchangeException handleError(Web3ServerException exception) {
    if (exception.getMessage().contains("Requests too frequent")) {
      return new RateLimitExceededException(exception);
    } else if (exception.getMessage().contains("System error")) {
      return new InternalServerException(exception);
    } else {
      return new ExchangeException(exception);
    }
  }
}
