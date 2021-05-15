package org.rm3l.yaml.hello;

import java.util.List;
import java.util.Optional;
import org.rm3l.yaml.hello.HelloRequest.Response;
import org.springframework.stereotype.Service;

@Service
class HelloService {

  public HelloRequest.Response sayHello(final HelloRequest helloRequest) {
    return new Response(
        String.format(
            "Hello message from '%s' to %s",
            Optional.ofNullable(helloRequest.getSender()).orElse("-"),
            String.join(", ",
                Optional.ofNullable(helloRequest.getReceivers())
                    .orElse(List.of()))));
  }

}
