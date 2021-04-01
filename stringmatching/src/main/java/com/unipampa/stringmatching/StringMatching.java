/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipampa.stringmatching;

import java.util.Scanner;

/**
 *
 * @author Auri Gabriel
 */
public class StringMatching {

    public static void main(String[] args) {        
        Scanner e = new Scanner(System.in);
        String heystack;
        System.out.println("Digite o texto que deseja usar para a busca:");
        heystack = e.nextLine();
        String needle;
        System.out.println("Digite o que o texto ou letra que deseja buscar a posição:");
        needle = e.nextLine();
        System.out.print("A posição é:");
        System.out.println(indexOf(heystack.toCharArray(), needle.toCharArray()));
    }

    /**
     * English: Returns the index within this string of the first occurrence of
     * the specified substring. If it is not a substring, return -1.
     *
     * PT-BR: Devolve o índice dentro desta string da primeira ocorrência da
     * substring especificada. Se não for uma substring, retorna -1.
     *
     * @param haystack The string to be scanned | A string para ser escaneada
     * @param needle The target string to search | A string a ser buscada
     * @return The start index of the substring | O índice inicial da substrting
     */
    public static int indexOf(char[] haystack, char[] needle) {
        if (needle.length == 0) {
            return 0;
        }
        int charTable[] = makeCharTable(needle);
        int offsetTable[] = makeOffsetTable(needle);
        for (int i = needle.length - 1, j; i < haystack.length;) {
            for (j = needle.length - 1; needle[j] == haystack[i]; --i, --j) {
                if (j == 0) {
                    return i;
                }
            }
            // i += needle.length - j; // For naive method
            i += Math.max(offsetTable[needle.length - 1 - j], charTable[haystack[i]]);
        }
        return -1;
    }

    /**
     * English: Makes the jump table based on the mismatched character
     * information. 
     * 
     * PT-BR: Faz a tabela de salto com base na informação de
     * carácter desajustada.
     */
    private static int[] makeCharTable(char[] needle) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];
        for (int i = 0; i < table.length; ++i) {
            table[i] = needle.length;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            table[needle[i]] = needle.length - 1 - i;
        }
        return table;
    }

    /**
     * English: Makes the jump table based on the scan offset which mismatch
     * occurs. 
     * 
     * PT-BR: Faz a tabela de salto com base no offset da varredura, o
     * qual ocorre um descasamento.
     */
    private static int[] makeOffsetTable(char[] needle) {
        int[] table = new int[needle.length];
        int lastPrefixPosition = needle.length;
        for (int i = needle.length - 1; i >= 0; --i) {
            if (isPrefix(needle, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            table[needle.length - 1 - i] = lastPrefixPosition - i + needle.length - 1;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            int slen = suffixLength(needle, i);
            table[slen] = needle.length - 1 - i + slen;
        }
        return table;
    }

    /**
     * English: Is needle[p:end] a prefix of needle? 
     * 
     * PT-BR: É a agulha[p:end] um prefixo de agulha?
     */
    private static boolean isPrefix(char[] needle, int p) {
        for (int i = p, j = 0; i < needle.length; ++i, ++j) {
            if (needle[i] != needle[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * English: Returns the maximum length of the substring ends at p and is a
     * suffix. 
     * 
     * PT-BR: Retorna o tamanho maximo da substring, termina na int p,
     * que é um sufixo.
     */
    private static int suffixLength(char[] needle, int p) {
        int len = 0;
        for (int i = p, j = needle.length - 1;
                i >= 0 && needle[i] == needle[j]; --i, --j) {
            len += 1;
        }
        return len;
    }
}
