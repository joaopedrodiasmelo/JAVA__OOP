package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;
/**
 *
 * @author João Pedro e Rafaela
 */
public class Vermelho extends Personagem {
    public Vermelho(Posicao posicao) {
        super("vermelho.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;
    }
}