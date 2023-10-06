package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;

/**
 * @author João Pedro e Rafaela
 */
public class SetaCima extends Personagem {
    public SetaCima(Posicao posicao) {
        super("setaCima.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;
        this.setaCima = true;
        this.setaAux = true;
    }
}