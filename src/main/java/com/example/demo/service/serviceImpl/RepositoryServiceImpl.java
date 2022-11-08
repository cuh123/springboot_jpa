package com.example.demo.service.serviceImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Member_2;
import com.example.demo.domain.Phone_2;
import com.example.demo.repository.MemberRepository_2;
import com.example.demo.repository.PhoneRepository_2;
import com.example.demo.service.RepositoryService;

@Service
public class RepositoryServiceImpl implements RepositoryService{
  @Autowired
  private MemberRepository_2 mr;
  
  @Autowired
  private PhoneRepository_2 pr;
  
  public void saveMember() {
    Member_2 first = new Member_2("Jung");
    Member_2 second = new Member_2("Dong");
    Member_2 third = new Member_2("Min");
    
    Phone_2 p = new Phone_2(first, "010-XXXX-YYYY");
    
    mr.save(first);
    mr.save(second);
    mr.save(third);
    
    pr.save(p);
  }
  
  public void print() {
    List<Phone_2> phone = pr.findAll();
    for( Phone_2 p : phone) {
      System.out.println(p.toString()+ " "+ p.getMember_2().toString());
    }
  }
  
  @Transactional
  public void lazyPrint() {
    List<Member_2> member = mr.findAll();
    for( Member_2 m : member) {
      System.out.println(m.toString());
      for( Phone_2 e : m.getPhone_2()) {
        System.out.println(e.toString());
      }
    }
  }
  public void deleteAll() {
    mr.deleteAll();
    pr.deleteAll();
  }

  @Override
  public void lazyPrint2() {
    List<Member_2> member = mr.findAll();
    for(Member_2 m : member) {
      System.out.println(m.toString());
    }
  }
}
