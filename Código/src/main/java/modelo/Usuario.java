package modelo;

/**
 * Esta clase define al tda usuario, esta contiene los datos relevantes del usuario
 * @author Jaime Carrasco
 */
public class Usuario{
	private String username;
	private String pass;
	private int reputacion;

	/**
	 * Constructor Usuario
	 * @param username nombre de usuario
	 * @param pass clave
	 * @param reputacion reputación del usuario
	 */
	public Usuario(String username,String pass,int reputacion){
		this.username=username;
		this.pass=pass;
		this.reputacion=reputacion;
	}

	/**
	 * getter del username
	 * @return username, un string
	 */
	public String getUser(){
		return username;
	}

	/**
	 * getter de la clave
	 * @return clave del usuario en string
	 */
	public String getPass(){
		return pass;
	}

	/**
	 * getter de la reputación del usuario
	 * @return un entero
	 */
	public int getReputacion(){
		return reputacion;
	}

	/**
	 * modifica la reputación dle usuario
	 * @param puntos la cantidad de puntos que se le añaden o quitan.
	 */
	public void anadirReputacion(int puntos){
		this.reputacion+=puntos;
	}
}
