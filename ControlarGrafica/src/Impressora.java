
public class Impressora extends Thread{
	
	private Pedido servico;	
	private Gerente gerente;
	private int regra;
	private int tempoTrabalho;
	private String nome;
	
	public Impressora (Gerente g, int regra, String nome) {
		this.gerente = g;
		this.regra = regra;
		this.nome = nome;
		this.tempoTrabalho = 0;
	}
		
	public Pedido getServico() {
		return servico;
	}

	public void setServico(Pedido servico) {
		this.servico = servico;
	}

	@Override
	public void run() {

		/*int pgImpri = servico.getNumPag(); 
		for(int i = 80;i < pgImpri;i+=80) {
			pgImpri-=80;
		}*/
		
		if(this.regra == 1) {
			while (this.gerente.temPedido()) {
				Pedido p = gerente.getPedidoMaiorPrioridade();
				this.tempoTrabalho += p.tempoServico();
				System.out.println(this.nome + " - " + p + " - Tempo de trabalho: " + this.tempoTrabalho);
				this.tempoTrabalho += 15;
			}
			
		}
		else {
			while (this.gerente.temPedido()) {
				Pedido p = this.gerente.getPedidoMenorTrabalho();
				this.tempoTrabalho += p.tempoServico();
				System.out.println(this.nome + " - " + p + " - Tempo de trabalho: " + this.tempoTrabalho);
				this.tempoTrabalho += 15;
			}
		}
		

	}
	
	public int tempoTrabalho() {
		return this.tempoTrabalho;
	}
}
