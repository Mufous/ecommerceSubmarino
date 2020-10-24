package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import com.google.gson.Gson;

public class LeitorJsonWithGson {
	// create Gson instance
    Gson gson = new Gson();
    Reader reader;
    Map<String, String> map;
    
    /*
     * Grava arquivos jSon no diretorio desejado
     */

	private void gravaArquivoJson() throws IOException {
		FileWriter writer = new FileWriter("C:\\Users\\eduar\\eclipse-workspace\\ecommerce_qaacademy\\massa_testes_copy.json");
	    gson.toJson(map,writer);
	    writer.flush();
	    writer.close();
	}
	
	/*
     * Faz a leitura de arquivos jSon no diretorio desejado
     */
	
	public void leitorJson() throws IOException {

	    // Leitor do Java
	    reader = new FileReader("C:\\Users\\eduar\\eclipse-workspace\\ecommerce_qaacademy\\massa_testes.json");
	    // convert JSON file to map
	    map = gson.fromJson(reader, Map.class);
	    exibirmapJson(map);
	    System.out.println(map.get("url"));

	    // close reader
	    reader.close();

	}
	
	/*
     * Exibe os registros np arquivo jSon
     */

	private void exibirmapJson(Map<String, String> map) {
		// print map entries
	    for (Map.Entry<String, String> entry : map.entrySet()) {
	        System.out.println(entry.getKey() + "=" + entry.getValue());
	    }
	}
	
	/*
	 * Captura a chave que identifica o valor que queremos utilizar no arquivo jSon
	 */
	
	public String getMassa(String chave) {
		return map.get(chave);
	}
	

}
