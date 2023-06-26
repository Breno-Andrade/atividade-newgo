package servico;

import dominio.Arquivo;
import dominio.Pasta;

public class CalculaTamanhoTotalDaPasta {

    public static double calcularTamanhoDaPasta(Pasta pasta){
        double tamanhoTotal = 0;

        for(Arquivo arquivo : pasta.getArquivos()){
            tamanhoTotal += arquivo.getTamanho();
        }

        if(VerificaSeExistemSubpastas.TemSubpastas(pasta)){
            for (Pasta subpasta : pasta.getSubpastas()){
                for(Arquivo arquivo : subpasta.getArquivos()){
                    tamanhoTotal += arquivo.getTamanho();
                }
            }
        }

        return tamanhoTotal;
    }
}
