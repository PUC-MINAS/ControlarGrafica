import java.util.Set;

public class Impressora extends Thread{
	
	public Set<Pedido> servico;
	
	public Impressora(Set<Pedido> servico) {
		this.servico = servico;
		start();
	}
	
	@Override
	public void run() {
			this.servico.forEach(p->{
				int numPg = p.getFolhas(),tempo=1;
				for(int i = 80;i < numPg;i+=80) {
					tempo++;
					numPg-=80;
				}
				
				Regras.tempo += tempo;
				try {
					Thread.sleep((long) 0.25);
				} catch (InterruptedException e) {
					System.out.println("deu ruim");
					e.printStackTrace();
				}
			});
	}
}
