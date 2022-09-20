class Aluno extends Pessoa {
    private String turma;
    private String advertencia;

    public Aluno() {
        super();
    }

    public Aluno(String _cpf, String _nome) {
        super(_cpf, _nome);
    }

    public String getAdvertencia() {
        return advertencia;
    }

    public String getTurma() {
        return turma;
    }

    public void setAdvertencia(String advertencia) {
        this.advertencia = advertencia;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {    
        return super.toString() + "\n Turma = " +
        this.turma + "\n Adv = " + this.advertencia;
    }
}