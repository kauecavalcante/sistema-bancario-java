import java.util.Scanner;

// Classe principal do programa
public class Main {
    // Variáveis globais
    private static Banco banco;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Inicializa o banco e o scanner
        banco = new Banco();
        scanner = new Scanner(System.in);

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
        System.out.println("\n===== BANCO JAVA =====");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Listar contas");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transferir");
        System.out.println("6 - Consultar saldo");
        System.out.println("0 - Sair");
        System.out.println("======================");
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
}
