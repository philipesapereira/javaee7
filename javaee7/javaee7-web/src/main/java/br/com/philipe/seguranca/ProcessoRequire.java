package br.com.philipe.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@NameBinding
public @interface ProcessoRequire {
	public EProcessos value() default EProcessos.VAZIO;
}
