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


@Entity

public class Country extends DatabaseCommonModel{

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // FIELD NAME 
    //----------------------------------------------------------------------
	public static final String ID_PROPERTY = "id   "; // Primary Key Name

	public static final String NAME_PROPERTY = "name ";
	public static final String DELETED_PROPERTY = "deleted";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_country")
	public Integer    id           ; // Primary Key

	public String     name         ;
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
    public Country(){
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

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
        sb.append(name);
        sb.append("|");
        sb.append(deleted);
        return sb.toString(); 
    } 

}