import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.LinkedHashSet;
import java.util.Set;

public class Leitor {
	
	public static Set<Pedido> ler(String nomeArquivo) {
		Set<Pedido> list = new LinkedHashSet<Pedido>();	
		
		try {
			FileInputStream arq = new FileInputStream(nomeArquivo);
			DataInputStream entrada = new DataInputStream(arq);
			
			@SuppressWarnings("deprecation")
			String qtdReg = entrada.readLine();
			
			while(entrada.available()!=0) {
				@SuppressWarnings("deprecation")
				String[] campos = entrada.readLine().split(";");
				String nome = campos[0];
				int numPg = Integer.parseInt(campos[1]);
				double valor = Double.parseDouble(campos[2].replace(",","."));
				int prazo = Integer.parseInt(campos[3]);
							
				list.add(new Pedido(nome,numPg,valor,prazo));
			}
			
			entrada.close();
			arq.close();
		}
		catch(Exception IO){
			System.out.println("Error");
		}
		
		return list;
	}
}
