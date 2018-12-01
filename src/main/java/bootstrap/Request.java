package bootstrap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

  private String name;
  private String place;

  public Request(){}
  @JsonCreator
  public Request(
          @JsonProperty("name") String name,
          @JsonProperty("place") String place
  ){
    setName(name);
    setPlace(place);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getName() {
    return name;
  }

  public String getPlace() {
    return place;
  }

}
