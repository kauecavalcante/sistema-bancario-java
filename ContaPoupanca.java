// Classe que representa uma Conta Poupança
// Ela herda (extends) da classe Conta
public class ContaPoupanca extends Conta {
    // Atributo específico da conta poupança
    private double taxaRendimento;

    // Construtor
    public ContaPoupanca(String numeroConta, String titular) {
        super(numeroConta, titular); // chama o construtor da classe pai (Conta)
        this.taxaRendimento = 0.05; // 5% de rendimento
    }

    // Método para aplicar rendimento no saldo
    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimento;
        saldo = saldo + rendimento;
        System.out.println("Rendimento aplicado: R$ " + rendimento);
        System.out.println("Novo saldo: R$ " + saldo);
    }

    // Sobrescreve o método da classe pai
    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}
