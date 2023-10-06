import Controler.Tela;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela tTela = new Tela();
                tTela.setVisible(true); //define se a tela ficaria visivel ou nao
                tTela.createBufferStrategy(2);
                tTela.go();
            }
        });
    }
}