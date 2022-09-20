class Pessoa {

    private String cpf;
    private String nome;

    public Pessoa() {

    }

    public Pessoa(String _cpf, String _nome) {
        this.cpf = _cpf;
        this.nome = _nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return " CPF = " + this.cpf + "\n Nome = " + this.nome;
    }

}