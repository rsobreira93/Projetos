package Modelo;

/**
 *Classe responsavel por criar uma usuario
 * @author Romulo Sobreira
 */
public class ModeloUsuario {

  private long cod;
  private String nome;
  private String cpf;
  private String telefone;
  private String email;
  private String endereco;
  private String n;
  private String cidade;
  private String bairro;
  private String complemento;
  private String dNascimento;
  private String obs;

    public String getdNascimento() {
        return this.dNascimento;
    }
    public void setdNascimento(String dNascimento) {
        this.dNascimento = dNascimento;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
  
  
    /**
     * @return the cod
     */
    public long getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(long cod) {
        this.cod = cod;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the n
     */
    public String getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(String n) {
        this.n = n;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }   

    @Override
    public String toString() {
        return getNome();
    }
    
}
