package org.knowm.xchange.web3Server.service.params;

import lombok.Getter;
import lombok.Setter;
import org.knowm.xchange.web3Server.service.Web3ServerCandleStickPeriodType;

import java.util.Date;

/**
 * candle stick search param
 * @Author Nozdormu
 */
@Setter
@Getter
public class MkCandleStickBO extends CandleStickBO {
    /**
     * k线周期
     */
    public Web3ServerCandleStickPeriodType periodType;
    /**
     * 交易所类型
     */
    String exchangeType;

    /**
     * 数据回溯方向
     * before 历史记录最早时间之前的数据 历史数据
     * since  历史记录最新时间之后的数据 最新数据
     */
     String backType = "before";

    public MkCandleStickBO(Date startDate, Date endDate, Web3ServerCandleStickPeriodType periodType) {
        super(startDate, endDate,periodType.getPeriodInSecs());
    }
}
