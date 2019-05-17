package br.com.philipe.seguranca;

public enum EProcessos {

	VAZIO(""),
	TESTE("001");
	
	public String value;

	private EProcessos(String value) {
		this.value = value;
	}
	
}
