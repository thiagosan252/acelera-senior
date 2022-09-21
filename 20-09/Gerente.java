public class Gerente extends Funcionario {

    private String regional;
    private Double metaRegional;

    public Gerente() {

    }

    public Gerente(String nome, Double salarioLiquido, String cpf) {
        super(nome, salarioLiquido, cpf);
    }

    public Double getMetaRegional() {
        return metaRegional;
    }

    public String getRegional() {
        return regional;
    }

    public void setMetaRegional(Double metaRegional) {
        this.metaRegional = metaRegional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    @Override
    public Double calculaSalario(Double horas) {
        Double salarioBruto = horas * 60;
        Double salarioLiquido = salarioBruto - (salarioBruto * (15 / 100));
        return salarioLiquido;
    }
}
