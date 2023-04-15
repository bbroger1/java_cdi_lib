package br.com.rcssoft.rcssoft_lib.tx;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.rcssoft.rcssoft_lib.tx.annotation.Transacional;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class GerenciadorDeTransacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	@Inject
	public GerenciadorDeTransacao(EntityManager em) {
		this.em = em;
	}
	
	@AroundInvoke	
	public Object executaTransacao(InvocationContext context) {
		// abre transacao
		em.getTransaction().begin();
		
		try {
			Object resultado = context.proceed();
			// commita a transacao
			em.getTransaction().commit();
			
			return resultado;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}

		
	}
}
