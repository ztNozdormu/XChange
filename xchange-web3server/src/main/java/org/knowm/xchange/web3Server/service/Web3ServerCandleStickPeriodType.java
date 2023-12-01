package org.knowm.xchange.web3Server.service;

public enum Web3ServerCandleStickPeriodType {
  CANDLE_STICK_1M(1, "1m"),
  CANDLE_STICK_3M(3, "3m"),
  CANDLE_STICK_5M(5, "5m"),
  CANDLE_STICK_15M(15, "15m"),
  CANDLE_STICK_30M(30, "30m"),
  CANDLE_STICK_1H(60, "1H"),
  CANDLE_STICK_2H(2 * 60, "2H"),
  CANDLE_STICK_4H(4 * 60, "4H");
  private final long periodInSecs;
  private final String fieldValue;
  Web3ServerCandleStickPeriodType(long periodInMinutes, String fieldValue) {
    this.periodInSecs = periodInMinutes * 1000;
    this.fieldValue = fieldValue;
  }
  static Web3ServerCandleStickPeriodType getPeriodTypeFromSecs(long periodInSecs) {
    Web3ServerCandleStickPeriodType result = null;
    for (Web3ServerCandleStickPeriodType period : Web3ServerCandleStickPeriodType.values()) {
      if (period.periodInSecs == periodInSecs) {
          result = period;
          break;
      }
    }
    return result;
  }
  public static long[] getSupportedPeriodsInSecs() {
    long[] result = new long[Web3ServerCandleStickPeriodType.values().length];
    int index = 0;
    for (Web3ServerCandleStickPeriodType period : Web3ServerCandleStickPeriodType.values()) {
      result[index++] = period.periodInSecs;
    }
    return result;
  }
  public String getFieldValue() {
    return fieldValue;
  }
  public long getPeriodInSecs() {
    return periodInSecs;
  }

}
