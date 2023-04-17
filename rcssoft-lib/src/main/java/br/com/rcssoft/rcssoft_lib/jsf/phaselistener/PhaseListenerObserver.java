package br.com.rcssoft.rcssoft_lib.jsf.phaselistener;

import java.lang.annotation.Annotation;

import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;

import br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation.After;
import br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation.Before;
import br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation.PhaseLiteral;

public class PhaseListenerObserver {

	private BeanManager observer = CDI.current().getBeanManager();
	private Annotation momento;
	
	public PhaseListenerObserver after() {
		this.momento = new AnnotationLiteral<After>() {
			private static final long serialVersionUID = 1L;
		};
		
		return this;
	}
	
	public PhaseListenerObserver before() {
		this.momento = new AnnotationLiteral<Before>() {
			private static final long serialVersionUID = 1L;
		};
		
		return this;
	}
	
	public void fire(PhaseEvent phaseEvent) {
		observer.fireEvent(phaseEvent, momento, new PhaseLiteral(phaseEvent.getPhaseId()));		
	}
}
