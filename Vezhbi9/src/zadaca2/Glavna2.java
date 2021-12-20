package zadaca2;

import java.util.ArrayList;
import java.util.List;

public class Glavna2 {

	public static void main(String[] args) {
		
		List<Vraboteni> v = new ArrayList<Vraboteni>();
	
		v.add(new Vraboteni("Stefan", "Stefanovski", "10000"));
		v.add(new Vraboteni("Aleksandar", "Ristevski", "15000"));
		
		XML2 xml = new XML2();
		xml.createXMLFile("xml.xml", v);
	}
}
