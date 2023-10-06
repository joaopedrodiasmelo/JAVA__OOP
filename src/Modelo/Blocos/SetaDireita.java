package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;
/**
 *
 * @author João Pedro e Rafaela
 */
public class SetaDireita extends Personagem {
    public SetaDireita(Posicao posicao) {
        super("setaDireita.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;       
        this.setaDireita = true;
        this.setaAux = true;
    }
}