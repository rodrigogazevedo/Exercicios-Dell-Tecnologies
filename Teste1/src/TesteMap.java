import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class TesteMap {

	public static void main(String[] args) {

		List<String> nomes = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		List<String> endereco = new ArrayList<>(Arrays.asList("e1", "e2", "e3", "e4"));
		List<String> telefone = new ArrayList<>(Arrays.asList("t1", "t2", "t3", "t4"));

		HashMap<List<String>, HashMap<List<String>, List<String>>> map = new HashMap<>();

		HashMap<List<String>, List<String>> end_tel = new HashMap<>();
		end_tel.put(endereco, telefone);

		map.put(nomes, end_tel);

		for (Entry<List<String>, HashMap<List<String>, List<String>>> wtf : map.entrySet()) {
			for (String nome : wtf.getKey()) {
				System.out.println(nome);
				for (Entry<List<String>, List<String>> wtf2 : wtf.getValue().entrySet()) {
					System.out.println(wtf2.getKey() + " " + wtf2.getValue());
				}
			}
		}
	}

}
