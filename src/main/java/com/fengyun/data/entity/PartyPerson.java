package com.fengyun.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * 登录用户扩展信息
 * @author katherine
 *
 */
@Entity
@Table(name = "t_party_personTest")
public class PartyPerson extends BaseAbstractEntity {
	
	@Column(name = "id_num")
	private String idNum;
	
	@Column(name = "photo")
	private String photo;
	
	
	@Column(name = "gender")
	private String gender;
	

	
	@Column(name = "birth_date")
	@Temporal(value = TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "birth_palce")
	private String birthPlace;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "affiliated")
	private String affiliated;
	
	/*学历*/
	@Column(name = "education")
	private String education;
	
	@Column(name = "xueli")
	private String xueli;
	
	/*学位*/
	@Column(name = "degree")
	private String degree;
	
	
	@Column(name = "graduate_ins")
	private String graduateIns;
	
	@Column(name = "duty")
	private String duty;
	
	/*职称*/
	@Column(name = "professional_title")
	private String professionalTitle;
	

	
	@Column(name = "begin_working_date")
	private Date beginWorkingDate;
	
	@Column(name = "mobile_phone")
	private String mobilePhone;
	
	@Column(name = "home_phone")
	private String homePhone;
	
	//邮政编码
	@Column(name = "email")
	private String email;
	
	@Column(name = "biz_expertise")
	private String bizExpertise;
	
	@Column(name = "achievements")
	private String achievements;
	
	@Column(name = "resume")
	private String resume;
	
	@Column(name = "passport_num")
	private String passportNum;
	
	/**
	 * 单位名称
	 */
	@Column(name = "agency_name")
	private String agencyName;
	
	/**
	 * 行业
	 */
	@Column(name = "industry")
	private String industry;
	
	@Transient
	private String industryName;
	
	/**
	 * 业务专长
	 */
	@Column(name = "business")
	private String business;
	
	/**
	 * 邮政编码
	 */
	@Column(name = "postcode")
	private String postcode;
	
	/**
	 * 身份证件
	 */
	@Column(name = "id_photo")
	private String idPhoto;
	
	

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAffiliated() {
		return affiliated;
	}

	public void setAffiliated(String affiliated) {
		this.affiliated = affiliated;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGraduateIns() {
		return graduateIns;
	}

	public void setGraduateIns(String graduateIns) {
		this.graduateIns = graduateIns;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	public Date getBeginWorkingDate() {
		return beginWorkingDate;
	}

	public void setBeginWorkingDate(Date beginWorkingDate) {
		this.beginWorkingDate = beginWorkingDate;
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

	public String getBizExpertise() {
		return bizExpertise;
	}

	public void setBizExpertise(String bizExpertise) {
		this.bizExpertise = bizExpertise;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	/**
	 * 护照
	 * @return
	 */
	public String getPassportNum() {
		return passportNum;
	}

	/**
	 * 护照
	 * @param passportNum
	 */
	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	

	

	


	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getXueli() {
		return xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	
}
