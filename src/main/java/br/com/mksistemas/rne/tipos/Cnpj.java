package br.com.mksistemas.rne.tipos;

import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

public class Cnpj {

	private long cnpjValor;
	
    private final int Modulo11 = 11;
    private static final int[] MultiplicadorPrimeiroDigito = new int[] { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
    private static final int[] MultiplicadorUltimoDigito = new int[] { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	
	public Cnpj(long cnpjValor) {
		this.cnpjValor = cnpjValor;
	}
	
	public long getNumeroCnpj() {
		return cnpjValor;
	}
	
	public Boolean Validar() {
		return ValidarCnpj(cnpjValor);
	}
	
    private Boolean ValidarCnpj(long numeroCnpj)
    {
        if (CnpjMenorOuIgualQueZero(numeroCnpj))
            return false;
        
        String cnpj = StringUtils.leftPad(Long.toString(numeroCnpj), 14, "0");
        String cnpjCalculado = cnpj.substring(0, 12);
        
        cnpjCalculado += CalcularDigito(cnpjCalculado.toCharArray(), MultiplicadorPrimeiroDigito);
        cnpjCalculado += CalcularDigito(cnpjCalculado.toCharArray(), MultiplicadorUltimoDigito);
        return cnpj.equals(cnpjCalculado);
    }

    private Boolean CnpjMenorOuIgualQueZero(long valorCnpj)
    {
        return valorCnpj <= 0;
    }

    private int valorCalculado;
    
    private String CalcularDigito(char[] sequencia, int[] multiplicador)
    {
    	valorCalculado = 0;
        IntStream.range(0, sequencia.length)
        		.forEach(indice -> valorCalculado += (Integer.parseInt(String.valueOf(sequencia[indice])) * multiplicador[indice]));
        int resto = valorCalculado % Modulo11;
        return String.valueOf((resto < 2 ? 0 : 11 - resto));
    }

	@Override
	public String toString() {
		return String.valueOf(cnpjValor);
	}
    
	public static Cnpj criar(long cnpj) {
		return new Cnpj(cnpj);
	}
	
}
