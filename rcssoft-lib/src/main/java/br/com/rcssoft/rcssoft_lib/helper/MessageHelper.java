package br.com.rcssoft.rcssoft_lib.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

public class MessageHelper {

	private FacesContext context;
	private Flash flash;
	
	@Inject
	public MessageHelper(FacesContext context, Flash flash) {
		this.context = context;
		this.flash = flash;
	}
	
	public MessageHelper onFlash() {
		flash.setKeepMessages(true);
		return this;
	}

	public void addMessage(FacesMessage message) {
		addMessage(null, message);
	}

	private void addMessage(String clientId, FacesMessage message) {
		context.addMessage(clientId, message);
	}
}
