import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * User: grinvon
 * Date: 10/05/2006
 * Time: 02:18:50
 *
 * @author Inocêncio
 */
@SuppressWarnings("serial")
public class TesteSwing extends JFrame {

    private JTextField text1 = new JTextField("BTN 1");
    private JTextField text2 = new JTextField("BTN 2");
    private JTextField text3 = new JTextField("BTN 3");

    private JButton btnOK = new JButton();

    public TesteSwing() {

        super("Janela Teste");

        btnOK.setAction(acaoBotao());

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(text1);
        getContentPane().add(text2);
        getContentPane().add(text3);
        getContentPane().add(btnOK);

        setSize(new Dimension(300,300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Action acaoBotao() {

        Action acao = new AbstractAction() {

            public void actionPerformed(ActionEvent event) {

                //limpa os campos

                for (int i=0; i < getContentPane().getComponentCount(); i++) {
                    //varre todos os componentes

                    Component c = getContentPane().getComponent(i);

                    if (c instanceof JTextField) {
                        //apaga os valores
                        JTextField field = (JTextField) c;
                        field.setText("");
                        System.out.println("apagando campo " + i);
                    }
                }
            }
        };

        acao.putValue(Action.NAME, "Limpa Campos");

        return acao;
    }



    public static void main(String[] args) {
        new TesteSwing();
    }
}