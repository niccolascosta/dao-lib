package br.com.dao.dao_lib.jsf.phaselistener;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

import br.com.dao.dao_lib.jsf.phaselistener.annotation.Phase;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase {

	private static final long serialVersionUID = 9198891321863931657L;
	private Phases phases;

	public PhaseLiteral(PhaseId phaseId) {
		phases = Phase.Phases.valueOf(phaseId.getName());
	}

	@Override
	public Phases value() {
		return phases;
	}

}
