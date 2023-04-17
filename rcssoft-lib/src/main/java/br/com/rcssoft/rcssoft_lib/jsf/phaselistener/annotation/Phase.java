package br.com.rcssoft.rcssoft_lib.jsf.phaselistener.annotation;

import javax.faces.event.PhaseId;

public @interface Phase {
	Phases value();
	enum Phases{
		RESTORE_VIEW(PhaseId.RESTORE_VIEW), 
		APPLY_REQUEST_VALUES(PhaseId.APPLY_REQUEST_VALUES), 
		PROCESS_VALIDATIONS(PhaseId.PROCESS_VALIDATIONS), 
		UPDATE_MODEL_VALUES(PhaseId.UPDATE_MODEL_VALUES), 
		INVOKE_APPLICATION(PhaseId.INVOKE_APPLICATION), 
		RENDER_RESPONSE(PhaseId.RENDER_RESPONSE);
		
		private PhaseId phaseId;

		Phases(PhaseId phaseId){
			this.phaseId = phaseId;
		}
		
		public PhaseId getPhaseId() {
			return phaseId;
		}
	};
	
	
}
