package org.rm3l.yaml.hello;

import java.util.List;

public class HelloRequest {

  private String sender;

  private List<String> receivers;

  public String getSender() {
    return sender;
  }

  @SuppressWarnings("unused")
  public void setSender(String sender) {
    this.sender = sender;
  }

  public List<String> getReceivers() {
    return receivers;
  }

  @SuppressWarnings("unused")
  public void setReceivers(List<String> receivers) {
    this.receivers = receivers;
  }

  public static class Response {

    public final String message;

    public Response(String message) {
      if (message == null || message.isBlank()) {
        throw new IllegalArgumentException("message should not be null or blank");
      }
      this.message = message;
    }
  }
}
