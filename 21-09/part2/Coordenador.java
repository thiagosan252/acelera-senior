package part2;

public class Coordenador extends Funcionario {

    private String loja;
    private Double metaDaLoja;

    public Coordenador() {

    }

    public Coordenador(String nome, Double salarioLiquido, String cpf) {
        super(nome, salarioLiquido, cpf);
    }

    public String getLoja() {
        return loja;
    }

    public Double getMetaDaLoja() {
        return metaDaLoja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void setMetaDaLoja(Double metaDaLoja) {
        this.metaDaLoja = metaDaLoja;
    }

    @Override
    public void calculaSalario(Double horas) {
        Double salarioBruto = horas * 40;
        Double salarioLiquido = salarioBruto - (salarioBruto * (7 / 100));
        this.salarioLiquido = salarioLiquido;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLoja = " + this.loja +
                "\nMetaLoja = " + this.metaDaLoja;
    }
}
