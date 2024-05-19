package org.knowm.xchange.web3Server.service.params;

import lombok.Data;
import org.knowm.xchange.currency.CurrencyPair;

import java.util.Date;

/**
 * last candle stick search param
 * @Author Nozdormu
 */
@Data
public class MkLastCandleStickDTO {
    /**
     * k线周期
     */
    private long periodInSecs;
    /**
     * 交易所类型
     */
    private String exchangeType;
    /**
     * 查询交易对
     */
    private  CurrencyPair currencyPair;

    /**
     * 结束时间
     */
    private  Date LastDate;

}
