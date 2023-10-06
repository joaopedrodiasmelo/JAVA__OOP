package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;
/**
 *
 * @author João Pedro e Rafaela
 */
public class SetaEsquerda extends Personagem {
    public SetaEsquerda(Posicao posicao) {
        super("setaEsquerda.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;        
        this.setaEsquerda = true;
        this.setaAux = true;
    }
}