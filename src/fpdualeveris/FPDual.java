package fpdualeveris;

import java.util.Scanner;

import pinball.Pinball;

/**
 * Desafío 2 Java
 * 
 * @author aguerrre
 *
 */

public class FPDual {
	/**
	 * Objeto Scanner para usar durante la partida
	 */
	private static final Scanner SC = new Scanner(System.in);

	/**
	 * Método principal de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initGame();
	}

	/**
	 * Método que inicia el juego, creando un objeto de la clase Pinball
	 */
	private static void initGame() {
		Pinball p = new Pinball();
		while (p.getBall() != 0) {
			//Lanza una bola nueva
			p.launchBall();
			//Juega la partida mientras no haya un fallo en la misma
			while (!p.isFail()) {
				p.playGame(sideChoosen());
			}
		}
		//Finaliza la partida y muestra la puntuación obtenida
		p.finishGame();
	}

	/**
	 * Método que devuelve 0 / 1 dependiendo de la tecla pulsada
	 * @return int optionInt
	 */
	private static int sideChoosen() {
		// dos variables para la opción que se elige
		String optionStr = "";
		int optionInt = 0;
		//Se seguirá manteniendo a la espera hasta que se pulse la tecla correcta, se trata también con excepciones.
		while (!(optionStr.equalsIgnoreCase("z") || optionStr.equalsIgnoreCase("m"))) {
			try {
				optionStr = SC.nextLine();
			} catch (Exception e) {
				System.out.println(e.toString());
				optionStr = "";
			}
		}
		//Dependiendo de la tecla pulsada se asignará 0 / 1
		optionInt = optionStr.equalsIgnoreCase("z") ? 0 : 1;

		return optionInt;
	}

}
