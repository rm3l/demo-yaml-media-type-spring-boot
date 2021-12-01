package org.rm3l.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.nio.charset.StandardCharsets;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
class DemoYamlMessageConverter extends AbstractJackson2HttpMessageConverter {

  DemoYamlMessageConverter() {
    super(new ObjectMapper(new YAMLFactory()),
        new MediaType("application", "yaml", StandardCharsets.UTF_8),
        new MediaType("text", "yaml", StandardCharsets.UTF_8),
        new MediaType("application", "*+yaml", StandardCharsets.UTF_8),
        new MediaType("text", "*+yaml", StandardCharsets.UTF_8),
        new MediaType("application", "yml", StandardCharsets.UTF_8),
        new MediaType("text", "yml", StandardCharsets.UTF_8),
        new MediaType("application", "*+yaml", StandardCharsets.UTF_8),
        new MediaType("text", "*+yaml", StandardCharsets.UTF_8));
  }

  @Override
  public void setObjectMapper(final ObjectMapper objectMapper) {
    if (!(objectMapper.getFactory() instanceof YAMLFactory)) {
      throw new IllegalArgumentException(
          "ObjectMapper must be configured with an instance of YAMLFactory");
    }
    super.setObjectMapper(objectMapper);
  }
}
