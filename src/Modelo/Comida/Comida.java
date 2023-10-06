package Modelo.Comida;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;
/**
 *
 * @author João Pedro e Rafaela
 */
public class Comida extends Personagem {
    public Comida (String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = true;
        this.colecionavel = true;
    }
}