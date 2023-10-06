package Modelo.Elementos.caveira;

import Auxiliar.Desenho;
import Modelo.Elementos.Personagem;

import java.io.Serializable;

public class Fogo extends Personagem implements Serializable{

    public Fogo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.causaDano = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
}