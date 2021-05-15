package org.rm3l.yaml.hello;

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

}
