
public class Impressora extends Thread{
	
	private Pedido servico;	
	private Gerente gerente;
	private int regra;
	private int tempoTrabalho;
	private String nome;
	private int atrasos;
	private int pedidosAtendidos;
	
	public Impressora (Gerente g, int regra, String nome) {
		super(nome);
		this.gerente = g;
		this.regra = regra;
		this.nome = nome;
		this.tempoTrabalho = 0;
		this.atrasos = 0;
		this.pedidosAtendidos= 0;
		
	}
		
	public int getAtrasos() {
		return this.atrasos;
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
				String s = this.nome + " - " + p + " - Tempo de trabalho: " + this.tempoTrabalho / 60;
				
				if ( p.getPrioridade() != Pedido.SEM_PRIORIDADE && p.getPrazo()*60 < this.tempoTrabalho) {
					s += " - Atrasado";
					this.atrasos++;
				}
				else {
					s += " - No Prazo";
				}
				
				System.out.println(s);
				try {
					Thread.sleep(p.tempoServico());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.tempoTrabalho += 15;
				this.pedidosAtendidos++;
			}
			
		}
		else {
			while (this.gerente.temPedido()) {
				Pedido p = this.gerente.getPedidoMenorTrabalho();
				this.tempoTrabalho += p.tempoServico();
				String s = this.nome + " - " + p + " - Tempo de trabalho: " + this.tempoTrabalho / 60;
				
				if ( p.getPrioridade() != Pedido.SEM_PRIORIDADE && p.getPrazo()*60 < this.tempoTrabalho) {
					s += " - Atrasado";
					this.atrasos++;
				}
				else {
					s += " - No Prazo";
				}
				
				System.out.println(s);
				try {
					Thread.sleep(p.tempoServico());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.tempoTrabalho += 15;
				this.pedidosAtendidos++;
			}
		}
		

	}
	
	public int tempoTrabalho() {
		return this.tempoTrabalho;
	}
	
	public int tempoTrabalhoEmHoras() {
		return this.tempoTrabalho() / 60 / 60;
	}
}
