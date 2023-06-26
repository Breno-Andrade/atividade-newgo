package dominio;

import java.util.ArrayList;

public class Pasta {
    private String nome;
    private ArrayList<Pasta> subpastas = new ArrayList<>();
    private ArrayList<Arquivo> arquivos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public Pasta(String nome, Pasta subpasta){
        this(nome);
        this.subpastas.add(subpasta);
    }

    public Pasta(String nome, Arquivo arquivo){
        this(nome);
        this.inserirArquivo(arquivo);
    }

    public Pasta(String nome, Pasta subpasta, Arquivo arquivo){
        this(nome, subpasta);
        this.arquivos.add(arquivo);
    }

    public Pasta(String nome, ArrayList<Pasta> subpastas, ArrayList<Arquivo> arquivos) {
        this(nome);
        this.subpastas =  subpastas;
        this.arquivos  = arquivos;
    }

    public String getNome() {
        return nome;
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Pasta> getSubpastas() {
        return subpastas;
    }

    public void setSubpastas(ArrayList<Pasta> subpastas) {
        this.subpastas = subpastas;
    }

    public void inserirSubpasta(Pasta subpasta){
        if (subpastas.contains(subpasta)){
            throw new RuntimeException("Essa subpasta já existe!");
        }
        this.subpastas.add(subpasta);
    }

    public void excluirSubpasta(Pasta subpasta){
        if (!(subpastas.contains(subpasta))){
            throw new RuntimeException("Essa subpasta não existe!");
        }
        this.subpastas.remove(subpasta);
    }

    public ArrayList<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(ArrayList<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public void inserirArquivo (Arquivo arquivo){
        if (arquivos.contains(arquivo)){
            throw new RuntimeException("Esse arquivo já existe!");
        }
        this.arquivos.add(arquivo);
    }

    public void deletarArquivo (Arquivo arquivo){
        if (!(arquivos.contains(arquivo))){
            throw new RuntimeException("Esse arquivo não existe!");
        }
        this.arquivos.remove(arquivo);
    }

    @Override
    public String toString() {
        return  "\n" + nome + "{ " +
                arquivos.toString() + "\n" +
                subpastas.toString() + "\n" +
                '}';
    }
}
