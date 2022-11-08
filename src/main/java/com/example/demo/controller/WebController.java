package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Academy;
import com.example.demo.domain.Member;
import com.example.demo.domain.Member_1;
import com.example.demo.domain.Phone;
import com.example.demo.domain.Phone_1;
import com.example.demo.repository.AcademyRepository;
import com.example.demo.repository.AcademyRepositorySupport;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.RepositoryService;

@RestController
@RequestMapping("/member")
public class WebController{
  
  final private AcademyRepository academyRepository;
  
  final private AcademyRepositorySupport academyRepositorySupport;
  
  final private JpaRepository<Member_1, Integer> memberRepository_1;
  
  final private JpaRepository<Phone_1, Integer> phoneRepository_1;
  
  final private RepositoryService repositoryService;
  
  final private MemberRepository memberRepository;
  
  
  public WebController(JpaRepository<Member_1, Integer> memberRepository_1, JpaRepository<Phone_1, Integer> phoneRepository_1,
      RepositoryService repositoryService, AcademyRepository academyRepository, AcademyRepositorySupport academyRepositorySupport,
      MemberRepository memberRepository) {
    this.memberRepository_1 = memberRepository_1;
    this.phoneRepository_1 = phoneRepository_1;
    this.repositoryService = repositoryService;
    this.academyRepository = academyRepository;
    this.academyRepositorySupport = academyRepositorySupport;
    this.memberRepository = memberRepository;
  }

  @GetMapping("/test")
  @Transactional
  public List<Member> test(){
    Member first = new Member("Jung");
    first.addPhone(new Phone("010-XXXX-XXXX"));
    first.addPhone(new Phone("010-YYYY-YYYY"));

    Member second = new Member("Dong");
    second.addPhone(new Phone("010-ZZZZ-ZZZZ"));
    
    Member third = new Member("Min");
    
    memberRepository.save(first);
    memberRepository.save(second);
    memberRepository.save(third);
    
    List<Member> list = memberRepository.findAll();

    for( Member member : list) {
      System.out.println(member.toString());
    } 

    SchemaExport export = new SchemaExport();
    export.setDelimiter(";");
    export.setHaltOnError(true);
    export.setFormat(true);
//    export.create(true,true);

    return list;
    
//    memberRepository.deleteAll();
    
  }
  
  @GetMapping("/test1")
  public String test1(){
    Member_1 first = new Member_1("Jung");
    Member_1 second = new Member_1("Dong");
    Member_1 third = new Member_1("Min");
    
    memberRepository_1.save(first);
    memberRepository_1.save(second);
    memberRepository_1.save(third);
    
    Phone_1 p = new Phone_1("010-XXXX-YYYY");
    p.setMember(first);
    phoneRepository_1.save(p);
    
    List<Phone_1> phone = phoneRepository_1.findAll();
    
    for(Phone_1 e : phone) {
      System.out.println(e.toString() + " "+ e.getMember().toString());
    }
     
    return "Success";

  }
  @GetMapping("/get/{id}")
  public String getName(@PathVariable int id){
   Optional<Member> list = memberRepository.findById(id);
   System.out.println(list.get().getPhone());
   list.get().toString();

   return list.get().toString();
  }
  
  @GetMapping("/test2")
  public String test2() {

    System.out.println("#####################deleteAll#####################");
    repositoryService.deleteAll();
    System.out.println("#####################deleteAll#####################");
    System.out.println("#####################saveMeber#####################");
    repositoryService.saveMember();
    System.out.println("#####################saveMeber#####################");
    System.out.println("#####################print#####################");
    repositoryService.print();
    System.out.println("#####################print#####################");
    System.out.println("#####################lazyPrint#####################");
    repositoryService.lazyPrint();
    System.out.println("#####################lazyPrint#####################");
    System.out.println("#####################lazyPrint2#####################");
    repositoryService.lazyPrint2();
    System.out.println("#####################lazyPrint2#####################");
    
    return "Success";
  }
  @GetMapping("/test3")
  public String test3() {
    return "Success";
  }
  
  @GetMapping("/test4")
  public List<Academy> QueryDSL_test4() {
    String name = "JoSeongSik";
    String address = "choss002@gamil.com";
    academyRepository.save(new Academy(name, address));
    
//    List<Academy> result = academyRepositorySupport.findByName(name);
    List<Academy> result = academyRepository.findByName(name);
  
    return result;
  }
}
