package servico;

import dominio.Pasta;

public class VerificaSeExistemSubpastas {
    public static boolean TemSubpastas(Pasta pasta){
        return !(pasta.getSubpastas().isEmpty());
    }
}
