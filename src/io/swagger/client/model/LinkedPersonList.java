package io.swagger.client.model;

import io.swagger.client.StringUtil;
import io.swagger.client.model.PaginationInfo;
import java.util.*;
import io.swagger.client.model.LinkedPerson;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-16T13:57:18.496Z")
public class LinkedPersonList   {
  
  private PaginationInfo info = null;
  private List<LinkedPerson> data = new ArrayList<LinkedPerson>();

  
  /**
   * [read-only]
   **/
  @ApiModelProperty(required = true, value = "[read-only]")
  @JsonProperty("info")
  public PaginationInfo getInfo() {
    return info;
  }
  public void setInfo(PaginationInfo info) {
    this.info = info;
  }

  
  /**
   * [read-only]
   **/
  @ApiModelProperty(required = true, value = "[read-only]")
  @JsonProperty("data")
  public List<LinkedPerson> getData() {
    return data;
  }
  public void setData(List<LinkedPerson> data) {
    this.data = data;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkedPersonList {\n");
    
    sb.append("    info: ").append(StringUtil.toIndentedString(info)).append("\n");
    sb.append("    data: ").append(StringUtil.toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
