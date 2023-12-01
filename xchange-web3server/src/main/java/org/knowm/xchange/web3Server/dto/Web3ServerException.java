package org.knowm.xchange.web3Server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import si.mazi.rescu.HttpStatusExceptionSupport;

/** Author: Max Gao (gaamox@tutanota.com) Created: 08-06-2021 */
public class Web3ServerException extends HttpStatusExceptionSupport {

  private final String message;
  private final int code;

  public Web3ServerException(@JsonProperty("msg") String message, @JsonProperty("code") int code) {
    super(message);
    this.message = message;
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return code + ":" + message;
  }
}
