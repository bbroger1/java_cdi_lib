package br.com.rcssoft.rcssoft_lib.jsf.phaselistener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class PhaseListenerGenerico implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Inject
	private PhaseListenerObserver observer;

	@Override
	public void afterPhase(PhaseEvent event) {
		observer
			.after()
			.fire(event);
	}
	
	@Override
	public void beforePhase(PhaseEvent event) {
		observer
			.before()
			.fire(event);
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
