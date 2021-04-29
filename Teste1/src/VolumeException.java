
public class VolumeException extends Exception{

	private int valor;

	public VolumeException(int valor) {
		this.valor = valor;
	}
	
	public String getMessage() {
		return "O valor "+ valor + " n�o est� dentro do limite aceit�vel";
	}
}
