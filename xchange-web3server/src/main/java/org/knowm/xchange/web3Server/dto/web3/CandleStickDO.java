package org.knowm.xchange.web3Server.dto.web3;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.Data;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.knowm.xchange.web3Server.config.ZonedDateTimeDeserializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;


/**
 * Imported candles (map "IMPORTED_CANDLES" table).
 */
@Data
public class CandleStickDO {

    /** Backtesting market name. */
    private String exchangeType;

    /**  OkexCandleStickPeriodType.*/
    private String periodType;

    /** @link OkexCandleStickPeriodType 分钟单位 .*/
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
    /** Volume of trading activity during the bucket interval. */
    private  String quotaVolume;
    /** Volume of trading activity during the bucket interval. */
    private  String vwap; // these 5 fields can be null if not provided by the exchange
    /** Volume of trading activity during the bucket interval. */
    private  String bid;
    /** Volume of trading activity during the bucket interval. */
    private  String bidSize;
    /** Volume of trading activity during the bucket interval. */
    private  String ask;
    /** Volume of trading activity during the bucket interval. */
    private  String askSize;

    /** Bucket start time. */
//    @JsonSerialize(using = ZonedDateTimeSerializer.class)
//    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private Date tsTime;

    /** time string.*/
    private String tsTimeStr;

    /** Bucket start time.*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createTime;


    @Override
    public boolean equals(final Object o) {
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
    public int hashCode() {
        return new HashCodeBuilder()
                .append(tsTime)
                .toHashCode();
    }

}
