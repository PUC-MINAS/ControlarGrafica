
public class Pedido implements Comparable<Pedido> {
	
	private String nome;
	private int folhas;
	private double preco;
	private int prazo;
	private int prioridade;
	
	public Pedido (String nome, int folhas, double preco, int prazo) {
		this.setNome(nome);
		this.setFolhas(folhas);
		this.setPreco(preco);
		this.setPrazo(prazo);
		this.setPrioridade(this.calcPrioridade(folhas, prazo));
	}
	
	public int calcPrioridade(int folhas, int prazo){
		int tempoTrabalho = folhas / 80;
		if (prazo <= 0 || prazo < tempoTrabalho ){
			return 10000;
		}
		else {
			return prazo - tempoTrabalho;
		}
		
	}
 	public String getNome() {
		return nome;
	}
 	public void setNome(String nome) {
		this.nome = nome;
	}
 	public int getFolhas() {
		return folhas;
	}
 	public void setFolhas(int folhas) {
		this.folhas = folhas;
	}
 	public double getPreco() {
		return preco;
	}
 	public void setPreco(double preco) {
		this.preco = preco;
	}
 	public int getPrazo() {
		return prazo;
	}
 	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
	public void imprimir(){
		this.folhas--;
	}
	
	public void imprimir (int quantidade){
		this.folhas = this.folhas - quantidade;
	}
 	public int getPrioridade() {
		return prioridade;
	}
 	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
 	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome + ": " + this.folhas + " folhas -  $" + this.preco + " - prazo: " + this.prazo + " - prioridade: " + this.prioridade;
	}

	@Override
	public int compareTo(Pedido pedido) {
		if(this.prioridade < pedido.prioridade) {
			return -1;
		}
		return 1;
	}
}
