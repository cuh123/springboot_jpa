package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jpa_member_2")
public class Member_2 {
     
    @Id
    @Column(name="seq")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;
    
    @Column(name="name")
    private String name;
    
    //mappedBy 뜻  자식 필드명 위에 쓰며 자식 위치라는 뜻이며 mappedBy="여기서 member는 Phone 엔티티에서 Member를 참조할때 작성한 필드명이다."
    @OneToMany(cascade=CascadeType.ALL, mappedBy="member")
    private Collection<Phone_2> phone;

    public Member_2(){}
    
    public Member_2(String name){
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
    
    public Collection<Phone_2> getPhone_2() {
        if( phone == null ){
            phone = new ArrayList<Phone_2>();
        }
        return phone;
    }
    
    public void addPhone_2(Phone_2 p){
        Collection<Phone_2> phone = getPhone_2();
        phone.add(p);
    }

    public void setPhone_2(Collection<Phone_2> phone) {
        this.phone = phone;
    }   
    
    @Override
    public String toString() {
        String result = "[member_"+seq+"] " + name;
        return result;
    }
}
