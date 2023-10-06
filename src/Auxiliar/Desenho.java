package Auxiliar;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import Controler.Tela;

public class Desenho implements Serializable {
    static Tela jCenario;
    /*Seta o cenario, passando um objeto do tipo tela*/
    public static void setCenario(Tela umJCenario) {
        jCenario = umJCenario;
    }
    
    /*Retorna o objeto tela*/
    public static Tela acessoATelaDoJogo() {
        return jCenario;
    }
    
    /*Imprime a tela do jogo*/
    public static Graphics getGraphicsDaTela() {
        return jCenario.getGraphicsBuffer();
    }
    
    /*Desenha a imagem do elemento na posicao passada*/
    public static void desenhar(ImageIcon iImage, int iColuna, int iLinha) {
        iImage.paintIcon(jCenario,getGraphicsDaTela(),iColuna * Consts.CELL_SIDE, iLinha * Consts.CELL_SIDE);
    }
}