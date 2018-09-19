import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
	
	public List<Pedido> ler(String nomeArquivo) throws IOException{
		FileInputStream arqEntrada = new FileInputStream(nomeArquivo);
		DataInputStream entrada = new DataInputStream(arqEntrada);
		List<Pedido> lista = new ArrayList();
		
		String registros = entrada.readLine();
		
		while (entrada.available() != 0){
			String[] campos = entrada.readLine().split(";");
			Pedido pedido = new Pedido(
					campos[0],
					Integer.parseInt(campos[1]),
					Double.parseDouble(campos[2]),
					Integer.parseInt(campos[3])
			);
			
			lista.add(pedido);			
		}
		
		
		
		return lista;
	}
}
