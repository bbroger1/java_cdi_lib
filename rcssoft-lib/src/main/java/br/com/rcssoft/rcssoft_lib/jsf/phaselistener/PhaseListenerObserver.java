package br.com.rcssoft.rcssoft_lib.jsf.phaselistener;

import java.lang.annotation.Annotation;

import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation.After;
import br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation.Before;
import br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation.PhaseLiteral;

public class PhaseListenerObserver {
	@Inject
	private Event<PhaseEvent> observer;
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
		observer
			.select(momento)
			.select(new PhaseLiteral(phaseEvent.getPhaseId()))
			.fire(phaseEvent);
		
	}
}
