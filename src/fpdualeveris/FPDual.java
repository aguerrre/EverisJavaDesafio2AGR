package fpdualeveris;

import java.util.Scanner;

import pinball.Pinball;

/**
 * Desaf�o 2 Java
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
	 * M�todo principal de la aplicaci�n
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initGame();
	}

	/**
	 * M�todo que inicia el juego, creando un objeto de la clase Pinball
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
		//Finaliza la partida y muestra la puntuaci�n obtenida
		p.finishGame();
	}

	/**
	 * M�todo que devuelve 0 / 1 dependiendo de la tecla pulsada
	 * @return int optionInt
	 */
	private static int sideChoosen() {
		// dos variables para la opci�n que se elige
		String optionStr = "";
		int optionInt = 0;
		//Se seguir� manteniendo a la espera hasta que se pulse la tecla correcta, se trata tambi�n con excepciones.
		while (!(optionStr.equalsIgnoreCase("z") || optionStr.equalsIgnoreCase("m"))) {
			try {
				optionStr = SC.nextLine();
			} catch (Exception e) {
				System.out.println(e.toString());
				optionStr = "";
			}
		}
		//Dependiendo de la tecla pulsada se asignar� 0 / 1
		optionInt = optionStr.equalsIgnoreCase("z") ? 0 : 1;

		return optionInt;
	}

}
