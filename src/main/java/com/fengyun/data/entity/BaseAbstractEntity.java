package com.fengyun.data.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 一种抽象实体类，提供ID和版本属性，以及基本的持久化方法
 * 
 */
@MappedSuperclass
public abstract class BaseAbstractEntity {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
    @Column(name = "id")
    protected String id;

    @Version
    @Column(name = "version")
    protected int version;
    
    /**
     * 0 为无效
     * 1 为有效
     */
    @Column(name = "is_available")
    protected int isAvailable;
    
    @Column(name = "creator_id" , updatable = false)
    protected String creatorId;
    
    @Column(name = "create_date" , updatable = false)
    @Temporal(value= TemporalType.TIMESTAMP)
    protected Date createDate;
    
	@Transient
	protected String createDateFormat;
    
    @Column(name = "modifier_id")
    protected String modifierId;
    
    @Column(name = "modify_date")
    @Temporal(value= TemporalType.TIMESTAMP)
    protected Date modifyDate;
    
    @Transient
    protected String modifyDateFormat;
//    @PreUpdate
//    public void preUpdate() {
//    	modifierId = CurrentUserHelper.getUserAccount();
//    	modifyDate = new Date();
//    }
//
//    @PrePersist
//    public void prePersist() {
//    	createDate = new Date();
//    	modifyDate = createDate;
//    	creatorId = CurrentUserHelper.getUserAccount();
//    	modifierId = creatorId;
//    	isAvailable = Availability.available;
//    }
    
    /**
     * 获得实体的标识
     *
     * @return 实体的标识
     */
    public String getId() {
        return id;
    }

	/**
	 * @return the isAvailable
	 */
	public int getIsAvailable() {
		return isAvailable;
	}
	/**
	 * @return the isAvailable
	 */
	public int getIsAvailableInt() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the creatorId
	 */
	public String getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the modifierId
	 */
	public String getModifierId() {
		return modifierId;
	}

	/**
	 * @param modifierId the modifierId to set
	 */
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
     * 设置实体的标识
     *
     * @param id 要设置的实体标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获得实体的版本号。持久化框架以此实现乐观锁。
     *
     * @return 实体的版本号
     */
    public int getVersion() {
        return version;
    }

    /**
     * 设置实体的版本号。持久化框架以此实现乐观锁。
     *
     * @param version 要设置的版本号
     */
    public void setVersion(int version) {
        this.version = version;
    }

	public String getCreateDateFormat() {
		return createDateFormat;
	}

	public void setCreateDateFormat(String createDateFormat) {
		this.createDateFormat = createDateFormat;
	}

	/**
	 * @return the modifyDateFormat
	 */
	public String getModifyDateFormat() {
		return modifyDateFormat;
	}

	/**
	 * @param modifyDateFormat the modifyDateFormat to set
	 */
	public void setModifyDateFormat(String modifyDateFormat) {
		this.modifyDateFormat = modifyDateFormat;
	}
	
}
