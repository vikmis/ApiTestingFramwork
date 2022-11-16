package com.w2a.ApiTestingFramwork.POJO;

public class Paypal {

	private ExperienceContext experience_context;

	public Paypal(ExperienceContext experience_context) {

		this.experience_context = experience_context;
	}

	public ExperienceContext getExperience_context() {
		return this.experience_context;
	}

	public void setExperience_context(ExperienceContext experience_context) {
		this.experience_context = experience_context;
	}

}
