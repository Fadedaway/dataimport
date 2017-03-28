/**
 * 
 */
package com.fengyun.data.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 一种抽象实体类，提供ID和版本属性，以及基本的持久化方法
 * 
 * @author xiongp
 */
@MappedSuperclass
public abstract class AbstractEntity extends BaseAbstractEntity{

    @Column(name = "saas_code")
    protected String saasCode;
    
	public String getSaasCode() {
		return saasCode;
	}

	public void setSaasCode(String saasCode) {
		this.saasCode = saasCode;
	}
	
}
