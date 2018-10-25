
public class Impressora extends Thread{
	
	private Pedido servico;	
	private Gerente gerente;
	private int regra;
	private int tempoTrabalho;
	private String nome;
	private int atrasos;
	private int pedidosAtendidos;
	private int pedidosAtendidosAteMeioDia;
	private final static int MEIODIA = 14400; //em segundos
	
	public Impressora (Gerente g, int regra, String nome) {
		super(nome);
		this.gerente = g;
		this.regra = regra;
		this.nome = nome;
		this.tempoTrabalho = 0;
		this.atrasos = 0;
		this.pedidosAtendidos= 0;
		pedidosAtendidosAteMeioDia = 0;
		
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
	
	public int getPedidosAtendidosAteMeioDia() {
		return this.pedidosAtendidosAteMeioDia;
	}

	@Override
	public void run() {
		
		if(this.regra == 1) {
			while (this.gerente.temPedido()) {
				
				Pedido p = gerente.getPedidoMaiorPrioridade();
				this.tempoTrabalho += p.tempoServico();
				
				if (this.tempoTrabalho < Impressora.MEIODIA) this.pedidosAtendidosAteMeioDia++;
				
				String s = this.nome + " - " + p + " - Tempo de trabalho: " + tempoTrabalhoEmMinutos();
				
				if ( p.getPrioridade() != Pedido.SEM_PRIORIDADE && p.getPrazo()*60 < this.tempoTrabalho) {
					s += " - Atrasado";
					this.atrasos++;
				}
				else {
					s += " - No Prazo";
				}
				
				System.out.println(s);
				try {
					Thread.sleep(p.tempoServico() / 50);
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
				
				if (this.tempoTrabalho < Impressora.MEIODIA) this.pedidosAtendidosAteMeioDia++;
				
				String s = this.nome + " - " + p + " - Tempo de trabalho: " + tempoTrabalhoEmMinutos();
				
				if ( p.getPrioridade() != Pedido.SEM_PRIORIDADE && p.getPrazo()*60 < this.tempoTrabalho) {
					s += " - Atrasado";
					this.atrasos++;
				}
				else {
					s += " - No Prazo";
				}
				
				System.out.println(s);
				try {
					Thread.sleep(p.tempoServico() / 50);
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
	
	public int tempoTrabalhoEmMinutos() {
		return this.tempoTrabalho() / 60;
	}
	
	public int getPedidosAtendidos() {
		return this.pedidosAtendidos;
	}
	
	public String getRegra(){
		if(this.regra == 1) return "Prioridade";
		else return "Trabalho Mais Curto";
	}
	
	public String relatorio() {
		return getName() 
				+ "\n--Tempo trabalho de trabalho: " + tempoTrabalhoEmMinutos() 
				+ "\n--Regra de atendimento: " + getRegra()
				+ "\n--Trabalhos Atendidos: " + getPedidosAtendidos()
				+ "\n--Atendidos Ate Meio dia: " + getPedidosAtendidosAteMeioDia()
				+ "\n--Atrasos: " + getAtrasos() + "\n";
	}
}
