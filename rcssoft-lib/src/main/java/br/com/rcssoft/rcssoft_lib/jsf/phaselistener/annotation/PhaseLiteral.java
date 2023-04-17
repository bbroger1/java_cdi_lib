package br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase {

	private static final long serialVersionUID = 1L;
	private Phases phase;

	public PhaseLiteral(PhaseId phaseId) {
		phase = Phase.Phases.valueOf(phaseId.getName());
	}

	@Override
	public Phases value() {
		return phase;
	}

}
