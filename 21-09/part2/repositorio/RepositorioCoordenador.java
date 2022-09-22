package part2.repositorio;

import java.util.ArrayList;
import java.util.List;

import part2.Coordenador;
import part2.ICoordenador;

public class RepositorioCoordenador implements ICoordenador {

    private List<Coordenador> coordenadores = new ArrayList<Coordenador>();

    @Override
    public boolean salvarCoordenador(Coordenador coordenador) {

        try {
            coordenadores.add(coordenador);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Coordenador> listarCoordenadores() {
        return this.coordenadores;
    }

    @Override
    public boolean deletarCoordenador(String cpf) {
        return coordenadores.removeIf(c -> c.getCpf().equals(cpf));
    }

    @Override
    public boolean alterarCoordenador(Coordenador coordenador, String cpf) {
        try {
            coordenadores.stream().filter(c -> c.getCpf().equals(cpf)).peek(d -> {
                d.setNome(coordenador.getNome());
                d.setLoja(coordenador.getLoja());
                d.setMetaDaLoja(coordenador.getMetaDaLoja());
                d.setSalarioLiquido(coordenador.getSalarioLiquido());
            }).findFirst();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean verificarDuplicidade(String cpf) {
        Coordenador coordenador = coordenadores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (coordenador == null)
            return false;
        else
            return true;
    }

}
