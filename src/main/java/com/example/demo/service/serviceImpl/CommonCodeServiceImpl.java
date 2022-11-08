package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import com.example.demo.domain.CommonCode;
import com.example.demo.domain.CommonGroupCode;
import com.example.demo.repository.CommonCodeRepository;
import com.example.demo.repository.CommonGroupCodeRepository;
import com.example.demo.service.CommonCodeService;

@Service
public class CommonCodeServiceImpl implements CommonCodeService{
  
  private final CommonCodeRepository commonCodeRepository;
  
  private final CommonGroupCodeRepository commonGroupCodeRepository;
  
  @PersistenceContext
  private EntityManager entityManager;
  
  public CommonCodeServiceImpl(CommonCodeRepository commonCodeRepository, CommonGroupCodeRepository commonGroupCodeRepository) {
    this.commonCodeRepository = commonCodeRepository;
    this.commonGroupCodeRepository = commonGroupCodeRepository;
  }

  public CommonGroupCode getGroupCode(String GroupCode) {
    return commonGroupCodeRepository.findById(GroupCode).orElseThrow(() -> new NoSuchElementException());
  }

  @Override
  public List<CommonGroupCode> getCommonGroupCodeList() {
    List<CommonGroupCode> commonGroupCodes = commonGroupCodeRepository.findAll();
    System.out.println("444444444 : "+commonGroupCodes);
    System.out.println("##########################################################################################");
    for(CommonGroupCode commonGroupCode : commonGroupCodes) {
      System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+commonGroupCodes+"%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
    for(CommonGroupCode commonGroupCode : commonGroupCodes ) {
      for(CommonCode commonCode : commonGroupCode.getCommonCode()) {
        System.out.println("$$$$$"+commonGroupCode.getGroupCd() + " " + commonCode.toString()+"$$$$$");
      }
    }
    System.out.println("##########################################################################################");
    return commonGroupCodeRepository.findAll();
  }

  @Override
  public List<CommonCode> getCommonCode() {
    return commonCodeRepository.findAll();
  }
  
  @Override
  public String setCommonGroupCode(CommonGroupCode commonGroupCode) {
    commonGroupCodeRepository.save(commonGroupCode);
    return null;
  }
  
  @Override
  public String deleteCommonGroupCode(String GroupCode) {
    getGroupCode(GroupCode);
    commonGroupCodeRepository.deleteById(GroupCode);
    return "Success";
  }
  
  @Override
  public String updateCommonGroupCode(CommonGroupCode commonGroupCode) {
    getGroupCode(commonGroupCode.getGroupCd());
    commonGroupCodeRepository.save(commonGroupCode);
    return "Success";
  }

  @Override
  public List<CommonGroupCode> getCommomGroupCodeListQueryDSL(String groupCd) {
    // TODO Auto-generated method stub
    CommonGroupCode commonGroupCode = new CommonGroupCode();
//    entityManager.detach(commonGroupCode);
    System.out.println(entityManager.find(commonGroupCode.getClass(), groupCd));
    return commonGroupCodeRepository.getCommomGroupCodeListQueryDSL(groupCd);
  }

  @Override
  public CommonGroupCode getCommonGroupCodeEntityManager(String groupCd) {
    return entityManager.find(CommonGroupCode.class, groupCd);
  }

  @Override
  public String insertCommonCode(CommonCode commonCode) {
    System.out.println(commonCodeRepository.save(commonCode));
    return null;
  }
}
