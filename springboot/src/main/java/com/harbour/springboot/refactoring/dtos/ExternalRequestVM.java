package com.harbour.springboot.refactoring.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class ExternalRequestVM {

  @SerializedName("eventName")
  String eventName;

  @SerializedName("environment")
  String environment;
}
