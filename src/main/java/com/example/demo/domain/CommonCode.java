package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Entity
//@ToString
@Table( name = "COMMON_CD")
public class CommonCode {
  
  @EmbeddedId
  private CommonCodePk commonCodePk;
  
  @Column(name = "CD_NAME")
  private String cdName;
  
  @Column(name = "CD_DESC")
  private String cdDesc;

  @Column(name = "CD_CHAR_VAL1")
  private String cdCharVal1;

  @Column(name = "CD_CHAR_VAL2")
  private String cdCharVal2;

  @Column(name = "CD_CHAR_VAL3")
  private String cdCharVal3;

  @Column(name = "CD_NUM_VAL1")
  private Integer cdNumVal1;

  @Column(name = "CD_NUM_VAL2")
  private Integer cdNumVal2;

  @Column(name = "CD_NUM_VAL3")
  private Integer cdNumVal3;

  @Column(name = "SORT_NUM")
  private Integer sortNum;

  @Column(name = "USE_YN")
  private char useYn;

  @Column(name = "CREATE_DATETIME")
  private Date createDateTime;

  @Column(name = "MODIFY_DATETIME")
  private Date modifyDateTime;
  
//  @MapsId("groupId")
  @JsonBackReference        //참조가 되는 뒷부분을 의미하며, 직렬화를 수행하지 않는다. (엔티티의 필드가 다른 엔티티를 참조하고 무한루프  방지)
//  @ToString.Exclude
  @ManyToOne(optional = false)
  @JoinColumn(name = "GROUP_CD",updatable = false, insertable = false, nullable = true)
  private CommonGroupCode commonGroupCode;
  
  
  public CommonCodePk getCommonCodePk() {
    return commonCodePk;
  }
  public void setCommonCodePk(CommonCodePk commonCodePk) {
    this.commonCodePk = commonCodePk;
  }
  public String getCdDesc() {
    return cdDesc;
  }
  public void setCdDesc(String cdDesc) {
    this.cdDesc = cdDesc;
  }
  public String getCdCharVal1() {
    return cdCharVal1;
  }
  public void setCdCharVal1(String cdCharVal1) {
    this.cdCharVal1 = cdCharVal1;
  }
  public String getCdCharVal2() {
    return cdCharVal2;
  }
  public void setCdCharVal2(String cdCharVal2) {
    this.cdCharVal2 = cdCharVal2;
  }
  public String getCdCharVal3() {
    return cdCharVal3;
  }
  public void setCdCharVal3(String cdCharVal3) {
    this.cdCharVal3 = cdCharVal3;
  }
  public Integer getCdNumVal1() {
    return cdNumVal1;
  }
  public void setCdNumVal1(Integer cdNumVal1) {
    this.cdNumVal1 = cdNumVal1;
  }
  public Integer getCdNumVal2() {
    return cdNumVal2;
  }
  public void setCdNumVal2(Integer cdNumVal2) {
    this.cdNumVal2 = cdNumVal2;
  }
  public Integer getCdNumVal3() {
    return cdNumVal3;
  }
  public void setCdNumVal3(Integer cdNumVal3) {
    this.cdNumVal3 = cdNumVal3;
  }
  public Integer getSortNum() {
    return sortNum;
  }
  public void setSortNum(Integer sortNum) {
    this.sortNum = sortNum;
  }
  public char getUseYn() {
    return useYn;
  }
  public void setUseYn(char useYn) {
    this.useYn = useYn;
  }
  public Date getCreateDateTime() {
    return createDateTime;
  }
  public void setCreateDateTime(Date createDateTime) {
    this.createDateTime = createDateTime;
  }
  public Date getModifyDateTime() {
    return modifyDateTime;
  }
  public void setModifyDateTime(Date modifyDateTime) {
    this.modifyDateTime = modifyDateTime;
  }
  public CommonGroupCode getCommonGroupCode() {
    return commonGroupCode;
  }
  public void setCommonGroupCode(CommonGroupCode commonGroupCode) {
    this.commonGroupCode = commonGroupCode;
  }
  @Override
  public String toString() {
    return "CommonCode [commonCodePk=" + commonCodePk.getCd()+"commonCodePk="+commonCodePk.getGroupCd() + ", cdName=" + cdName + ", cdDesc=" + cdDesc
        + ", cdCharVal1=" + cdCharVal1 + ", cdCharVal2=" + cdCharVal2 + ", cdCharVal3=" + cdCharVal3
        + ", cdNumVal1=" + cdNumVal1 + ", cdNumVal2=" + cdNumVal2 + ", cdNumVal3=" + cdNumVal3
        + ", sortNum=" + sortNum + ", useYn=" + useYn + ", createDateTime=" + createDateTime
        + ", modifyDateTime=" + modifyDateTime+"]";
  }
  
}
