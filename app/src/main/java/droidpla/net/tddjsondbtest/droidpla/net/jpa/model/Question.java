
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
import droidpla.net.tddjsondbtest.droidpla.net.jpa.model.Task;
import droidpla.net.tddjsondbtest.droidpla.net.jpa.model.Option;

/**
 *
 * <p>Title: Question</p>
 *
 * <p>Description: Domain Object describing a Question entity</p>
 *
 */
@Entity (name="Question")
@Table (name="\"question\"")
@NamedQueries ({
	 @NamedQuery(name="Question.findAll", query="SELECT a FROM Question a")
	,@NamedQuery(name="Question.findByTitle", query="SELECT a FROM Question a WHERE a.title = :title")
	,@NamedQuery(name="Question.findByTitleContaining", query="SELECT a FROM Question a WHERE a.title like :title")

	,@NamedQuery(name="Question.findBySummary", query="SELECT a FROM Question a WHERE a.summary = :summary")
	,@NamedQuery(name="Question.findBySummaryContaining", query="SELECT a FROM Question a WHERE a.summary like :summary")

})

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Question.findAll";
    public static final String FIND_BY_TITLE = "Question.findByTitle";
    public static final String FIND_BY_TITLE_CONTAINING ="Question.findByTitleContaining";
    public static final String FIND_BY_SUMMARY = "Question.findBySummary";
    public static final String FIND_BY_SUMMARY_CONTAINING ="Question.findBySummaryContaining";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @title-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @title-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-title@
    @Column(name="title"  , length=255 , nullable=true , unique=false)
    private String title; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @summary-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @summary-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-summary@
    @Column(name="summary"  , length=255 , nullable=true , unique=false)
    private String summary; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="option_id", referencedColumnName = "id" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Option optionId;  

    @Column(name="option_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer optionId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @taskQuestionViaQuestionId-field-question@
    @OneToMany (targetEntity=droidpla.net.tddjsondbtest.droidpla.net.jpa.model.Task.class, fetch=FetchType.LAZY, mappedBy="questionId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Task> taskQuestionViaQuestionId = new HashSet<Task>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Question() {
    }

	/**
	* All field constructor 
	*/
    public Question(
       Integer id,
       String title,
       String summary,
       Integer optionId) {
	 this(
       id,
       title,
       summary,
       optionId
	 ,true);
	}
    
	public Question(
       Integer id,
       String title,
       String summary,
       Integer optionId	
    , boolean setRelationship) {
       //primary keys
       setId (id);
       //attributes
       setTitle (title);
       setSummary (summary);
       //parents
       if (setRelationship) this.optionId = new Option();
       if (setRelationship) this.optionId.setId(optionId); 
	   setOptionId_ (optionId);
    }

	public Question flat() {
	   return new Question(
          getId(),
          getTitle(),
          getSummary(),
          getOptionId_()
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-summary@
    public String getSummary() {
        return summary;
    }
	
    public void setSummary (String summary) {
        this.summary =  summary;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Option getOptionId () {
    	return optionId;
    }
	
    public void setOptionId (Option optionId) {
    	this.optionId = optionId;
    }

    public Integer getOptionId_() {
        return optionId_;
    }
	
    public void setOptionId_ (Integer optionId) {
        this.optionId_ =  optionId;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @taskQuestionViaQuestionId-getter-question@
    public Set<Task> getTaskQuestionViaQuestionId() {
        if (taskQuestionViaQuestionId == null){
            taskQuestionViaQuestionId = new HashSet<Task>();
        }
        return taskQuestionViaQuestionId;
    }

    public void setTaskQuestionViaQuestionId (Set<Task> taskQuestionViaQuestionId) {
        this.taskQuestionViaQuestionId = taskQuestionViaQuestionId;
    }	
    
    public void addTaskQuestionViaQuestionId (Task element) {
    	    getTaskQuestionViaQuestionId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
