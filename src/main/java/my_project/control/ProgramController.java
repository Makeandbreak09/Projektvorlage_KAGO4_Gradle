package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.netz.Client;

import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController extends Client {

    //Attribute


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
        super("192.168.178.29", 6666);
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        send("help");
        send("joinGame simon");
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        if(ViewController.isKeyDown(KeyEvent.VK_Q)){
            send("move simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_W)){
            send("setSpeed 2 simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_S)){
            send("setSpeed 0.5 simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_E)){
            send("spawn Banana simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_R)){
            send("spawn Portal simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_D)){
            send("destroy Banana simon");
        }else if(ViewController.isKeyDown(KeyEvent.VK_F)){
            send("destroy Portal simon");
        }
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }
}
