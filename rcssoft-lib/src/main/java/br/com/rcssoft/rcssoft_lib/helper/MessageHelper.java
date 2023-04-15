package br.com.rcssoft.rcssoft_lib.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessageHelper {

	private FacesContext context;
	
	@Inject
	public MessageHelper(FacesContext context) {
		this.context = context;
	}
	
	public MessageHelper onFlash() {
		context.getExternalContext().getFlash().setKeepMessages(true);
		return this;
	}

	public void addMessage(FacesMessage message) {
		addMessage(null, message);
	}

	private void addMessage(String clientId, FacesMessage message) {
		context.addMessage(clientId, message);
	}
}
