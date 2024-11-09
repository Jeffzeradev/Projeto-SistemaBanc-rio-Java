package Programa;

public class Pessoa {
	
	/* A variável counter é privada, só pode ser acessada diretamente dentro da propria classe onde foi definida.
	 * Counter é um contador para rastrear quantas instâncias da classe foram criadas.
	 * ao criar cada nova pessoa, aumenta o valor de counter em 1.
	 * Assim, o valor de counter indica quantas pessoas (ou instâncias da classe) foram criadas até o momento
	 * */
	private static int counter = 1;	 	
	
	// Indica que a variável é privada, só pode ser acessada ou modificada dentro da própria classe
	private String nome;
	private String cpf;
	private String email;
	
	/* public: Significa que esse construtor pode ser acessado por qualquer outra classe.
	 * Pessoa: Esse é o nome da classe e, neste caso, também o nome do construtor. 
	 * O nome do construtor sempre deve ser igual ao nome da classe. 
	 * Isso indica ao Java que esse método é especial, pois ele cria uma nova instância (ou seja, um novo objeto) da classe.
	 * (String nome, String cpf, String email): Esses são os parâmetros que o construtor recebe.
	 * Quando você cria um novo objeto Pessoa, precisa fornecer um nome, cpf e email, que são valores do tipo String.
	 * Esses parâmetros são usados para inicializar os atributos nome, cpf, e email da nova instância.
     */
	public Pessoa(String nome, String cpf, String email) { // isso é um construtor, tem sempre o nome da claase. Ele não retorna nada. Ele inicializa o objeto
		/* Em Java, this se refere à instância atual da classe. 
		 * Então, this.nome se refere ao atributo nome do objeto específico que está sendo criado.
		 * this.nome = nome; significa que o valor do parâmetro nome recebido pelo construtor será atribuído ao atributo nome do objeto.
		 * Esse padrão (this.atributo = parametro;) se repete para cpf e email, atribuindo os valores dos parâmetros aos respectivos atributos do objeto.
		 */
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		counter += 1;
	}
	// get significa "obter", então getNome é um método para obter o valor do atributo nome.
	public String getNome() {
		/*return nome;: Esse comando retorna o valor do atributo nome.
		 *Em outras palavras, quando você chama getNome(), ele devolve o valor armazenado em nome.
		 */
		return nome;
	}
	
	/*  setNome(String nome): Este é um método modificador (ou setter).
	 *  Ele permite alterar o valor do atributo nome de uma instância de Pessoa.
	 *  tring nome: O parâmetro nome será usado para definir o novo valor do atributo nome.
	 */
	public void setNome(String nome) {
		// this.nome = nome; Atribui o valor do parâmetro nome ao atributo nome da instância. 
		// O this diferencia o atributo nome do parâmetro nome.
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*toString(): Ele é chamado automaticamente quando você tenta exibir um objeto como uma String 
	 * (por exemplo, ao usar System.out.println(objeto)).
	 */
	public String toString (){
		// Esse comando cria uma String formatada com os valores dos atributos nome, cpf, e email
		return "\nNome: " + this.getNome() +
				"\nCPF: " + this.getCpf() + 
				"\nEMAIL: " + this.getEmail();
		/*this.getNome() chama o método getNome para obter o valor de nome. 
		 * Da mesma forma, this.getCpf() e this.getEmail() chamam os métodos getCpf e getEmail para pegar os valores de cpf e email.
		 * toString devolve uma String com os dados do objeto Pessoa, de modo que, ao imprimir a instância__
		 */
	}
	
	 	
	
}
