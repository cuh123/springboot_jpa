package com.example.demo.domain;

import java.sql.Date;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Entity
@Table(name = "COMMON_GROUP_CD")
@ToString
public class CommonGroupCode {
  
  @Id
//  @GeneratedValue
  @Column(name = "GROUP_CD")
  private String groupCd;
  
  @Column(name = "GROUP_CD_NAME")
  private String groupCdName;
  
  @Column(name = "GROUP_CD_DESC")
  private String groupCdDesc;
  
  @Column(name = "SORT_NUM")
  private Integer sortNum;
  
  @Column(name = "USE_YN")
  private char useYn;
  
  @Column(name = "CREATE_DATETIME")
  private Date createDateTime;
  
  @Column(name = "MODIFY_DATETIME")
  @ToString.Exclude
  private Date modifyDateTime;
  
//  @MapsId("commonCodePk")
  @JsonManagedReference             //참조가 되는 앞부분을 의미하며, 정상적으로 직렬화를 수행한다.    (엔티티의 필드가 다른 엔티티를 참조하고 무한루프  방지)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "commonCodePk.groupCd", fetch = FetchType.LAZY)
//  @JoinColumns({
//    @JoinColumn(name = "GROUP_CD", updatable = false, insertable = false)
//  })
  private Collection<CommonCode> commonCode;

  public String getGroupCd() {
    return groupCd;
  }

  public void setGroupCd(String groupCd) {
    this.groupCd = groupCd;
  }

  public String getGroupCdName() {
    return groupCdName;
  }

  public void setGroupCdName(String groupCdName) {
    this.groupCdName = groupCdName;
  }

  public String getGroupCdDesc() {
    return groupCdDesc;
  }

  public void setGroupCdDesc(String groupCdDesc) {
    this.groupCdDesc = groupCdDesc;
  }

  public long getSortNum() {
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

  public Collection<CommonCode> getCommonCode() {
    return commonCode;
  }

  public void setCommonCode(Collection<CommonCode> commonCode) {
    this.commonCode = commonCode;
  }
  
//  @Override
//  public String toString() {
//    return null;
//  }
  
}