import javax.swing.JOptionPane; 

public class TesteJOptionPane { 
    public static void main(String[] args){ 
        /* Solicita que o usu�rio forne�a um texto */
        String texto = JOptionPane.showInputDialog("digite um texto."); 

	// Exibe o texto que o usu�rio forneceu
        JOptionPane.showMessageDialog(null, "Voc� digitou: " + texto);
    }
}
