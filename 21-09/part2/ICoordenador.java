package part2;

import java.util.List;

public interface ICoordenador {
    
    public boolean salvarCoordenador(Coordenador coordenador);
    public List<Coordenador> listarCoordenadores();
    public boolean deletarCoordenador(String cpf);
    public boolean alterarCoordenador(Coordenador coordenador, String cpf);
    public boolean verificarDuplicidade(String cpf);

}
