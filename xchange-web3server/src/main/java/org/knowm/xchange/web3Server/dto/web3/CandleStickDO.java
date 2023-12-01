package org.knowm.xchange.web3Server.dto.web3;

import lombok.*;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;


/**
 * Imported candles (map "IMPORTED_CANDLES" table).
 * 与clickhouse统一下 TODO
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandleStickDO {

    /** Backtesting market name */
    private String exchangeType;

    /** @link OkexCandleStickPeriodType */
    private String PeriodType;

    /** @link OkexCandleStickPeriodType 分钟单位 */
    private long periodMinutes;

    /** The currency-pair. Backtesting candle id.*/
    private String currencyPair;

    /** Opening price (first trade) in the bucket interval. */
    private BigDecimal open;

    /** Highest price during the bucket interval. */
    private BigDecimal high;

    /** Lowest price during the bucket interval. */
    private BigDecimal low;

    /** Closing price (last trade) in the bucket interval. */
    private BigDecimal close;

    /** Volume of trading activity during the bucket interval. */
    private BigDecimal volume;

    private  String quotaVolume;

    private  String vwap; // these 5 fields can be null if not provided by the exchange

    private  String bid;

    private  String bidSize;

    private  String ask;

    private  String askSize;

    /** Bucket start time. */
    private ZonedDateTime tsTime;

    /** time string */
    private String tsTimeStr;

    /** Bucket start time. */
    private LocalDateTime createTime;

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        CandleStickDO that = (CandleStickDO) o;
        return Objects.equals(tsTime, that.tsTime);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(tsTime)
                .toHashCode();
    }

}
