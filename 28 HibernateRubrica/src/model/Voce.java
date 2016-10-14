package model;

import javax.persistence.*;

@Entity
public class Voce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	private String cognome;
	private String telefono;
	
	public Voce(){
		
	}
	
	public Voce(int id, String nome, String cognome, String telefono) {
		
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTelefono() {
		return telefono;
	}
}
