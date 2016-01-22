
package droidpla.net.tddjsondbtest.droidpla.net.jpa.model;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;
import droidpla.net.tddjsondbtest.droidpla.net.jpa.model.Question;

/**
 *
 * <p>Title: Task</p>
 *
 * <p>Description: Domain Object describing a Task entity</p>
 *
 */
@Entity (name="Task")
@Table (name="\"task\"")
@NamedQueries ({
	 @NamedQuery(name="Task.findAll", query="SELECT a FROM Task a")
	,@NamedQuery(name="Task.findByTitle", query="SELECT a FROM Task a WHERE a.title = :title")
	,@NamedQuery(name="Task.findByTitleContaining", query="SELECT a FROM Task a WHERE a.title like :title")

	,@NamedQuery(name="Task.findByHidden", query="SELECT a FROM Task a WHERE a.hidden = :hidden")

})

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Task.findAll";
    public static final String FIND_BY_TITLE = "Task.findByTitle";
    public static final String FIND_BY_TITLE_CONTAINING ="Task.findByTitleContaining";
    public static final String FIND_BY_HIDDEN = "Task.findByHidden";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @title-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @title-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-title@
    @Column(name="title"  , length=256 , nullable=true , unique=false)
    private String title; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @hidden-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @hidden-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-hidden@
    @Column(name="hidden"   , nullable=true , unique=false)
    private Integer hidden; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="question_id", referencedColumnName = "id" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Question questionId;  

    @Column(name="question_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer questionId_;

    /**
    * Default constructor
    */
    public Task() {
    }

	/**
	* All field constructor 
	*/
    public Task(
       Integer id,
       String title,
       Integer hidden,
       Integer questionId) {
	 this(
       id,
       title,
       hidden,
       questionId
	 ,true);
	}
    
	public Task(
       Integer id,
       String title,
       Integer hidden,
       Integer questionId	
    , boolean setRelationship) {
       //primary keys
       setId (id);
       //attributes
       setTitle (title);
       setHidden (hidden);
       //parents
       if (setRelationship) this.questionId = new Question();
       if (setRelationship) this.questionId.setId(questionId); 
	   setQuestionId_ (questionId);
    }

	public Task flat() {
	   return new Task(
          getId(),
          getTitle(),
          getHidden(),
          getQuestionId_()
       , false
	   );
	}

    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-title@
    public String getTitle() {
        return title;
    }
	
    public void setTitle (String title) {
        this.title =  title;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-hidden@
    public Integer getHidden() {
        return hidden;
    }
	
    public void setHidden (Integer hidden) {
        this.hidden =  hidden;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Question getQuestionId () {
    	return questionId;
    }
	
    public void setQuestionId (Question questionId) {
    	this.questionId = questionId;
    }

    public Integer getQuestionId_() {
        return questionId_;
    }
	
    public void setQuestionId_ (Integer questionId) {
        this.questionId_ =  questionId;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
