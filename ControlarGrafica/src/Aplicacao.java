import java.util.Scanner;

public class Aplicacao {

	public static final Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) throws InterruptedException {
		
		Leitor a = new Leitor();
		String relatorio = "";
		Gerente gerente = new Gerente(a.ler("dadosGrafica.txt"));
		
		Impressora A = new Impressora(gerente, 1, "Impressora A");
		Impressora B = new Impressora(gerente, 2, "Impressora B");
		
		//System.out.println("Tempo trabalho total: " + gerente.TempoTrabalhoTotal());
		
		System.out.println("Simulação duas impressoras");
		A.start();
		B.start();
		
		A.join();  B.join(); 
		
		
		
		Gerente gerente2 = new Gerente(a.ler("dadosGrafica.txt"));
		Impressora C = new Impressora(gerente2, 1, "Impressora C");
		Impressora D = new Impressora(gerente2, 2, "Impressora D");
		Impressora E = new Impressora(gerente2, 1, "Impressora E");
		
		System.out.println("Simulação três impressoras");
		C.start();
		D.start();
		E.start();
		A.join();  B.join(); C.join();
		
		System.out.println("\n\nRelatório - Teste Com duas Impressoras. Prioridade e Trabalho mais curto");
		System.out.println(A.relatorio());
		System.out.println(B.relatorio());
		
		System.out.println("\n\nRelatório - Teste com três impressoras. Duas Prioridade e Uma Trabalho mais curto");
		System.out.println(C.relatorio());
		System.out.println(D.relatorio());
		System.out.println(E.relatorio());
 	}
}