package com.fengyun.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Administrator on 2017/3/28.
 */
@Entity
@Table(name = "t_party")
public class LoginParty extends BaseAbstractEntity {

    /**
     * 用户类型
     */
    @Column(name = "party_type")
    private String partyType;

    @Transient
    private String partyTypeName;

    /**
     * 用户姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 审核状态
     */
    @Column(name = "approved")
    private String approved;

    /**
     * for 管理员
     */
    @Transient
    private String approvedName;

    /**
     * for 个人用户
     */
    @Transient
    private String approvedPerson;

    /**
     * for 个人用户
     */
    @Transient
    private String approvedPersonalName;

    /**
     * for 联系人
     */
    @Transient
    private String approvedContactName;

    /**
     * for 非苏州市企业管理员
     */
    @Transient
    private String approvedNonlocalName;

    /**
     * 状态
     */
    @Column(name = "status")
    private String status;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登录密码
     */
    @Column(name="password")
    private String password;

    /**
     * t_agency表id
     */
    @Column(name="agency_id")
    private String agencyId;

    /**
     * t_party_person表id
     */
    @Column(name="party_person_id")
    private String partyPersonId;

    /**
     * 数据来源(内部系统/外部系统)
     */
    @Column(name = "source")
    private String source;

    /**
     * 登录名类型(身份证/护照)
     */
    @Column(name = "login_name_type")
    private String loginNameType;

    /*专家领域*/
    @Transient
    private String expertorIndustryName;

    /*快速用户注册
     * chengse
     * 开始
     * @author enzi123  2016-9-1
     */
    @Column(name = "rank")
    private String rank;   //用户类型  O  快速     p 详细

    @Column(name = "password_login")
    private String passwordLogin;     //用户保存本地登录密码

	/*快速用户注册
	 * chengse
	 * 结束
	 * @author enzi123  2016-9-1
	 */

    @Transient
    private String saasCode;

    public String getSaasCode() {
        return saasCode;
    }

    public void setSaasCode(String saasCode) {
        this.saasCode = saasCode;
    }

    public String getApprovedNonlocalName() {
        return approvedNonlocalName;
    }
    public String getRank() {
        return rank;
    }

    /**
     * 登录名
     * @return
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 登录密码
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登录密码
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 数据来源(内部系统/外部系统)
     * @return
     */
    public String getSource() {
        return source;
    }

    /**
     * 数据来源(内部系统/外部系统)
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPassword_login() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    public void setApprovedNonlocalName(String approvedNonlocalName) {
        this.approvedNonlocalName = approvedNonlocalName;
    }

    public String getApprovedContactName() {
        return approvedContactName;
    }

    public void setApprovedContactName(String approvedContactName) {
        this.approvedContactName = approvedContactName;
    }

    /**
     * 用户类型
     * @return
     */
    public String getPartyType() {
        return partyType;
    }

    /**
     * 用户类型
     * @param partyType
     */
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getPartyTypeName() {
        return partyTypeName;
    }

    public void setPartyTypeName(String partyTypeName) {
        this.partyTypeName = partyTypeName;
    }

    public String getApprovedPerson() {
        return approvedPerson;
    }

    public void setApprovedPerson(String approvedPerson) {
        this.approvedPerson = approvedPerson;
    }

    /**
     * 用户姓名
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 用户姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 审核状态
     * @return
     */
    public String getApproved() {
        return approved;
    }

    /**
     * 审核状态
     * @param approved
     */
    public void setApproved(String approved) {
        this.approved = approved;
    }


    public String getApprovedName() {
        return approvedName;
    }

    public void setApprovedName(String approvedName) {
        this.approvedName = approvedName;
    }

    public String getApprovedPersonalName() {
        return approvedPersonalName;
    }

    public void setApprovedPersonalName(String approvedPersonalName) {
        this.approvedPersonalName = approvedPersonalName;
    }

    /**
     * 状态
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getPartyPersonId() {
        return partyPersonId;
    }

    public void setPartyPersonId(String partyPersonId) {
        this.partyPersonId = partyPersonId;
    }

    /**
     * 登录名类型(身份证/护照)
     * @return
     */
    public String getLoginNameType() {
        return loginNameType;
    }

    /**
     * 登录名类型(身份证/护照)
     * @param loginNameType
     */
    public void setLoginNameType(String loginNameType) {
        this.loginNameType = loginNameType;
    }

    public String getExpertorIndustryName() {
        return expertorIndustryName;
    }

    public void setExpertorIndustryName(String expertorIndustryName) {
        this.expertorIndustryName = expertorIndustryName;
    }

}
