public class Funcionario {
    protected String nome;
    protected Double salarioLiquido;
    protected String cpf;

    public Funcionario() {

    }

    public Funcionario(String nome, Double salarioLiquido, String cpf) {
        this.nome = nome;
        this.salarioLiquido = salarioLiquido;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public Double calculaSalario(Double horas) {
        return this.salarioLiquido;
    }
}