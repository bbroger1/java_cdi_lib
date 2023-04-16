package br.com.rcssoft.rcssoft_lib.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.rcssoft.rcssoft_lib.tx.annotation.Transacional;

@Interceptor
@Transacional
public class GerenciadorDeTransacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Transacionado transacionado;
	
	@Inject
	public GerenciadorDeTransacao(Transacionado transacionado) {
		this.transacionado = transacionado;
	}
	
	@AroundInvoke	
	public Object interceptar(InvocationContext context) {
		
		return transacionado.executaTransacao(context);
		
	}
}
