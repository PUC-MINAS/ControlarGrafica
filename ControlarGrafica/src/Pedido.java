
public class Pedido implements Comparable<Pedido> {
	
	private String nome;
	
	private int numPag,prazo,tempoGasto=0;
	
	public int getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(int tempoGasto) {
		this.tempoGasto += tempoGasto;
	}

	private double valor, prioridade;	
	
	public Pedido(String nome, int numPag, double valor, int prazo) {
		this.nome = nome;
		this.numPag = numPag;
		this.valor = valor;
		this.prazo = prazo;
	}
	
	public double getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(double prioridade) {
		this.prioridade = prioridade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Pedido pedido) {
		if(this.prioridade < pedido.prioridade) {
			return -1;
		}
		return 1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome + ": " + this.numPag + " folhas -  $" + this.valor + " - prazo: " + this.prazo + " - prioridade: " + this.prioridade;
	}
}
