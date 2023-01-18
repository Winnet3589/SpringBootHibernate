package com.springboot.hibernate.utils;

public class InvalidPayloadException extends Throwable {
  private String message;
  public InvalidPayloadException(String message) {
    this.message = message;
  }
}
