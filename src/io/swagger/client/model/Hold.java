package io.swagger.client.model;

import io.swagger.client.StringUtil;
import io.swagger.client.model.Price;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-16T13:57:18.496Z")
public class Hold   {
  
  private String id = null;
  private Price price = null;
  private Date expiration = null;

  
  /**
   * [read-only]
   **/
  @ApiModelProperty(required = true, value = "[read-only]")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * [read-only]
   **/
  @ApiModelProperty(required = true, value = "[read-only]")
  @JsonProperty("price")
  public Price getPrice() {
    return price;
  }
  public void setPrice(Price price) {
    this.price = price;
  }

  
  /**
   * [read-only]
   **/
  @ApiModelProperty(required = true, value = "[read-only]")
  @JsonProperty("expiration")
  public Date getExpiration() {
    return expiration;
  }
  public void setExpiration(Date expiration) {
    this.expiration = expiration;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Hold {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    price: ").append(StringUtil.toIndentedString(price)).append("\n");
    sb.append("    expiration: ").append(StringUtil.toIndentedString(expiration)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
