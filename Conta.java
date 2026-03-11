// Classe base para todas as contas
public class Conta {
    // Atributos (variáveis) da conta
    private String numeroConta;
    private String titular;
    protected double saldo;

    // Construtor - cria uma nova conta
    public Conta(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // Método para sacar dinheiro
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + saldo);
            return true;
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return false;
        } else {
            System.out.println("Valor inválido para saque.");
            return false;
        }
    }

    // Método para transferir dinheiro para outra conta
    public boolean transferir(Conta contaDestino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
            return true;
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência!");
            return false;
        } else {
            System.out.println("Valor inválido para transferência.");
            return false;
        }
    }

    // Método para consultar saldo
    public void consultarSaldo() {
        System.out.println("===== EXTRATO =====");
        System.out.println("Conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("===================");
    }

    // Getters - métodos para pegar os valores
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para exibir tipo da conta (será sobrescrito nas classes filhas)
    public String getTipoConta() {
        return "Conta Genérica";
    }
}
