package br.com.dao.dao_lib.tx;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.dao.dao_lib.tx.annotation.Transacional;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class GerenciadorTransacao implements Serializable{
		
	private static final long serialVersionUID = -9020375715391045839L;
	private Transacao transacao;
	

	@Inject
	public GerenciadorTransacao(Transacao transacao){
		this.transacao = transacao;
		
	}
	
	@AroundInvoke
	public Object interceptar(InvocationContext context){
		return transacao.executaComTransacao(context);		
	}

}
