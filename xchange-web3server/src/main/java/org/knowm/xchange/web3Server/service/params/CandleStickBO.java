package org.knowm.xchange.web3Server.service.params;

import lombok.Getter;
import lombok.Setter;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.params.DefaultCandleStickParamWithLimit;

import java.util.Date;

/**
 * candle stick search param
 * @Author Nozdormu
 */
@Setter
@Getter
public class CandleStickBO extends DefaultCandleStickParamWithLimit {
    /**
     * 查询交易对
     */
    CurrencyPair currencyPair;

    public CandleStickBO(Date startDate, Date endDate, long periodInSecs) {
        super(startDate, endDate, periodInSecs,100);
    }
}
