package fpdualeveris;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pinball.Pinball;
import pinball.Puntuacion;

/**
 * Desaf�o 2 Java
 * 
 * @author aguerrre
 *
 */

public class FPDual {
	/**
	 * Objeto StringBuilder para mostrar los mensajes por consola
	 */
	private static final StringBuilder STR = new StringBuilder();
	/**
	 * Objeto Scanner para usar durante la partida
	 */
	private static final Scanner SC = new Scanner(System.in);
	/**
	 * Lista para las Puntuaciones
	 */
	private static final List<Puntuacion> SCORE_LIST = new ArrayList<>();
	/**
	 * M�todo principal de la aplicaci�n
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenido al pinball de Agust�n Guerrero.");
		System.out.println("Para jugar pulse z � m, y continuaci�n Enter. �Lo ha entendido? (Lee bien la pregunta :) )");
		sideChoosen();
		int option = 0;
		do {
			// Se imprime el men� con las opciones disponibles.
			System.out.println("\nElige una opci�n introduciendo el n�mero de la misma:\n1. Jugar partida.\n2. Ver marcadores.\n3. Salir.");
			try {
				// La opci�n elegida se guarda. Se realiza un parseo para evitar errores del objeto Scanner.
				option = Integer.parseInt(SC.nextLine());
				// Se trata la excepci�n si la hubiera, y se reinicia la opci�n a 0.
			} catch (Exception e) {
				System.out.println(e.toString());
				option = 0;
			}
			// Se eval�a qu� opci�n se ha elegido y seg�n �sta se ejecuta un m�todo u otro.
			switch (option) {
			case 1:
				initGame();
				break;
			case 2:
				showClas();
				break;
			case 3:
				break;
			default:
				System.out.println("Opci�n no disponible.");
				break;
			}
		} while (option != 3);
		System.out.println("Has salido del programa.");
	}
	
	/**
	 * M�todo que muestra la clasifiaci�n de todas las partidas
	 */
	private static void showClas() {
		for(Puntuacion a : SCORE_LIST) {
			STR.setLength(0);
			STR.append(a.getName()).append(": ").append(a.getScore()).append(" puntos.");
			System.out.println(STR);
		}
		
	}

	/**
	 * M�todo que inicia el juego, creando un objeto de la clase Pinball
	 */
	private static void initGame() {
		Pinball p = new Pinball();
		System.out.println("Introduce el nombre del jugador:");
		Puntuacion punt = new Puntuacion(SC.nextLine());
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
		//Se asigna a la puntuaci�n la de la partida
		punt.setScore(p.getPointsScored());
		//Se a�ade a la lista de todas las clasificaciones
		SCORE_LIST.add(punt);
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
