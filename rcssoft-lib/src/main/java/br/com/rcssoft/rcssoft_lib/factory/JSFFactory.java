package br.com.rcssoft.rcssoft_lib.factory;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.rcssoft.rcssoft_lib.jsf.annotation.ScopeMap;
import br.com.rcssoft.rcssoft_lib.jsf.annotation.ScopeMap.Scope;

public class JSFFactory {

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public Flash getFlash() {
		
		return getExternalContext().getFlash();
	}
	
	@Produces
	@ScopeMap(Scope.REQUEST)
	public Map<String, Object> requestMap(){
		return getExternalContext().getApplicationMap();
	}
	
	@Produces
	@ScopeMap(Scope.APPLICATION)
	public Map<String, Object> applicationMap(){
		return getExternalContext().getApplicationMap();
	}
	
	@Produces
	@ScopeMap(Scope.SESSION)
	public Map<String, Object> sessionMap(){
		return getExternalContext().getSessionMap();
	}
	
	@Produces
	@RequestScoped
	public NavigationHandler getNavigationHandler() {
		return getFacesContext().getApplication().getNavigationHandler();
	}

	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
}
