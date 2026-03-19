import java.util.Scanner;

// Classe principal do programa
public class Main {
    // Variáveis globais
    private static Banco banco;
    private static Scanner scanner;
    private static CalculadoraDeImposto calculadoraDeImposto;
    private static Gerente gerente;

    public static void main(String[] args) {
        // Inicializa o banco e o scanner
        banco = new Banco();
        scanner = new Scanner(System.in);
        calculadoraDeImposto = new CalculadoraDeImposto();

        // Cria um gerente padrão para demonstração
        gerente = new Gerente("João Silva", "123.456.789-00", "senha123", "Operações");

        // Loop principal do menu
        while (true) {
            mostrarMenu();
            int opcao = lerOpcao();

            if (opcao == 0) {
                System.out.println("Encerrando o sistema... Até logo!");
                break;
            }

            executarOpcao(opcao);
        }

        scanner.close();
    }

    // Método para mostrar o menu principal
    private static void mostrarMenu() {
        System.out.println("\n===== BANCO JAVA - VERSÃO 2.0 =====");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Listar contas");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transferir");
        System.out.println("6 - Consultar saldo");
        System.out.println("7 - Calcular tributos");
        System.out.println("8 - Autenticar gerente");
        System.out.println("0 - Sair");
        System.out.println("====================================");
        System.out.print("Escolha uma opção: ");
    }

    // Método para ler a opção do usuário
    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // limpa o buffer
            return -1;
        }
    }

    // Método para executar a opção escolhida
    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                criarConta();
                break;
            case 2:
                listarContas();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                transferir();
                break;
            case 6:
                consultarSaldo();
                break;
            case 7:
                calcularTributos();
                break;
            case 8:
                autenticarGerente();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Método para criar uma nova conta
    private static void criarConta() {
        System.out.println("\n----- CRIAR CONTA -----");
        System.out.println("Tipo de conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupança");
        System.out.print("Escolha o tipo: ");

        int tipo = lerOpcao();
        scanner.nextLine(); // limpa o buffer

        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        if (tipo == 1) {
            banco.criarContaCorrente(titular);
        } else if (tipo == 2) {
            banco.criarContaPoupanca(titular);
        } else {
            System.out.println("Tipo de conta inválido!");
        }
    }

    // Método para listar todas as contas
    private static void listarContas() {
        banco.listarContas();
    }

    // Método para realizar depósito
    private static void depositar() {
        if (!banco.temContas()) {
            System.out.println("Nenhuma conta cadastrada. Crie uma conta primeiro!");
            return;
        }

        System.out.println("\n----- DEPOSITAR -----");
        scanner.nextLine(); // limpa o buffer
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        Conta conta = banco.buscarConta(numeroConta);

        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.print("Digite o valor do depósito: R$ ");
        double valor = scanner.nextDouble();

        conta.depositar(valor);
    }

    // Método para realizar saque
    private static void sacar() {
        if (!banco.temContas()) {
            System.out.println("Nenhuma conta cadastrada. Crie uma conta primeiro!");
            return;
        }

        System.out.println("\n----- SACAR -----");
        scanner.nextLine(); // limpa o buffer
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        Conta conta = banco.buscarConta(numeroConta);

        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.print("Digite o valor do saque: R$ ");
        double valor = scanner.nextDouble();

        conta.sacar(valor);
    }

    // Método para realizar transferência
    private static void transferir() {
        if (!banco.temContas()) {
            System.out.println("Nenhuma conta cadastrada. Crie uma conta primeiro!");
            return;
        }

        System.out.println("\n----- TRANSFERIR -----");
        scanner.nextLine(); // limpa o buffer

        System.out.print("Digite o número da conta de origem: ");
        String numeroContaOrigem = scanner.nextLine();

        Conta contaOrigem = banco.buscarConta(numeroContaOrigem);

        if (contaOrigem == null) {
            System.out.println("Conta de origem não encontrada!");
            return;
        }

        System.out.print("Digite o número da conta de destino: ");
        String numeroContaDestino = scanner.nextLine();

        Conta contaDestino = banco.buscarConta(numeroContaDestino);

        if (contaDestino == null) {
            System.out.println("Conta de destino não encontrada!");
            return;
        }

        System.out.print("Digite o valor da transferência: R$ ");
        double valor = scanner.nextDouble();

        contaOrigem.transferir(contaDestino, valor);
    }

    // Método para consultar saldo
    private static void consultarSaldo() {
        if (!banco.temContas()) {
            System.out.println("Nenhuma conta cadastrada. Crie uma conta primeiro!");
            return;
        }

        System.out.println("\n----- CONSULTAR SALDO -----");
        scanner.nextLine(); // limpa o buffer
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        Conta conta = banco.buscarConta(numeroConta);

        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        conta.consultarSaldo();
    }

    // Método para calcular tributos das contas correntes
    private static void calcularTributos() {
        System.out.println("\n----- CALCULAR TRIBUTOS -----");

        if (!banco.temContas()) {
            System.out.println("Nenhuma conta cadastrada. Crie uma conta primeiro!");
            return;
        }

        // Zera o contador de tributos para um novo cálculo
        calculadoraDeImposto.zerarTributos();

        int contasCorrente = 0;

        // Percorre todas as contas e calcula tributos apenas das contas correntes
        for (Conta conta : banco.getContas()) {
            if (conta instanceof ContaCorrente) {
                ContaCorrente cc = (ContaCorrente) conta;
                System.out.println("\n----- Calculando tributo -----");
                System.out.println("Conta: " + cc.getNumeroConta() +
                                 " - Titular: " + cc.getTitular());
                System.out.println("Saldo: R$ " + String.format("%.2f", cc.getSaldo()));

                // Registra o tributo na calculadora
                calculadoraDeImposto.registrar(cc);
                contasCorrente++;
            }
        }

        if (contasCorrente == 0) {
            System.out.println("Nenhuma conta corrente cadastrada para calcular tributos.");
        } else {
            // Exibe o relatório final
            calculadoraDeImposto.exibirRelatorio();
        }
    }

    // Método para autenticar o gerente
    private static void autenticarGerente() {
        System.out.println("\n----- AUTENTICAÇÃO DE GERENTE -----");
        scanner.nextLine(); // limpa o buffer

        // Exibe informações do gerente
        System.out.println("Gerente: " + gerente.getNome());
        System.out.println("Departamento: " + gerente.getDepartamento());

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        boolean autenticado = gerente.autenticar(senha);

        if (autenticado) {
            System.out.println("\n----- MENU DO GERENTE -----");
            System.out.println("1 - Exibir informações do gerente");
            System.out.println("2 - Exibir relatório gerencial");
            System.out.println("3 - Aprovar operação");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    gerente.exibirInformacoes();
                    break;
                case 2:
                    gerente.exibirRelatorioGerencial();
                    break;
                case 3:
                    scanner.nextLine(); // limpa o buffer
                    System.out.print("Descreva a operação a aprovar: ");
                    String operacao = scanner.nextLine();
                    gerente.aprovarOperacao(operacao);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("Senha incorreta! Acesso negado.");
        }
    }
}
