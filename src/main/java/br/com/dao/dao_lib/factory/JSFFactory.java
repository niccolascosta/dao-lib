package br.com.dao.dao_lib.factory;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.dao.dao_lib.jsf.annotation.ScopeMap;
import br.com.dao.dao_lib.jsf.annotation.ScopeMap.Scope;

public class JSFFactory {

	@Produces
	@ScopeMap(Scope.APPLICATION)
	public Map<String, Object> applicationMap() {
		return this.getExternalContext().getApplicationMap();
	}

	private ExternalContext getExternalContext() {
		return this.getFacesContext().getExternalContext();
	}

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	@Produces
	@RequestScoped
	public Flash getFlash() {
		return this.getExternalContext().getFlash();
	}

	@Produces
	@RequestScoped
	public NavigationHandler getNavigationHandler() {
		return this.getFacesContext().getApplication().getNavigationHandler();
	}

	@Produces
	@ScopeMap(Scope.REQUEST)
	public Map<String, Object> requestMap() {
		return this.getExternalContext().getRequestMap();
	}

	@Produces
	@ScopeMap(Scope.SESSION)
	public Map<String, Object> sessionMap() {
		return this.getExternalContext().getSessionMap();
	}

}
