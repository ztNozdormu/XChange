package org.knowm.xchange.web3Server;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.web3Server.service.Web3ServerMarketDataService;
import si.mazi.rescu.SynchronizedValueFactory;


/** Author: Max Gao (gaamox@tutanota.com) Created: 08-06-2021 */
public class Web3ServerExchange extends BaseExchange {

  public static final String PARAM_USE_AWS = "Use_AWS";
  public static final String PARAM_AWS_SSL_URI = "AWSSslUri";
  public static final String PARAM_AWS_HOST = "AWSHost";
  public static final String PARAM_SIMULATED = "simulated";
  public static final String PARAM_PASSPHRASE = "passphrase";
  private static ResilienceRegistries RESILIENCE_REGISTRIES;

  public String accountLevel = "1";

  /** Adjust host parameters depending on exchange specific parameters */
  private static void concludeHostParams(ExchangeSpecification exchangeSpecification) {
    if (exchangeSpecification.getExchangeSpecificParameters() != null) {
      final boolean useAWS =
          Boolean.TRUE.equals(
              exchangeSpecification.getExchangeSpecificParametersItem(PARAM_USE_AWS));
      if (useAWS) {
        exchangeSpecification.setSslUri(
            (String)
                exchangeSpecification.getExchangeSpecificParametersItem(
                    PARAM_AWS_SSL_URI));
        exchangeSpecification.setHost(
            (String)
                exchangeSpecification.getExchangeSpecificParametersItem(PARAM_AWS_HOST));
      }
    }
  }

  @Override
  public void applySpecification(ExchangeSpecification exchangeSpecification) {
    super.applySpecification(exchangeSpecification);
    concludeHostParams(exchangeSpecification);
  }

  @Override
  protected void initServices() {
    concludeHostParams(exchangeSpecification);
    this.marketDataService = new Web3ServerMarketDataService(this, getResilienceRegistries());
  }

  /**
   * For Demo Trading add the following param to exchangeSpecification:
   * exchangeSpecification.setExchangeSpecificParametersItem(PARAM_SIMULATED_TRADING, "1");
   *
   */
  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass());
    exchangeSpecification.setSslUri("https://www.okx.com");
    exchangeSpecification.setHost("okx.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("Web3Server");
    exchangeSpecification.setExchangeDescription("Web3Server Exchange");

    return exchangeSpecification;
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {
    throw new UnsupportedOperationException(
        "Okex uses timestamp rather than a nonce"); // TODO: This
  }

  @Override
  public ResilienceRegistries getResilienceRegistries() {
    if (RESILIENCE_REGISTRIES == null) {
      RESILIENCE_REGISTRIES = Web3ServerResilience.createRegistries();
    }
    return RESILIENCE_REGISTRIES;
  }

  @Override
  public void remoteInit() {

  }
}
