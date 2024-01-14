package com.sky.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
private LocalDateTime timeStamp;
 private String message;
 private String details;

 public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
  this.timeStamp = timeStamp;
  this.message = message;
  this.details = details;
 }
}
