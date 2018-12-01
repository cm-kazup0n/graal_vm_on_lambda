package bootstrap;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Handler {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) throws IOException {
    final Request request = readRequest();
    final Response response = new Response("Hello " + request.getName(), request.getPlace());
    System.out.println(mapper.writeValueAsString(response));
  }

  static Request readRequest() throws IOException {
    final Request request = mapper.readValue(readStdin(), Request.class);
    if(request.getName() == null || request.getName().isEmpty()){
      return new Request("world", "AWS Lambda");
    }else{
      return request;
    }
  }

  static String readStdin() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      if (reader.ready()) {
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
      } else {
        return "";
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
