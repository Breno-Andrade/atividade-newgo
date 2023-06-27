package dominio;

import java.util.Objects;

public class Arquivo {
    private String nome;
    private String tipo;
    private double tamanho;

    public Arquivo(String nome, String tipo, double tamanho) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        if (tamanho <= 0){
            throw new IllegalArgumentException("O tamanho do arquivo não pode ser negativo");
        }
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Arquivo: '" + nome + "', " +
                "Tipo: '" + tipo + "', " +
                "Tamanho: '" + tamanho + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arquivo arquivo = (Arquivo) o;
        return nome.equals(arquivo.nome) && tipo.equals(arquivo.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo);
    }
}
