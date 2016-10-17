package model;

import javax.persistence.*;

@Entity
@Table(name = "RUBRICA")
public class Rubrica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RUBRICA_ID")
	int id;
	
	@Column(name = "NOME", unique = false, nullable = false, length = 100)
	String nomeRubrica;
	@Column(name = "EMAIL", unique = false, nullable = false, length = 100)
	String email;
	
	public Rubrica(){
		
	}
	
	public Rubrica(String nomeRubrica, String email) {
	
		this.nomeRubrica = nomeRubrica;
		this.id = 0;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
