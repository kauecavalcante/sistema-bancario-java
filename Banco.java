import java.util.ArrayList;

// Classe que gerencia todas as contas do banco
public class Banco {
    // Lista para armazenar todas as contas
    private ArrayList<Conta> contas;
    private int proximoNumeroConta;

    // Construtor
    public Banco() {
        contas = new ArrayList<Conta>();
        proximoNumeroConta = 1001; // começa do número 1001
    }

    // Método para criar uma nova conta corrente
    public void criarContaCorrente(String titular) {
        String numeroConta = String.valueOf(proximoNumeroConta);
        ContaCorrente novaConta = new ContaCorrente(numeroConta, titular);
        contas.add(novaConta);
        proximoNumeroConta++;
        System.out.println("Conta Corrente criada com sucesso!");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Titular: " + titular);
    }

    // Método para criar uma nova conta poupança
    public void criarContaPoupanca(String titular) {
        String numeroConta = String.valueOf(proximoNumeroConta);
        ContaPoupanca novaConta = new ContaPoupanca(numeroConta, titular);
        contas.add(novaConta);
        proximoNumeroConta++;
        System.out.println("Conta Poupança criada com sucesso!");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Titular: " + titular);
    }

    // Método para listar todas as contas
    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n===== LISTA DE CONTAS =====");
        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);
            System.out.println((i + 1) + " - Conta: " + conta.getNumeroConta() +
                             " | Titular: " + conta.getTitular() +
                             " | Tipo: " + conta.getTipoConta() +
                             " | Saldo: R$ " + conta.getSaldo());
        }
        System.out.println("===========================\n");
    }

    // Método para buscar uma conta pelo número
    public Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    // Método para verificar se existem contas cadastradas
    public boolean temContas() {
        return !contas.isEmpty();
    }

    // Método para pegar todas as contas
    public ArrayList<Conta> getContas() {
        return contas;
    }
}
