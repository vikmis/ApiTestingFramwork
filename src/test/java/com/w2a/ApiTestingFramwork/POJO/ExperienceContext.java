package com.w2a.ApiTestingFramwork.POJO;

public class ExperienceContext {

	private String payment_method_preference;
	private String payment_method_selected;
	private String brand_name;
	private String locale;
	private String landing_page;
	private String shipping_preference;
	private String user_action;
	private String return_url;
	private String cancel_url;

	public ExperienceContext(String payment_method_preference, String payment_method_selected, String brand_name,
			String locale, String landing_page, String shipping_preference, String user_action, String return_url,
			String cancel_url)

	{
		this.payment_method_preference = payment_method_preference;
		this.payment_method_selected = payment_method_selected;
		this.brand_name = brand_name;
		this.locale = locale;
		this.landing_page = landing_page;
		this.shipping_preference = shipping_preference;
		this.user_action = user_action;
		this.return_url = return_url;
		this.cancel_url = cancel_url;

	}

	public String getPayment_method_preference() {
		//return this.payment_method_preference;
		return payment_method_preference;
	}

	public void setPayment_method_preference(String payment_method_preference) {
		this.payment_method_preference = payment_method_preference;
	}

	public String getPayment_method_selected() {
		//return this.payment_method_selected;
		return payment_method_selected;
	}

	public void setPayment_method_selected(String payment_method_selected) {
		this.payment_method_selected = payment_method_selected;
	}

	public String getBrand_name() {
		//return this.brand_name;
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getLocale() {
		//return this.locale;
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLanding_page() {
		//return this.landing_page;
		return landing_page;
	}

	public void setLanding_page(String landing_page) {
		this.landing_page = landing_page;
	}

	public String getShipping_preference() {
		//return this.shipping_preference;
		return shipping_preference;
	}

	public void setShipping_preference(String shipping_preference) {
		this.shipping_preference = shipping_preference;
	}

	public String getUser_action() {
		//return this.user_action;
		return user_action;
	}

	public void setUser_action(String user_action) {
		this.user_action = user_action;
	}

	public String getReturn_url() {
		//return this.return_url;
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getCancel_url() {
		//return this.cancel_url;
		return cancel_url;
	}

	public void setCancel_url(String cancel_url) {
		this.cancel_url = cancel_url;
	}

}
