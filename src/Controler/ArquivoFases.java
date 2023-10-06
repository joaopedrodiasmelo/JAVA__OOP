package Controler;

import Modelo.Elementos.Personagem;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArquivoFases {

    /*Salva a fase atual no arquivo quando se aperta a tecla S*/
    public void salvaFaseArquivo(ArrayList<Personagem> faseAtual) {
        try {

            File fTemp = new File("arquivosFases.dat");
            if (fTemp.exists()) {
                fTemp.createNewFile();
            }
            FileOutputStream canoOut = new FileOutputStream(fTemp);
            ObjectOutputStream serializador = new ObjectOutputStream(canoOut);

            serializador.writeObject(faseAtual);

            serializador.close();
            canoOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*Recarrega a fase salva no arquivo quando se aperta a tecla R*/
    public ArrayList<Personagem> faseArquivo() {
        try {
            FileInputStream canoIn = new FileInputStream("arquivosFases.dat");
            ObjectInputStream deserializador = new ObjectInputStream(canoIn);

            return (ArrayList<Personagem>) deserializador.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /*Salva qual o numero da fase que foi salva*/
    public void salvaNumeroDaFase(int numFase) {
        try {
            File fFases = new File("fases.dat");
            if (fFases.exists()) {
                fFases.createNewFile();
            }
            FileOutputStream canoOut = new FileOutputStream(fFases);
            canoOut.write(numFase);
            canoOut.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int retornaNumeroDaFase() {
        try {
            FileInputStream canoIN = new FileInputStream("fases.dat");
            return canoIN.read();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}