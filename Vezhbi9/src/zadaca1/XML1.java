package zadaca1;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML1 {
	public void createXMLFile(String fileName, Vraboten vraboten) {
		try {
			//�������� �� ��������
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			//�������� �� ���������� �� ����������
			//�������� �� root ���������
			Element root = document.createElement("Vraboten");
			document.appendChild(root);
			
			//�������� �� ��������� - ���
			Element ime =  document.createElement("Ime");
			root.appendChild(ime);
			
			//�������� �� ��������� - �������
			Element prezime = document.createElement("Prezime");
			root.appendChild(prezime);
			
			//�������� �� ��������� - �����
			Element plata = document.createElement("Plata");
			root.appendChild(plata);
			
			//���������� ���������
			prezime.appendChild(document.createTextNode(vraboten.getIme()));
			ime.appendChild(document.createTextNode(vraboten.getPrezime()));
			plata.appendChild(document.createTextNode(vraboten.getPlata()));
			
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