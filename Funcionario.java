/**
 * Classe Funcionario
 * Representa funcionários do banco
 * Implementa a interface Autenticavel para permitir autenticação
 *
 * @author Kauê Cavalcante
 * @version 2.0
 */
public class Funcionario implements Autenticavel {
    // Atributos do funcionário
    private String nome;
    private String cpf;
    private String senha;
    private String cargo;

    /**
     * Construtor do Funcionario
     * @param nome Nome do funcionário
     * @param cpf CPF do funcionário
     * @param senha Senha para autenticação
     * @param cargo Cargo do funcionário
     */
    public Funcionario(String nome, String cpf, String senha, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
    }

    /**
     * Implementação do método autenticar da interface Autenticavel
     * @param senha Senha a ser verificada
     * @return true se a senha estiver correta, false caso contrário
     */
    @Override
    public boolean autenticar(String senha) {
        if (this.senha.equals(senha)) {
            System.out.println("Funcionário " + nome + " autenticado com sucesso!");
            return true;
        } else {
            System.out.println("Falha na autenticação do funcionário " + nome);
            return false;
        }
    }

    /**
     * Exibe informações do funcionário
     */
    public void exibirInformacoes() {
        System.out.println("============================");
        System.out.println("INFORMAÇÕES DO FUNCIONÁRIO");
        System.out.println("============================");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Cargo: " + cargo);
        System.out.println("============================");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}