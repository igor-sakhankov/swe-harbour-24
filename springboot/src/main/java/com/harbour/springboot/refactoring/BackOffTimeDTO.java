package com.harbour.springboot.refactoring;

import lombok.Data;

@Data
public class BackOffTimeDTO {

  private long retryAfterTimeInMillis;
  private int backOffTimeDurationInMinutes;
}