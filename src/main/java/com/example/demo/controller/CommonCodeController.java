package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.CommonCode;
import com.example.demo.domain.CommonGroupCode;
import com.example.demo.service.CommonCodeService;

@RestController
@RequestMapping(value = "/common")
public class CommonCodeController {
  
//  private final CommonCodeServiceImpl commonCodeServiceImpl;
//  public CommonCodeController(CommonCodeServiceImpl commonCodeServiceImpl) {
//    this.commonCodeServiceImpl = commonCodeServiceImpl;
//  }
  private final CommonCodeService commonCodeService;
  public CommonCodeController(CommonCodeService commonCodeService) {
    this.commonCodeService = commonCodeService;
    // TODO Auto-generated constructor stub
  }
  
  @GetMapping(value = "/group")
  public List<CommonGroupCode> getGroupList() {
    return commonCodeService.getCommonGroupCodeList();
  }
  @GetMapping(value = "/groupDSL")
  public List<CommonGroupCode> getCommomGroupCodeListQueryDSL(@RequestParam("groupCd") String groupCd){
    return commonCodeService.getCommomGroupCodeListQueryDSL(groupCd);
  }
  @GetMapping(value = "/groupEntityManager")
  public CommonGroupCode getCommonGroupEntityManager(String groupCd) {
    return commonCodeService.getCommonGroupCodeEntityManager(groupCd);
  }
  @PostMapping(value = "/groupInsert")
  public String setGroupCode(@RequestBody CommonGroupCode commonGroupCode) {
    commonCodeService.setCommonGroupCode(commonGroupCode);
    return "Success";
  }
  @DeleteMapping(value = "/groupDelete")
  public String deleteGroupCode(@RequestParam("groupCd") String GroupCode) {
    commonCodeService.deleteCommonGroupCode(GroupCode);
    return "Success";
  }
  @PutMapping(value = "/groupUpdate")
  public String upateGroupCode(@RequestBody CommonGroupCode commonGroupCode) {
    commonCodeService.updateCommonGroupCode(commonGroupCode);
    return "Success";
  }

  @GetMapping(value = "/common")
  public List<CommonCode> getCommonList() {
    return commonCodeService.getCommonCode();
  }
  @PostMapping(value = "/commonInsert")
  public String insertCommonCode(@RequestBody CommonCode commonCode) {
    commonCodeService.insertCommonCode(commonCode);

    return "Success";
  }
  
}
