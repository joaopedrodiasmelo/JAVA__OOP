package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;
/**
 *
 * @author João Pedro e Rafaela
 */
public class Verde extends Personagem {
    public Verde(Posicao posicao) {
        super("verde.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;
        this.quebravel = true;
    }
}

