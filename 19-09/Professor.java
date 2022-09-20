class Professor extends Pessoa {
    private String disciplina;
    private String salario;

    public Professor() {
        super();
    }
    
    public Professor(String _cpf, String _nome) {
        super(_cpf, _nome);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getSalario() {
        return salario;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {    
        return super.toString() + "\n Disciplina = " +
        this.disciplina + "\n Salário = " + this.salario;
    }
}