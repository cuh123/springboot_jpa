package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Phone_2")
public class Phone_2 {
    
    @Id
    @Column(name="seq")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="no")
    private String no;

    @ManyToOne(optional=false)
    @JoinColumn(name="member_id")
    private Member_2 member;
    
    public Phone_2() {}
    public Phone_2(Member_2 member, String no){
        this.no = no;
        this.member = member;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    
    public Member_2 getMember_2() {
        return member;
    }
    
    public void setMember_2(Member_2 member) {
        this.member = member;
    }   
    
    @Override
    public String toString() {
        String result = "[phone_"+seq+"] " + no;
        return result;
    }   
}
