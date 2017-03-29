package com.fengyun.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 经纪人信息管理
 * @author katherine
 *
 */
@Entity
@Table(name = "t_party_agent_test")
public class UserAgentManage extends AbstractEntity {
	
	/**
     * 姓名
     */
    @Column(name = "name")
    private String name;

	/**
	 * 用户ID
	 */
	@Column(name = "party_id")
	private String partyId;
	
	/**
	 * 省
	 */
	@Column(name = "province")
	private String province;
	
	/**
	 * 市
	 */
	@Column(name = "city")
	private String city;
	
	/**
	 * 所在地
	 */
	@Column(name = "location")
	private String location;
	
	/**
	 * 挂靠机构
	 */
	@Column(name = "signed_organization")
	private String signedOrganization;
	
	/**
	 * 证书编号
	 */
	@Column(name = "number")
	private String number;
	
	/**
	 * 挂靠机构修改日期
	 */
	@Column(name = "modifer_organization")
	private Date modiferOrganization;
	
	/**
	 * 职业
	 */
	@Column(name = "profession")
	private String profession;
	
	/**
	 * 审核状态（0/待审核，1/启用）
	 */
	@Column(name = "type")
	private String type;

	/**
	 * 身份证
	 */
	@Column(name = "id_num")
	private String idNum;
	
	/**
	 * 工作单位
	 */
	@Column(name = "agency_name")
	private String agencyName;
	
	/**
	 * 联系电话
	 */
	@Column(name = "mobile_phone")
	private String mobilePhone;
	
	/**
	 * 联系电话
	 */
	@Column(name = "email")
	private String email;
	
	/**
	 * 技术领域
	 */
	@Column(name = "industry")
	private String  industry;
	
	@Transient
	private String industryName;
	/**
	 * 机遇网老用户注册时密码密钥
	 */
	@Column(name = "salt")
	private String  salt;
	
	
	/**
	 * 审核意见
	 */
	@Column(name = "suggestion")
	private String suggestion;
	
	/**
	 * 关键字
	 */
	@Column(name = "key_word")
	private String keyWord;
	
	
	



	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 用户ID
	 * @return
	 */
	public String getPartyId() {
		return partyId;
	}

	/**
	 * 用户ID
	 * @param partyId
	 */
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 所在地
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 所在地
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 挂靠机构
	 * @return
	 */
	public String getSignedOrganization() {
		return signedOrganization;
	}

	/**
	 * 挂靠机构
	 * @param signedOrganization
	 */
	public void setSignedOrganization(String signedOrganization) {
		this.signedOrganization = signedOrganization;
	}

	/**
	 * 证书编号
	 * @return
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * 证书编号
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * 挂靠机构修改日期
	 * @return
	 */
	public Date getModiferOrganization() {
		return modiferOrganization;
	}

	/**
	 * 挂靠机构修改日期
	 * @param modiferOrganization
	 */
	public void setModiferOrganization(Date modiferOrganization) {
		this.modiferOrganization = modiferOrganization;
	}

	/**
	 * 职业
	 * @return
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * 职业
	 * @param profession
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * 状态（禁用，启用）
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 状态（禁用，启用）
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
}
