package fpdualeveris;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pinball.Pinball;
import pinball.Puntuacion;

/**
 * Desafío 2 Java
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
	 * Método principal de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenido al pinball de Agustín Guerrero.");
		System.out.println("Para jugar pulse z ó m, y continuación Enter. ¿Lo ha entendido? (Lee bien la pregunta :) )");
		sideChoosen();
		int option = 0;
		do {
			// Se imprime el menú con las opciones disponibles.
			System.out.println("\nElige una opción introduciendo el número de la misma:\n1. Jugar partida.\n2. Ver marcadores.\n3. Salir.");
			try {
				// La opción elegida se guarda. Se realiza un parseo para evitar errores del objeto Scanner.
				option = Integer.parseInt(SC.nextLine());
				// Se trata la excepción si la hubiera, y se reinicia la opción a 0.
			} catch (Exception e) {
				System.out.println(e.toString());
				option = 0;
			}
			// Se evalúa qué opción se ha elegido y según ésta se ejecuta un método u otro.
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
				System.out.println("Opción no disponible.");
				break;
			}
		} while (option != 3);
		System.out.println("Has salido del programa.");
	}
	
	/**
	 * Método que muestra la clasifiación de todas las partidas
	 */
	private static void showClas() {
		for(Puntuacion a : SCORE_LIST) {
			STR.setLength(0);
			STR.append(a.getName()).append(": ").append(a.getScore()).append(" puntos.");
			System.out.println(STR);
		}
		
	}

	/**
	 * Método que inicia el juego, creando un objeto de la clase Pinball
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
		//Finaliza la partida y muestra la puntuación obtenida
		p.finishGame();
		//Se asigna a la puntuación la de la partida
		punt.setScore(p.getPointsScored());
		//Se añade a la lista de todas las clasificaciones
		SCORE_LIST.add(punt);
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
