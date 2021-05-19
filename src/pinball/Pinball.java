package pinball;

import java.util.Random;

/**
 * Desafío 2 Java
 * 
 * @author aguerrre
 *
 */

public class Pinball {

	/** Objeto StringBuilder para mostrar los mensajes por consola */
	private static final StringBuilder STR = new StringBuilder();

	/** Variable de clase que muestra hacia que lado se va la bola durante el juego. Si es 0 es izquierda, si es 1 es derecha */
	private static int side;

	/** Objeto Random para crear números aleatorios */
	private static final Random r = new Random();

	/** Número de bolas por partida */
	private int ball;

	/** Booleano que indica si se ha producido un fallo o no */
	private boolean fail;

	/** Puntos obtenidos en la partida */
	private long pointsScored;

	/** Constructor sin parámetros que inicia las bolas disponibles a 3 y los puntos a 0 */
	public Pinball() {
		super();
		this.ball = 3;
		this.pointsScored = 0;
	}

	/**
	 * @return the side
	 */
	public static int getSide() {
		return side;
	}

	/**
	 * @param side
	 *            the side to set
	 */
	public static void setSide(int side) {
		Pinball.side = side;
	}

	/**
	 * @return the r
	 */
	public static Random getR() {
		return r;
	}

	/**
	 * @return the ball
	 */
	public int getBall() {
		return ball;
	}

	/**
	 * @param ball
	 *            the ball to set
	 */
	public void setBall(int ball) {
		this.ball = ball;
	}

	/**
	 * @return the fail
	 */
	public boolean isFail() {
		return fail;
	}

	/**
	 * @param fail
	 *            the fail to set
	 */
	public void setFail(boolean fail) {
		this.fail = fail;
	}

	/**
	 * @return the pointsScored
	 */
	public long getPointsScored() {
		return pointsScored;
	}

	/**
	 * @param pointsScored
	 *            the pointsScored to set
	 */
	public void setPointsScored(long pointsScored) {
		this.pointsScored = pointsScored;
	}

	/**
	 * Método para lanzar una nueva bola
	 */
	public void launchBall() {
		System.out.println("Se ha lanzado una nueva bola.");
		// Se resta una bola al total de bolas disponibles
		this.setBall(this.getBall() - 1);
		// Se reinicia la variable fail a false
		this.setFail(Boolean.FALSE);
		// Se obtiene el primer lado aleatorio hacia el que va la bola
		getRandomSide();
	}

	/**
	 * Método para jugar cada bola tirada
	 * 
	 * @param sideChoosen
	 */
	public void playGame(int sideChoosen) {
		int pointsMove = getPointsMove();
		STR.setLength(0);
		STR.append("Puntuación de la jugada: ").append(pointsMove);
		System.out.println(STR);
		// Se suman al total los puntos de la jugada
		this.pointsScored += pointsMove;
		// Si el lado elegido es el mismo que el aleatorio, obtiene un nuevo lado aleatorio, si no, alerta del fallo y cambia fail a true
		if (Pinball.side == sideChoosen) {
			getRandomSide();
		} else {
			System.out.println("¡¡Fallo!!");
			this.setFail(Boolean.TRUE);
		}
	}

	/**
	 * Método para obtener los puntos de una jugada individual
	 * 
	 * @return pointsMove
	 */
	private int getPointsMove() {
		int pointsMove = r.nextInt(100 + 1) * 100;
		return pointsMove;
	}

	/**
	 * Método para obtener hacia qué lado se va la bola
	 */
	private void getRandomSide() {

		int randomSide = r.nextInt(1 + 1);
		if (randomSide == 0) {
			System.out.println("La bola va hacia la izquierda...");
		} else {
			System.out.println("La bola va hacia la derecha...");
		}
		// Se cambia la variable de clase side
		Pinball.setSide(randomSide);
	}

	/**
	 * Método que finaliza el juego y muestra la puntuación total
	 */
	public void finishGame() {
		STR.setLength(0);
		STR.append("Puntuación de la partida: ").append(this.getPointsScored());
		System.out.println(STR);
	}

}
