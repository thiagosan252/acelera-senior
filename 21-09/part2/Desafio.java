package part2;

import java.util.List;
import java.util.Scanner;

import part2.repositorio.RepositorioCoordenador;
import part2.repositorio.RepositorioGerente;

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

            RepositorioGerente repositorioGerente = new RepositorioGerente();
            RepositorioCoordenador repositorioCoordenador = new RepositorioCoordenador();

            boolean encerrar = false;
            while (!encerrar) {
                int opt = menu();

                switch (opt) {
                    case 1:
                        Gerente gerente = new Gerente();
                        System.out.println("Nome: ");
                        gerente.setNome(scanner.next());

                        System.out.println("CPF: ");
                        String cpfGerente = scanner.next();
                        while (repositorioGerente.verificarDuplicidade(cpfGerente) == Boolean.TRUE) {
                            System.out.println("CPF já existe, insira outro: ");
                            cpfGerente = scanner.next();
                        }
                        gerente.setCpf(cpfGerente);

                        System.out.println("Regional: ");
                        gerente.setRegional(scanner.next());

                        System.out.println("Meta Regional: ");
                        gerente.setMetaRegional(scanner.nextDouble());

                        System.out.println("Horas trabalhadas: ");
                        gerente.calculaSalario(scanner.nextDouble());

                        if (repositorioGerente.salvarGerente(gerente)) {
                            System.out.println("Cadastrado com sucesso.");
                        } else {
                            System.out.println("Falha ao cadastrar.");
                        }
                        break;

                    case 2:
                        Coordenador coordenador = new Coordenador();
                        System.out.println("Nome: ");
                        coordenador.setNome(scanner.next());

                        System.out.println("CPF: ");
                        String cpfCoordenador = scanner.next();
                        while (repositorioCoordenador.verificarDuplicidade(cpfCoordenador) == Boolean.TRUE) {
                            System.out.println("CPF já existe, insira outro: ");
                            cpfCoordenador = scanner.next();
                        }
                        coordenador.setCpf(cpfCoordenador);

                        System.out.println("Loja: ");
                        coordenador.setLoja(scanner.next());

                        System.out.println("Meta Da Loja: ");
                        coordenador.setMetaDaLoja(scanner.nextDouble());

                        System.out.println("Horas trabalhadas: ");
                        coordenador.calculaSalario(scanner.nextDouble());
                        if (repositorioCoordenador.salvarCoordenador(coordenador)) {
                            System.out.println("Cadastrado com sucesso.");
                        } else {
                            System.out.println("Falha ao cadastrar.");
                        }
                    case 3:
                        System.out.println("Insira o CPF que deseja deletar:");
                        String cpfGerenteDeletar = scanner.next();
                        if (repositorioGerente.deletarGerente(cpfGerenteDeletar)) {
                            System.out.println("Gerente deletado com sucesso");
                        } else {
                            System.out.println("Gerente nao encontrado");
                        }
                        break;
                    case 4:
                        System.out.println("Insira o CPF que deseja deletar:");
                        String cpfCoordenadorDeletar = scanner.next();
                        if (repositorioCoordenador.deletarCoordenador(cpfCoordenadorDeletar)) {
                            System.out.println("Coordenador deletado com sucesso");
                        } else {
                            System.out.println("Coordenador nao encontrado");
                        }
                        break;
                    case 5:

                        System.out.println("Insira o CPF que deseja alterar:");
                        String cpfGerenteAlterar = scanner.next();

                        while (repositorioGerente.verificarDuplicidade(cpfGerenteAlterar) == Boolean.FALSE) {
                            System.out.println("CPF não encontrado, insira outro: ");
                            cpfGerenteAlterar = scanner.next();
                        }

                        Gerente ger = new Gerente();
                        ger.setCpf(cpfGerenteAlterar);

                        System.out.println("Nome: ");
                        ger.setNome(scanner.next());

                        System.out.println("Regional: ");
                        ger.setRegional(scanner.next());

                        System.out.println("Meta Regional: ");
                        ger.setMetaRegional(scanner.nextDouble());

                        System.out.println("Horas trabalhadas: ");
                        ger.calculaSalario(scanner.nextDouble());

                        if (repositorioGerente.alterarGerente(ger, cpfGerenteAlterar)) {
                            System.out.println("Gerente alterado com sucesso");
                        } else {
                            System.out.println("Gerente nao atualizado");
                        }

                        break;
                    case 6:
                        System.out.println("Insira o CPF que deseja alterar:");
                        String cpfCoordenadorAlterar = scanner.next();

                        while (repositorioCoordenador.verificarDuplicidade(cpfCoordenadorAlterar) == Boolean.FALSE) {
                            System.out.println("CPF não encontrado, insira outro: ");
                            cpfCoordenadorAlterar = scanner.next();
                        }

                        Coordenador coord = new Coordenador();
                        coord.setCpf(cpfCoordenadorAlterar);

                        System.out.println("Nome: ");
                        coord.setNome(scanner.next());

                        System.out.println("Loja: ");
                        coord.setLoja(scanner.next());

                        System.out.println("Meta Da Loja: ");
                        coord.setMetaDaLoja(scanner.nextDouble());

                        System.out.println("Horas trabalhadas: ");
                        coord.calculaSalario(scanner.nextDouble());

                        if (repositorioCoordenador.alterarCoordenador(coord, cpfCoordenadorAlterar)) {
                            System.out.println("Coordenador alterado com sucesso");
                        } else {
                            System.out.println("Coordenador nao atualizado");
                        }
                        break;
                    case 7:
                        List<Gerente> gerentes = repositorioGerente.listarGerentes();
                        List<Coordenador> coordenadores = repositorioCoordenador.listarCoordenadores();

                        if (gerentes.size() == 0 && coordenadores.size() == 0) {
                            System.out.println("\nNão há funcionários cadastrados no sistema.\n");
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
                    case 0:
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

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("#############");
        System.out.println("Para cadastrar um novo Gerente pressione 1");
        System.out.println("Para cadastrar um novo Coordenador pressione 2");

        System.out.println("Para deletar Gerente pressione 3");
        System.out.println("Para deletar Coordenador pressione 4");

        System.out.println("Para alterar o Gerente pressione 5");
        System.out.println("Para alterar o Coordenador pressione 6");

        System.out.println("Para LISTAR os funcionários, pressione 7");
        System.out.println("Para sair, pressione 0");
        System.out.println("#############");
        int opt = scanner.nextInt();
        return opt;
    }
}
