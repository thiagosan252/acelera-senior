import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Login login = new Login();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome de Usuario: ");
        login.setUsuario(scanner.next());
        System.out.println("Senha: ");
        login.setSenha(scanner.next());

        if (login.executaLogin(login.getUsuario(), login.getSenha())) {
            System.out.println("Login efetuado com sucesso.\n");

            int opt = cabecalho();

            switch (opt) {
                case 1:
                    Gerente gerente = new Gerente();
                    System.out.println("Nome: ");
                    gerente.setNome(scanner.next());

                    System.out.println("CPF: ");
                    gerente.setCpf(scanner.next());

                    System.out.println("Regional: ");
                    gerente.setRegional(scanner.next());

                    System.out.println("Meta Regional: ");
                    gerente.setMetaRegional(scanner.nextDouble());

                    System.out.println("Horas trabalhadas: ");
                    Double horasTrabG = scanner.nextDouble();

                    System.out.println("Salário Liq = R$ "
                            + new BigDecimal(gerente.calculaSalario(horasTrabG)).setScale(2, RoundingMode.HALF_EVEN));

                    break;

                case 2:
                    Coordenador coordenador = new Coordenador();
                    System.out.println("Nome: ");
                    coordenador.setNome(scanner.next());

                    System.out.println("CPF: ");
                    coordenador.setCpf(scanner.next());

                    System.out.println("Loja: ");
                    coordenador.setLoja(scanner.next());

                    System.out.println("Meta Da Loja: ");
                    coordenador.setMetaDaLoja(scanner.nextDouble());

                    System.out.println("Horas trabalhadas: ");
                    Double horasTrabC = scanner.nextDouble();

                    System.out.println("Salário Liq = R$ "
                            + new BigDecimal(coordenador.calculaSalario(horasTrabC)).setScale(2, RoundingMode.HALF_EVEN));
                default:
                    System.exit(0);
                    break;
            }

        } else {
            System.out.println("Login e/ou senha incorretos.");
        }
    }

    public static int cabecalho() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("#############");
        System.out.println("Para cadastrar um Gerente tecle 1");
        System.out.println("Para cadastrar um Coordenador tecle 2");
        System.out.println("Para sair, tecle 3");
        System.out.println("#############");
        int opt = scanner.nextInt();
        return opt;
    }
}
