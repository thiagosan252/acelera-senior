package part1;

import java.util.ArrayList;
import java.util.List;
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

            List<Coordenador> coordenadores = new ArrayList<Coordenador>();
            List<Gerente> gerentes = new ArrayList<Gerente>();

            boolean encerrar = false;
            while (!encerrar) {
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
                        gerente.calculaSalario(horasTrabG);

                        gerentes.add(gerente);
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

                        coordenador.calculaSalario(horasTrabC);
                        coordenadores.add(coordenador);
                    case 3:
                        if (gerentes.size() == 0 && coordenadores.size() == 0) {
                            System.out.println("Não há funcionários cadastrados no sistema.");
                        } else {
                            System.out.println("\n### Funcionários INICIO ###\n");
                            if (!gerentes.isEmpty()) {
                                System.out.println("Gerentes");
                                for (Gerente gerenteItem : gerentes) {
                                    System.out.println(gerenteItem.toString() + "\n");
                                }
                            }
                            if (!coordenadores.isEmpty()) {
                                System.out.println("Coordenadores");
                                for (Coordenador coordenadorItem : coordenadores) {
                                    System.out.println(coordenadorItem.toString() + "\n");
                                }
                            }

                            System.out.println("\n### Funcionários FIM ###\n");
                        }
                        break;
                    case 4:
                        encerrar = true;
                        break;
                    default:
                        System.out.println("\nOPCAO INCORRETA. TENTE NOVAMENTE\n");
                        break;
                }
            }
            System.exit(0);

        } else {
            System.out.println("Login e/ou senha incorretos.");
        }
    }

    public static int cabecalho() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("#############");
        System.out.println("Para cadastrar um novo Gerente pressione 1");
        System.out.println("Para cadastrar um novo Coordenador pressione 2");
        System.out.println("Para LISTAR os funcionários, pressione 3");
        System.out.println("Para sair, pressione 4");
        System.out.println("#############");
        int opt = scanner.nextInt();
        return opt;
    }
}
