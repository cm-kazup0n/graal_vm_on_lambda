package bootstrap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RequestTest {

  @Test
  public void test_deserialize() throws IOException {
    final Request req = new ObjectMapper().readValue("{\"name\": \"taro\"}", Request.class);
    assertEquals("taro", req.getName());
  }

}