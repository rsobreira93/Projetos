/**
 * Essa clsse tem como objetivo criar um cliente e gerencia dentro da aplicação.*/

import java.util.Date;
public class Cliente_AnaMary {
	
	private String nome;
	private Date dataNasc;
	private String telefone;
	private String endereco;
	private String email;
	private String obs;
	private int cpf;
	private int codCliente;
	
	
	public int getcodCliente() {
		return codCliente;
	}
	public void stecodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getObs() {
		return obs;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	private void criarCliente(String obs, String nome, Date dataNasc, String telefone, String endereco, 
			String email, int cod_Cliente, int cpf) {
		this.obs = obs;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.codCliente = cod_Cliente;
		this.cpf = cpf;
	}
	
	private void excluirCliente(int codCliente) {
		
	}
	
	private void consultarCliente() {
		
	}
	
	private void atualizarCliente(String telefone, String email, String endereco, String obs) {
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.obs = obs;
	}
	
	private void acompanhamentoDoCliente() {
		
	}
}
