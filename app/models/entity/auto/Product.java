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

public class Product extends DatabaseCommonModel{

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // FIELD NAME 
    //----------------------------------------------------------------------
	public static final String ID_PROPERTY = "id   "; // Primary Key Name

	public static final String TITLE_PROPERTY = "title";
	public static final String TYPE_PROPERTY = "type ";
	public static final String CATEGORY_PROPERTY = "category";
	public static final String DESCRIPTION_PROPERTY = "description";
	public static final String TIME_PROPERTY = "time ";
	public static final String IMGMIN_PROPERTY = "imgmin";
	public static final String UPDATED_DATE_PROPERTY = "updatedDate";
	public static final String DELETED_PROPERTY = "deleted";
	public static final String IMGNOMAL_PROPERTY = "imgnomal";
	public static final String CREATED_DATE_PROPERTY = "createdDate";
	public static final String VISIBLE_PROPERTY = "visible";
	public static final String IMGMAX_PROPERTY = "imgmax";
	public static final String COUNTRY_PROPERTY = "country";
	public static final String LINKVIDEO_PROPERTY = "linkvideo";
	public static final String RATE_PROPERTY = "rate ";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_product")
	public Integer    id           ; // Primary Key

	public String     title        ;
	public Integer    type         ;
	public Integer    category     ;
	public String     description  ;
	public Date       time         ;
	public String     imgmin       ;
	public Date       updatedDate  ;
	public Integer    deleted      ;
	public String     imgnomal     ;
	public Date       createdDate  ;
	public Integer    visible      ;
	public String     imgmax       ;
	public Integer    country      ;
	public String     linkvideo    ;
	public String     rate         ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    



    //----------------------------------------------------------------------
    // ENTITY LINKS (RELATIONSHIP)
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR 
    //----------------------------------------------------------------------    
    public Product(){
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

    public void setType(Integer type){
        this.type = type;
    }
    public Integer getType(){
        return this.type;
    }

    public void setCategory(Integer category){
        this.category = category;
    }
    public Integer getCategory(){
        return this.category;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public void setTime(Date time){
        this.time = time;
    }
    public Date getTime(){
        return this.time;
    }

    public void setImgmin(String imgmin){
        this.imgmin = imgmin;
    }
    public String getImgmin(){
        return this.imgmin;
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

    public void setImgnomal(String imgnomal){
        this.imgnomal = imgnomal;
    }
    public String getImgnomal(){
        return this.imgnomal;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }
    public Date getCreatedDate(){
        return this.createdDate;
    }

    public void setVisible(Integer visible){
        this.visible = visible;
    }
    public Integer getVisible(){
        return this.visible;
    }

    public void setImgmax(String imgmax){
        this.imgmax = imgmax;
    }
    public String getImgmax(){
        return this.imgmax;
    }

    public void setCountry(Integer country){
        this.country = country;
    }
    public Integer getCountry(){
        return this.country;
    }

    public void setLinkvideo(String linkvideo){
        this.linkvideo = linkvideo;
    }
    public String getLinkvideo(){
        return this.linkvideo;
    }

    public void setRate(String rate){
        this.rate = rate;
    }
    public String getRate(){
        return this.rate;
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
        sb.append(type);
        sb.append("|");
        sb.append(category);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(time);
        sb.append("|");
        sb.append(imgmin);
        sb.append("|");
        sb.append(updatedDate);
        sb.append("|");
        sb.append(deleted);
        sb.append("|");
        sb.append(imgnomal);
        sb.append("|");
        sb.append(createdDate);
        sb.append("|");
        sb.append(visible);
        sb.append("|");
        sb.append(imgmax);
        sb.append("|");
        sb.append(country);
        sb.append("|");
        sb.append(linkvideo);
        sb.append("|");
        sb.append(rate);
        return sb.toString(); 
    } 

}