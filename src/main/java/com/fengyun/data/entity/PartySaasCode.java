package com.fengyun.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * party、saasCode中间表实体
 * @author Lx
 *
 */
@Entity
@Table(name = "t_party_saascodeTest")
public class PartySaasCode extends BaseAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -268460282627924312L;
	
	@Column(name = "party_id")
	private String partyId;

	@Column(name = "saas_code")
	private String saasCode;
	
	public String getSaasCode() {
		return saasCode;
	}

	public void setSaasCode(String saasCode) {
		this.saasCode = saasCode;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	
	
}
