package pinball;

/**
 * Desafio 2 - Java
 * 
 * @author aguerrre
 *
 */
public class Puntuacion {

	/** Variables de instancia */
	private final String name;
	private long score;

	/**
	 * Constructor con el nombre del jugador como parámetro
	 * 
	 * @param name
	 */
	public Puntuacion(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the score
	 */
	public long getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(long score) {
		this.score = score;
	}

}
