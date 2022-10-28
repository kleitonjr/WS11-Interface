package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	private Integer num;
	private LocalDate data;
	private Double valTotal;
	
	private List<Installment> installments = new ArrayList<>();

	public Contract(Integer num, LocalDate data, Double valTotal) {
		this.num = num;
		this.data = data;
		this.valTotal = valTotal;
	}

	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getValTotal() {
		return valTotal;
	}
	public void setValTotal(Double valTotal) {
		this.valTotal = valTotal;
	}
	public List<Installment> getInstallments() {
		return installments;
	}

	
}
