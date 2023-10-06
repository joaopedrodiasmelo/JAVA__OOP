package Modelo.Elementos;

import Auxiliar.Desenho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author João Pedro e Rafaela
 */
public class Monstrinhos extends Personagem implements Serializable {

    Random aux = new Random();

    public Monstrinhos(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.causaDano = true;
    }

    @Override
    public void autoDesenhoMonstro(ArrayList<Personagem> umaFase, int linha, int coluna) {
        int direcao = aux.nextInt(4);

        switch (direcao) {
            case 0:
                this.moveUp();
                break;
            case 1:
                this.moveDown();
                break;
            case 2:
                this.moveRight();
                break;
            case 3:
                this.moveLeft();
                break;
        }
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValidaPersonagem(this))
            this.getPosicao().volta();

        super.autoDesenhoMonstro(umaFase, linha, coluna);
    }
}