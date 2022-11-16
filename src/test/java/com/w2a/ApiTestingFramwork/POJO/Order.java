package com.w2a.ApiTestingFramwork.POJO;

import java.util.ArrayList;

public class Order {

	private String intent;
	private ArrayList<PurchageUnits> purchaseUnits;
	private PaymentSource payment_source;

	public Order(String intent, ArrayList<PurchageUnits> purchaseUnits, PaymentSource payment_source) {

		this.intent = intent;
		this.purchaseUnits = purchaseUnits;
		this.payment_source = payment_source;

	}

	public String getIntent() {
		//return this.intent;
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public ArrayList<PurchageUnits> getPurchaseUnits() {
		//return this.purchaseUnits;
		return purchaseUnits;
	}

	public void setPurchaseUnits(ArrayList<PurchageUnits> purchaseUnits) {
		this.purchaseUnits = purchaseUnits;
	}

	public PaymentSource getPayment_source() {
		//return this.payment_source;
		return payment_source;
	}

	public void setPayment_source(PaymentSource payment_source) {
		this.payment_source = payment_source;
	}
}
