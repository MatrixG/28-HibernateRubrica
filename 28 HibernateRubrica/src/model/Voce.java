package model;

import javax.persistence.*;

@Entity
@Table(name = "VOCE")
public class Voce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VOCE_ID")
	private int id;
	
	@ManyToOne
	private Rubrica rubrica;
	
	private String nome;
	private String cognome;
	private String telefono;
	
	public Voce(){
		
	}
	
	public Voce(Rubrica rubrica, String nome, String cognome, String telefono) {
		
		this.rubrica = rubrica;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.id = 0;
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

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
