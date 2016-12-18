package br.com.dao.dao_lib.jsf.phaselistener;

import java.lang.annotation.Annotation;

import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;

import br.com.dao.dao_lib.jsf.phaselistener.annotation.After;
import br.com.dao.dao_lib.jsf.phaselistener.annotation.Before;

@SuppressWarnings("serial")
@Vetoed
public class PhaseListenerObserver {

	/*
	 * Existe duas formas de disparar o evento injetando o Event<PhaseEvent>
	 * mais só funciona se estiver dentro do JSF. por que ele tem a
	 * implementação. Ou pelo BeanManager.
	 *
	 * @Inject private Event<PhaseEvent> observer;
	 */
	private final BeanManager observer = CDI.current().getBeanManager();
	private Annotation momento;

	public PhaseListenerObserver after() {
		this.momento = new AnnotationLiteral<After>() {
		};
		return this;
	}

	public PhaseListenerObserver before() {
		this.momento = new AnnotationLiteral<Before>() {
		};
		return this;
	}

	public void fire(PhaseEvent phaseEvent) {
		this.observer.fireEvent(phaseEvent, this.momento, new PhaseLiteral(phaseEvent.getPhaseId()));
	}
}
