
public class Impressora extends Thread{
	
	private Pedido servico;
	
	private Gerente gerente;
	private int regra;
	
	public Impressora (Gerente g, int regra) {
		this.gerente = g;
		this.regra = regra;
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
				System.out.println( gerente.getPedidoMaiorPrioridade());
			}
			
		}
		else {
			while (this.gerente.temPedido()) {
				System.out.println(this.gerente.getPedidoMenorTrabalho());
			}
		}
		
		

	}
}
