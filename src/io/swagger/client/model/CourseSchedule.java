package io.swagger.client.model;

import io.swagger.client.StringUtil;
import io.swagger.client.model.CourseEvent;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-16T13:57:18.496Z")
public class CourseSchedule   {
  
  private List<CourseEvent> events = new ArrayList<CourseEvent>();

  
  /**
   * [read-only]
   **/
  @ApiModelProperty(required = true, value = "[read-only]")
  @JsonProperty("events")
  public List<CourseEvent> getEvents() {
    return events;
  }
  public void setEvents(List<CourseEvent> events) {
    this.events = events;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CourseSchedule {\n");
    
    sb.append("    events: ").append(StringUtil.toIndentedString(events)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
