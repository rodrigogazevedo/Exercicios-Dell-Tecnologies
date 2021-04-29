import javax.swing.JOptionPane; 

public class TesteJOptionPane { 
    public static void main(String[] args){ 
        /* Solicita que o usuário forneça um texto */
        String texto = JOptionPane.showInputDialog("digite um texto."); 

	// Exibe o texto que o usuário forneceu
        JOptionPane.showMessageDialog(null, "Você digitou: " + texto);
    }
}
