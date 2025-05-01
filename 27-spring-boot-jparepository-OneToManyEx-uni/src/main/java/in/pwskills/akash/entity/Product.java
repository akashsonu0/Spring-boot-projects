package in.pwskills.akash.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="producttab")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="pid")
	private Integer prodId;
	
	@Column(name="pcode")
	private String prodCode;
	
	@OneToMany
	@JoinColumn(name="modelIdFK", referencedColumnName ="pid")
	private List<Models> mobs;

	public Product() {
		
	}
	
	public Product(Integer prodId, String prodCode, List<Models> mobs) {
		this.prodId = prodId;
		this.prodCode = prodCode;
		this.mobs = mobs;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public List<Models> getMobs() {
		return mobs;
	}

	public void setMobs(List<Models> mobs) {
		this.mobs = mobs;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodCode=" + prodCode + ", mobs=" + mobs + "]";
	}
	
	

}
