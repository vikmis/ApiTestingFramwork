package com.w2a.ApiTestingFramwork.POJO;

public class PaymentSource {

	private Paypal paypal;

	public PaymentSource(Paypal paypal) {

		this.paypal = paypal;
	}

	public Paypal getPaypal() {
		//return this.paypal;
		return paypal;
	}

	public void setPaypal(Paypal paypal) {
		this.paypal = paypal;
	}

}
