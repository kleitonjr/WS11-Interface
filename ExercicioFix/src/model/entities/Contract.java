package model.entities;

import java.util.Date;

public class Contract {
	
	private Integer numCont;
	private Date data;
	private Double valTotal;
	
	public Contract() {
	}
	public Contract(Integer numCont, Date data, Double valTotal) {
		this.numCont = numCont;
		this.data = data;
		this.valTotal = valTotal;
	}
	
	public Integer getNumCont() {
		return numCont;
	}
	public void setNumCont(Integer numCont) {
		this.numCont = numCont;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValTotal() {
		return valTotal;
	}
	public void setValTotal(Double valTotal) {
		this.valTotal = valTotal;
	}
	

}
