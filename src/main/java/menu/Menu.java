/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author douglas
 */
public class Menu {

    public static void main(String[] args) {
        if(Principal.getInstance().menu() == Boolean.FALSE){
            System.out.println("Escalonamento Finalizado");
        };
    }

}
