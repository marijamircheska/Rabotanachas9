package zadaca2;


public class Vraboteni {
	private String ime;
	private String prezime;
	private String plata;
	
	public Vraboteni (String ime, String prezime, String plata) {
		this.ime = ime;
		this.prezime = prezime;
		this.plata = plata;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getPlata() {
		return plata;
	}
	public void setPlata(String plata) {
		this.plata = plata;
	}
}