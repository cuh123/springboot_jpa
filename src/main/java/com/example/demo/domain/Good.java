package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Good {
  
  private Integer id;
  private String name;
  private String producturl;
  private String bigimage;
  private Integer price;
  private String spec;
  private String categoryid1;
  private String categoryid2;
  
  }
