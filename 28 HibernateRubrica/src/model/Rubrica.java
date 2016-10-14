package model;

import javax.persistence.*;

@Entity
public class Rubrica {
	
	String nomeRubrica;
	String email;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	public Rubrica(){
		
	}
	
	public Rubrica(int id, String nomeRubrica, String email) {
	
		this.nomeRubrica = nomeRubrica;
		this.id = id;
		this.email = email;
	}

	public String getNomeRubrica() {
		return nomeRubrica;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}
}
