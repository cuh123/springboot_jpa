package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.demo.domain.Academy;
import com.example.demo.repository.AcademyRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaProjectApplicationTests {
  
//  @Test
//  public void contextLoad() {
//    System.out.println("test 성공");
//    ArrayList<String> test = new ArrayList<String>();
//    test.add("1");
//    test.add("2");
//    test.add("3");
//    
//    System.out.println("test"+ test);
//    assertNotNull(test);
//  }
  
  private static AcademyRepository academyRepository;
  
  public JpaProjectApplicationTests(AcademyRepository academyRepository) {
    this.academyRepository = academyRepository;
    // TODO Auto-generated constructor stub
  }
  
//  @Autowired
//  private AcademyRepositorySupport academyRepositorySupport;
  
  @AfterAll
  public static void tearDown() throws Exception {

    academyRepository.deleteAllInBatch();

  }

  @Test
  public void querydsl_기본_기능_확인() {
    String name = "jojoldu";
    String address = "jojoldu@gamil.com";
    academyRepository.save(new Academy(name, address));
    
    List<Academy> result = academyRepository.findByName(name);
  
//    assertEquals(result.size(), 6);
    assertEquals(result.get(0).getAddress(), address);
    
  }
}
