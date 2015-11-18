package io.swagger.client.model;

import io.swagger.client.StringUtil;
import io.swagger.client.model.PaginationInfo;
import io.swagger.client.model.ResourceBlock;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-16T13:57:18.496Z")
public class SeatBlocksList   {
  
  private PaginationInfo info = null;
  private List<ResourceBlock> data = new ArrayList<ResourceBlock>();

  
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
  public List<ResourceBlock> getData() {
    return data;
  }
  public void setData(List<ResourceBlock> data) {
    this.data = data;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeatBlocksList {\n");
    
    sb.append("    info: ").append(StringUtil.toIndentedString(info)).append("\n");
    sb.append("    data: ").append(StringUtil.toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
