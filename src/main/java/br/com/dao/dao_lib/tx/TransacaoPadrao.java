package br.com.dao.dao_lib.tx;

import javax.enterprise.inject.Typed;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Typed(Transacao.class)
public class TransacaoPadrao implements Transacao {

	private static final long serialVersionUID = -412663389570479549L;
	protected EntityManager em;

	public Object executaComTransacao(InvocationContext context) {
		em.getTransaction().begin();

		try {
			Object resultado = context.proceed();
			em.getTransaction().commit();
			return resultado;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
}
