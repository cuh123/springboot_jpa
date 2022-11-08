package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_1")
public class Phone_1 {
    
    @Id
    @Column(name="seq")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="no")
    private String no;

    @ManyToOne(targetEntity=Member_1.class, fetch=FetchType.LAZY, cascade = {CascadeType.ALL}) // (1)
    @JoinColumn(name ="member_id") // (2)
    private Member_1 member;
    
    public Phone_1() {}
    public Phone_1(String no){
        this.no = no;
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
    
    public Member_1 getMember() {
        return member;
    }
    
    public void setMember(Member_1 member) {
        this.member = member;
    }   
    
    @Override
    public String toString() {
        String result = "[phone_"+seq+"] " + no;
        return result;
    }
}