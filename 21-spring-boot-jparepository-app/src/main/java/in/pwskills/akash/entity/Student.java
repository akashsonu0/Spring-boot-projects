package in.pwskills.akash.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stdId;
	
	@Column(name="sname")
	private String stdName;
	
	@Column(name="sfee")
	private Double stdfee;
	
	@Column(name="sdoj")
	//@Temporal(TemporalType.DATE)//stores only date
	//@Temporal(TemporalType.TIME)//stores only time
	@Temporal(TemporalType.TIMESTAMP)//store both data and time(default)
	private Date stdDoj;
	
	public Student() {
		
	}

	public Student(String stdName, Double stdfee, Date stdDoj) {
		this.stdName = stdName;
		this.stdfee = stdfee;
		this.stdDoj = stdDoj;
	}

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public Double getStdfee() {
		return stdfee;
	}

	public void setStdfee(Double stdfee) {
		this.stdfee = stdfee;
	}

	public Date getStdDoj() {
		return stdDoj;
	}

	public void setStdDoj(Date stdDoj) {
		this.stdDoj = stdDoj;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdfee=" + stdfee + ", stdDoj=" + stdDoj + "]";
	}

	
	

}
