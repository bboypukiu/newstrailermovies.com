package models.entity.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.entity.DatabaseCommonModel;

import java.util.Date;

@Entity

public class News extends DatabaseCommonModel{

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // FIELD NAME 
    //----------------------------------------------------------------------
	public static final String ID_PROPERTY = "id   "; // Primary Key Name

	public static final String TITLE_PROPERTY = "title";
	public static final String DESCRIPTION_PROPERTY = "description";
	public static final String IMGNOMAL_PROPERTY = "imgnomal";
	public static final String IMGMAX_PROPERTY = "imgmax";
	public static final String CREATED_DATE_PROPERTY = "createdDate";
	public static final String UPDATED_DATE_PROPERTY = "updatedDate";
	public static final String DELETED_PROPERTY = "deleted";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_news")
	public Integer    id           ; // Primary Key

	public String     title        ;
	public String     description  ;
	public String     imgnomal     ;
	public String     imgmax       ;
	public Date       createdDate  ;
	public Date       updatedDate  ;
	public Integer    deleted      ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    



    //----------------------------------------------------------------------
    // ENTITY LINKS (RELATIONSHIP)
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR 
    //----------------------------------------------------------------------    
    public News(){
        super();
    }

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR THE PRIMARY KEY 
    //----------------------------------------------------------------------    
	public void setId(Integer id){
        this.id = id ;
    }
	public Integer getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public void setImgnomal(String imgnomal){
        this.imgnomal = imgnomal;
    }
    public String getImgnomal(){
        return this.imgnomal;
    }

    public void setImgmax(String imgmax){
        this.imgmax = imgmax;
    }
    public String getImgmax(){
        return this.imgmax;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }
    public Date getCreatedDate(){
        return this.createdDate;
    }

    public void setUpdatedDate(Date updatedDate){
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate(){
        return this.updatedDate;
    }

    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }
    public Integer getDeleted(){
        return this.deleted;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(title);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(imgnomal);
        sb.append("|");
        sb.append(imgmax);
        sb.append("|");
        sb.append(createdDate);
        sb.append("|");
        sb.append(updatedDate);
        sb.append("|");
        sb.append(deleted);
        return sb.toString(); 
    } 

}