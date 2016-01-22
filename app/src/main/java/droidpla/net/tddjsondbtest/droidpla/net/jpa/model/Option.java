
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
 * <p>Title: Option</p>
 *
 * <p>Description: Domain Object describing a Option entity</p>
 *
 */
@Entity (name="Option")
@Table (name="\"option\"")
@NamedQueries ({
	 @NamedQuery(name="Option.findAll", query="SELECT a FROM Option a")
	,@NamedQuery(name="Option.findByType", query="SELECT a FROM Option a WHERE a.type = :type")
	,@NamedQuery(name="Option.findByTypeContaining", query="SELECT a FROM Option a WHERE a.type like :type")

	,@NamedQuery(name="Option.findByLabel", query="SELECT a FROM Option a WHERE a.label = :label")
	,@NamedQuery(name="Option.findByLabelContaining", query="SELECT a FROM Option a WHERE a.label like :label")

	,@NamedQuery(name="Option.findByQuestionId", query="SELECT a FROM Option a WHERE a.questionId = :questionId")

})

public class Option implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Option.findAll";
    public static final String FIND_BY_TYPE = "Option.findByType";
    public static final String FIND_BY_TYPE_CONTAINING ="Option.findByTypeContaining";
    public static final String FIND_BY_LABEL = "Option.findByLabel";
    public static final String FIND_BY_LABEL_CONTAINING ="Option.findByLabelContaining";
    public static final String FIND_BY_QUESTIONID = "Option.findByQuestionId";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.TABLE)//AUTO
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-type@
    @Column(name="type"  , length=45 , nullable=true , unique=false)
    private String type; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @label-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @label-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-label@
    @Column(name="label"  , length=45 , nullable=true , unique=false)
    private String label; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @question_id-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @question_id-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-question_id@
    @Column(name="question_id"   , nullable=true , unique=false)
    private Integer questionId; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @questionOptionViaOptionId-field-option@
    @OneToMany (targetEntity=droidpla.net.tddjsondbtest.droidpla.net.jpa.model.Question.class, fetch=FetchType.LAZY, mappedBy="optionId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Question> questionOptionViaOptionId = new HashSet<Question>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Option() {
    }

	/**
	* All field constructor 
	*/
    public Option(
       Integer id,
       String type,
       String label,
       Integer questionId) {
	 this(
       id,
       type,
       label,
       questionId
	 ,true);
	}
    
	public Option(
       Integer id,
       String type,
       String label,
       Integer questionId	
    , boolean setRelationship) {
       //primary keys
       setId (id);
       //attributes
       setType (type);
       setLabel (label);
       setQuestionId (questionId);
       //parents
    }

	public Option flat() {
	   return new Option(
          getId(),
          getType(),
          getLabel(),
          getQuestionId()
       , false
	   );
	}

    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-type@
    public String getType() {
        return type;
    }
	
    public void setType (String type) {
        this.type =  type;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-label@
    public String getLabel() {
        return label;
    }
	
    public void setLabel (String label) {
        this.label =  label;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-question_id@
    public Integer getQuestionId() {
        return questionId;
    }
	
    public void setQuestionId (Integer questionId) {
        this.questionId =  questionId;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @questionOptionViaOptionId-getter-option@
    public Set<Question> getQuestionOptionViaOptionId() {
        if (questionOptionViaOptionId == null){
            questionOptionViaOptionId = new HashSet<Question>();
        }
        return questionOptionViaOptionId;
    }

    public void setQuestionOptionViaOptionId (Set<Question> questionOptionViaOptionId) {
        this.questionOptionViaOptionId = questionOptionViaOptionId;
    }	
    
    public void addQuestionOptionViaOptionId (Question element) {
    	    getQuestionOptionViaOptionId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
