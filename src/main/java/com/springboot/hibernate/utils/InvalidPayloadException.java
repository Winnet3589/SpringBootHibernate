package com.springboot.hibernate.utils;

public class InvalidPayloadException extends Exception {

  private final String message;

  public InvalidPayloadException(String message) {
    this.message = message;
  }
}
