package zadaca2;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML2 {
	public void createXMLFile(String fileName, List<Vraboteni> vraboteni) {
		try {
			//Креирање на документ
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			//Креирање на root елементот
			Element root = document.createElement("Vraboteni");
			document.appendChild(root);

			for (Vraboteni v : vraboteni) {
				//Креирање на елементот - Vraboten (овој елемент ќе се додаде на root елементот)
				Element vrabotenElement = document.createElement("Vraboten");
				root.appendChild(vrabotenElement);

				//Следните елементи ќе се додадат на елементот Vraboten
				//Креирање на елементот - Ime
				Element ime =  document.createElement("Ime");
				vrabotenElement.appendChild(ime);

				//Креирање на елементот - Prezime
				Element prezime = document.createElement("Prezime");
				vrabotenElement.appendChild(prezime);

				//Креирање на елементот - Plata
				Element plata = document.createElement("Plata");
				vrabotenElement.appendChild(plata);

				//Доделување вредности
				prezime.appendChild(document.createTextNode(v.getIme()));
				ime.appendChild(document.createTextNode(v.getPrezime()));
				plata.appendChild(document.createTextNode(v.getPlata()));
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);

			StreamResult result = new StreamResult(new File(fileName));

			transformer.transform(source, result);
			System.out.println("Fajlot e kreiran, imeto e: "+ fileName);

			System.out.println("Fajlot e zachuvan.");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}