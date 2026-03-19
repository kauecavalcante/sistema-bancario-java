/**
 * Classe Gerente
 * Representa um gerente do banco
 * Herda de Funcionario e mantém a capacidade de autenticação
 * Demonstra herança aplicada a papéis organizacionais
 *
 * @author Kauê Cavalcante
 * @version 2.0
 */
public class Gerente extends Funcionario {
    // Atributos específicos do gerente
    private String departamento;
    private int numeroFuncionariosSupervisionados;

    /**
     * Construtor do Gerente
     * @param nome Nome do gerente
     * @param cpf CPF do gerente
     * @param senha Senha para autenticação
     * @param departamento Departamento que gerencia
     */
    public Gerente(String nome, String cpf, String senha, String departamento) {
        // Chama o construtor da classe pai (Funcionario)
        super(nome, cpf, senha, "Gerente");
        this.departamento = departamento;
        this.numeroFuncionariosSupervisionados = 0;
    }

    /**
     * Sobrescreve o método autenticar para adicionar comportamento específico do gerente
     * @param senha Senha a ser verificada
     * @return true se a senha estiver correta, false caso contrário
     */
    @Override
    public boolean autenticar(String senha) {
        boolean autenticado = super.autenticar(senha);
        if (autenticado) {
            System.out.println("Gerente do departamento " + departamento + " tem acesso total ao sistema.");
        }
        return autenticado;
    }

    /**
     * Aprova uma operação bancária (método específico do gerente)
     * @param descricao Descrição da operação
     * @return true se aprovado
     */
    public boolean aprovarOperacao(String descricao) {
        System.out.println("============================");
        System.out.println("APROVAÇÃO DE OPERAÇÃO");
        System.out.println("============================");
        System.out.println("Gerente: " + getNome());
        System.out.println("Operação: " + descricao);
        System.out.println("Status: APROVADA");
        System.out.println("============================");
        return true;
    }

    /**
     * Exibe relatório gerencial
     */
    public void exibirRelatorioGerencial() {
        System.out.println("============================");
        System.out.println("RELATÓRIO GERENCIAL");
        System.out.println("============================");
        System.out.println("Gerente: " + getNome());
        System.out.println("Departamento: " + departamento);
        System.out.println("Funcionários supervisionados: " + numeroFuncionariosSupervisionados);
        System.out.println("============================");
    }

    /**
     * Sobrescreve o método exibirInformacoes para incluir dados específicos do gerente
     */
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Departamento: " + departamento);
        System.out.println("Funcionários supervisionados: " + numeroFuncionariosSupervisionados);
        System.out.println("============================");
    }

    // Getters e Setters específicos do Gerente
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getNumeroFuncionariosSupervisionados() {
        return numeroFuncionariosSupervisionados;
    }

    public void setNumeroFuncionariosSupervisionados(int numeroFuncionariosSupervisionados) {
        this.numeroFuncionariosSupervisionados = numeroFuncionariosSupervisionados;
    }
}