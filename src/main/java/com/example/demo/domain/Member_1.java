package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jpa_member_1")
public class Member_1 {
    
    @Id
    @Column(name="seq")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;
    
    @Column(name="name")
    private String name;

    public Member_1(){}
    
    public Member_1(String name){
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int id) {
        this.seq = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        String result = "[member_"+seq+"] " + name;
        return result;
    }
}