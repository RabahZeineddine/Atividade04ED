/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade04;

import br.mackenzie.fci.estrutura.Util.Util;
import java.io.File;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author RABAH
 */
public class Atividade04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("dataVoos.txt");
        String[] allCodes = Util.saveCompaniesCodeToArray(file);
        LocalTime startTime = LocalTime.now();
        System.out.println("FORMA1:\n Existe " + Util.getDifferentCompaniesCodes(allCodes).size() + " companhias áreas diferentes");
        LocalTime finishTime = LocalTime.now();
        System.out.println("Tempo de execucao para a FORMA1: " + ChronoUnit.MILLIS.between(startTime, finishTime) + " ms");
        int mid = 0, count = 1;
        String x = allCodes[0];

        startTime = LocalTime.now();
        do {
            mid = first(allCodes, 0, allCodes.length - 1, x) + 1;
           // System.out.println("mid " + mid + " allCodes.length : " + allCodes.length);
            if (mid < allCodes.length) {
                x = allCodes[mid];
                count++;
            }
        } while (mid < allCodes.length);
        finishTime = LocalTime.now();
        System.out.println("FORMA2 :\n Existe " + count + " companhias áreas diferentes");
        System.out.println("Tempo de execição para a FORMA2: " + ChronoUnit.MILLIS.between(startTime, finishTime) + " ms");
    }

    public static int first(String arr[], int low, int high, String x) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (mid + 1< arr.length ) {
                if (x.equals(arr[mid]) && !x.equals(arr[mid + 1])) {
                    return mid;
                } else if (x.equals(arr[mid])) {
                    return 0 + first(arr, mid + 1, high, x);
                } else {
                    return 0 + first(arr, low, mid - 1, x) + first(arr, mid + 1, high, x);
                }
            }else if( x.equals(arr[mid])) return mid;
        }
        return 0;
    }
}
