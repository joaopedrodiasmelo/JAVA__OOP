package Modelo.Elementos;

import Auxiliar.Desenho;
import java.io.Serializable;

public class Skoot extends Personagem implements Serializable {

    private int acumuladoSkoot;

    public Skoot(String sNomeImagePNG) {
        super("skoot.png");
        this.vidas = 3;
        this.acumuladoSkoot = 0;
        this.bMortal = true;
        this.bTransponivel = false;
    }
        
    public int getAcumuladoSkoot() {
        return this.acumuladoSkoot;
    }

    public void voltaAUltimaPosicao() {
        this.pPosicao.volta();
    }

    public boolean setPosicao(int linha, int coluna) {
        if (this.pPosicao.setPosicao(linha, coluna)) {
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;
    }

    private boolean validaPosicao() {
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;
    }

    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

}
