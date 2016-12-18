package br.com.dao.dao_lib.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

public class MessageHelper {

	private FacesContext context;
	private Flash flash;

	@Inject
	public MessageHelper(FacesContext context, Flash flash){
		this.context = context;
		this.flash = flash;
	}
	
	public MessageHelper onFlash(){
		flash.setKeepMessages(true);
		return this;
	}
	
	public void addMessage(FacesMessage facesMessage){
		addMessage(null, facesMessage);
	}

	private void addMessage(String clientId, FacesMessage facesMessage) {
		context.addMessage(clientId, facesMessage);
	}
}
