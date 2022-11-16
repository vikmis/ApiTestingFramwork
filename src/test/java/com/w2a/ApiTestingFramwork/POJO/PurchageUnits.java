package com.w2a.ApiTestingFramwork.POJO;

public class PurchageUnits {

	private String reference_id;
	private Amount amount;

	public PurchageUnits(String reference_id, Amount amount) {
		this.reference_id = reference_id;
		this.amount = amount;
	}

	public String getReference_id() {
		//return this.reference_id;
		return reference_id;
	}

	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}

	public Amount getAmount() {
		//return this.amount;
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

}
