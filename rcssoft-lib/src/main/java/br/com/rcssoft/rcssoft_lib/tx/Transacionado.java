package br.com.rcssoft.rcssoft_lib.tx;

import java.io.Serializable;

import javax.interceptor.InvocationContext;

public interface Transacionado extends Serializable {
	Object executaTransacao(InvocationContext context);
}
