package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone{
  @Id
  @Column(name = "phone_seq")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int phoneSeq;
  
  @Column(name = "member_id")
  private int memberId;
  
  @Column(name = "no")
  private String no;
  
  public Phone() {}
  public Phone(String no) {
    this.no = no;
  }
  public Phone(String no, int memberId) {
    this.no = no;
    this.memberId = memberId;
  }
  
  public int getPhoneSeq() {
    return phoneSeq;
  }
  
  public void setPhoneSeq(int phoneSeq) {
    this.phoneSeq= phoneSeq;
  }
  
  public int getMemberId() {
    return memberId;
  }
  
  public void setMemberId(int memberId) {
    this.memberId = memberId;
  }
  
  public String getNo() {
   return no; 
  }
  
  public void setNo(String no) {
    this.no = no;
  }
  
  @Override
  public String toString() {
    String result = "[phone_"+phoneSeq+"]" + no;
    return result;
  }
}
