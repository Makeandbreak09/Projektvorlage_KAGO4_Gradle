package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.netz.Client;
import my_project.model.Ball;
import my_project.view.InputManager;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController extends Client {

    //Attribute
    private double test;


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        super("10.17.128.87", 1337);
        send("Hello There");
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        // Erstelle ein Objekt der Klasse Ball und lasse es zeichnen
        Ball ball1 = new Ball(150,150);
        viewController.draw(ball1);

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        if(ViewController.isKeyDown(KeyEvent.VK_W)){
            send("command#1#simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_D)){
            send("command#0#simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_S)){
            send("command#3#simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_A)){
            send("command#2#simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_SPACE)){
            send("Hello There");
        }else if(ViewController.isKeyDown(KeyEvent.VK_X)){
            send("speed#20#simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_Y)){
            send("speed#-20#simon");
        }
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }

}
