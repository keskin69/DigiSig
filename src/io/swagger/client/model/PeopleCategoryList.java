package io.swagger.client.model;

import io.swagger.client.StringUtil;
import io.swagger.client.model.PeopleCategory;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-16T13:57:18.496Z")
public class PeopleCategoryList   {
  
  private List<PeopleCategory> categories = new ArrayList<PeopleCategory>();

  
  /**
   * [read-only]
   **/
  @ApiModelProperty(value = "[read-only]")
  @JsonProperty("categories")
  public List<PeopleCategory> getCategories() {
    return categories;
  }
  public void setCategories(List<PeopleCategory> categories) {
    this.categories = categories;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeopleCategoryList {\n");
    
    sb.append("    categories: ").append(StringUtil.toIndentedString(categories)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
