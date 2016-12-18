package br.com.dao.dao_lib.tx;

import java.io.Serializable;

import javax.interceptor.InvocationContext;

public interface Transacao extends Serializable{
	
	Object executaComTransacao(InvocationContext context);

}
