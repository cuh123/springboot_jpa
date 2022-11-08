package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommonCodePk implements Serializable{
  

  @Column(name = "GROUP_CD")
  private String groupCd;

  @Column(name = "CD")
  private String cd;
  
  public String getGroupCd() {
    return this.groupCd;
  }
  
  public void setGroupCd(String groupCd) {
    this.groupCd = groupCd;
  }
  
  public String getCd() {
    return this.cd;
  }
  
  public void setCd(String cd) {
    this.cd = cd;
  }
};
