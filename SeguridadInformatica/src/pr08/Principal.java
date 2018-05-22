package pr08;

import java.math.BigInteger;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
	Principal obj = new Principal();
	System.out.println("primero:  " + obj.euclidesExtendido(new BigInteger("893871739"), new BigInteger("352330386042153172059999060")));
	//System.out.println("segundo:  " + obj.potenciacionModular(new BigInteger("893871739"), new BigInteger("893871739"), new BigInteger("893871739")));
	
	}
	
	
	public BigInteger potenciacionModular(BigInteger num, BigInteger exponente, BigInteger modulo) {
		ArrayList<BigInteger> a = new ArrayList<BigInteger>();
		ArrayList<BigInteger> b = new ArrayList<BigInteger>();
		ArrayList<BigInteger> m = new ArrayList<BigInteger>();		
		a.add(num);
		m.add(new BigInteger("0"));
		String binario = exponente.toString(2);
		System.out.println("binario; " + binario);
		for(int i = binario.length(); i>0; i--){
			b.add(new BigInteger(String.valueOf(binario.charAt(i))));
		}
		for(int indice = 1; indice<b.size(); indice++) {
			a.add((a.get(indice-1).pow(2)).mod(modulo));
			m.add( (b.get(indice-1)== new BigInteger("0") ? m.get(indice-1) : (a.get(indice-1).multiply(m.get(indice-1)).mod(modulo))));
		}
		
		return m.get(b.size());
	}
	
	public BigInteger euclidesExtendido(BigInteger num, BigInteger modulo) {
		ArrayList<BigInteger> mu = new ArrayList<BigInteger>();
		ArrayList<BigInteger> restos = new ArrayList<BigInteger>();
		ArrayList<BigInteger> cocientes = new ArrayList<BigInteger>();
		int indice = 1;
		mu.add(new BigInteger("0"));mu.add(new BigInteger("1"));
		cocientes.add(new BigInteger("0"));cocientes.add(new BigInteger("0"));
		restos.add(modulo);restos.add(num);
		while (restos.get(indice) != new BigInteger("1")) {
			indice++;
			BigInteger cociente = restos.get(indice-2).divide(restos.get(indice-1));
			BigInteger resto = restos.get(indice-2).mod(restos.get(indice-1));
			restos.add(resto);
			cocientes.add(cociente);
			mu.add(mu.get(indice-2).subtract(cocientes.get(indice).multiply(mu.get(indice-1))));
		}

		return mu.get(indice);
	}

	public BigInteger[] expresionBase(BigInteger expresion, BigInteger base) {
		
		
		
		
		return null;
	}

}

