package br.com.dao.dao_lib.jsf.phaselistener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseListenerGenerico implements PhaseListener {

	private static final long serialVersionUID = -1918937031913113297L;

	private final PhaseListenerObserver observer = new PhaseListenerObserver();

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		this.observer.after().fire(phaseEvent);
	}

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {
		this.observer.before().fire(phaseEvent);

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
