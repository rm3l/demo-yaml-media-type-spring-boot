package org.rm3l.yaml.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

  private final HelloService helloService;

  HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @PostMapping("/hello")
  @ResponseBody
  public HelloRequest.Response sayHello(@RequestBody final HelloRequest request) {
    return this.helloService.sayHello(request);
  }

  @PostMapping(value = "/hello", consumes = {"application/yaml", "application/yml"})
  @ResponseBody
  public HelloRequest.Response sayHelloFromYaml(@RequestBody final Resource resource)
      throws IOException {
    try (final var inputStream = resource.getInputStream()) {
      return this.sayHello(new ObjectMapper(new YAMLFactory())
          .readValue(inputStream, HelloRequest.class));
    }
  }

}
