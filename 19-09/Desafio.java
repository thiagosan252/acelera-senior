public class Desafio {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("123.123.123.12", "Thiago");
        aluno.setTurma("T01");
        aluno.setAdvertencia("N/A");
        System.out.println("##### ALUNO #####\n");
        System.out.println(aluno.toString());

        Professor prof = new Professor();
        prof.setCpf("456.456.456.45");
        prof.setNome("Luciano Impacta");
        prof.setDisciplina("Java");
        prof.setSalario("R$ 10.000,00");
        System.out.println("\n##### PROFESSOR #####\n");
        System.out.println(prof.toString());
    }
}
