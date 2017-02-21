package models.entity;

import javax.persistence.MappedSuperclass;

import play.db.ebean.Model;

@MappedSuperclass
public class DatabaseCommonModel extends Model{

	private static final long	serialVersionUID		= 1L;

	/*
	public static final String	CREATE_DATE_PROPERTY	= "createDate";

	public static final String	CREATE_USER_PROPERTY	= "createUser";

	public static final String	UPDATE_DATE_PROPERTY	= "updateDate";

	public static final String	UPDATE_USER_PROPERTY	= "updateUser";

	public static final String	DELETE_FLAG_PROPERTY	= "deleteFlag";

	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	public Calendar				createDate;

	public Integer				createUser;

	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	public Calendar				updateDate;

	public Integer				updateUser;

	public Boolean				deleteFlag;

	// public Integer companyId;

	public Calendar getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Calendar createDate){
		this.createDate = createDate;
	}

	public Integer getCreateUser(){
		return createUser;
	}

	public void setCreateUser(Integer createUser){
		this.createUser = createUser;
	}

	public Calendar getUpdateDate(){
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate){
		this.updateDate = updateDate;
	}

	public Integer getUpdateUser(){
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser){
		this.updateUser = updateUser;
	}

	public Boolean getDeleteFlag(){
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	*/
	
}