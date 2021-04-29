import java.util.Scanner;

public class AparelhoDeSom {

	private static Scanner teclado;
	private static final int minVol = 0, maxVol = 100;
	private int volume;
	
	public AparelhoDeSom() {
		teclado = new Scanner(System.in);
	}
	
	private void definirVolume() throws VolumeException{
		System.out.println("Digite o valor do volume: ");
		int volume = teclado.nextInt();
		
		if (volume < minVol || volume > maxVol)
			throw new VolumeException(volume);
			this.volume = volume;
	}
	
	public static void main(String[] args) throws VolumeException {
		AparelhoDeSom x = new AparelhoDeSom();
		x.definirVolume();
	}
}
