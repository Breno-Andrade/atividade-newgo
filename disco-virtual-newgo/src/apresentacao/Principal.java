package apresentacao;

import dominio.Arquivo;
import dominio.Pasta;
import servico.CalculaTamanhoTotalDaPasta;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Arquivo arquivo01 = new Arquivo("Arquivo de Teste", "txt", 10);
        Arquivo arquivo02 = new Arquivo("Arquivo de Teste02", "txt", 5);
        Arquivo arquivo03 = new Arquivo("Fotografia", "png", 500.55);


        Pasta subpasta = new Pasta("Arquivos importantes");
        subpasta.inserirArquivo(arquivo01);
        subpasta.inserirArquivo(arquivo02);

        Pasta pasta = new Pasta("Pasta Raiz",  subpasta);
        pasta.inserirArquivo(arquivo03);

        System.out.println(pasta.toString());
        System.out.println(CalculaTamanhoTotalDaPasta.calcularTamanhoDaPasta(pasta));
    }
}
