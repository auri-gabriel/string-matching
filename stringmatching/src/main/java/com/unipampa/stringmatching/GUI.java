/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipampa.stringmatching;

import static com.unipampa.stringmatching.StringMatching.indexOf;
import java.util.Scanner;
import com.unipampa.stringmatching.TextGenerator;

/**
 *
 * @author Auri Gabriel
 */
public class GUI {
    public static void main(String[] args) {

        TextGenerator generator = new TextGenerator();
        Scanner e = new Scanner(System.in);
        String heystack;
        System.out.println("Digite o texto que deseja usar para a busca:");
        heystack = e.nextLine();
        String needle;
        System.out.println("Digite o que o texto ou letra que deseja buscar a posição:");
        needle = e.nextLine();
        if (indexOf(heystack.toCharArray(), needle.toCharArray()) >= 0) {
            System.out.print("A posição é:");
            System.out.println(indexOf(heystack.toCharArray(), needle.toCharArray()));
        } else {
            System.out.print("Não Encontrado!");
        }

    }

}
