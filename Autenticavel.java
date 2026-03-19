/**
 * Interface Autenticavel
 * Representa entidades que podem realizar autenticação no sistema
 *
 * @author Kauê Cavalcante
 * @version 2.0
 */
public interface Autenticavel {
    /**
     * Autentica um usuário com base em uma senha
     * @param senha A senha a ser verificada
     * @return true se a autenticação for bem-sucedida, false caso contrário
     */
    boolean autenticar(String senha);
}