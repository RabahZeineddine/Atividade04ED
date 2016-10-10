/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.estrutura.Util;

import atividade04.Atividade04;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RABAH
 */
public class Util {
    
    public static String[] saveCompaniesCodeToArray(File file) {
        String[] allCodes = new String[quantidadeLinhas(file)];
        String[] arraySplit;
        int l = 0;
        try {

            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = "";
            do {
                line = input.readLine();
                if(line!=null && !line.equals("")){
                    arraySplit = line.split(" ");
                    allCodes[l] = arraySplit[0];
                    l++;
                }
            } while (line != null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Atividade04.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Atividade04.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCodes;
    }
    
    
    
    
    

    public static int quantidadeLinhas(File file) {
        LineNumberReader linhaLeitura = null;
        try {
            linhaLeitura = new LineNumberReader(new FileReader(file));
            linhaLeitura.skip(file.length());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                linhaLeitura.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return linhaLeitura.getLineNumber() ;
    }
    
    
    public static List<String> getDifferentCompaniesCodes(String[] allCodes){
        String company = allCodes[0];
        List<String> companiesCodes = new ArrayList<>();
        companiesCodes.add(company);
        int l = 0 ;
        for(int i = 1 ; i < allCodes.length -1 ; i++){
            company = allCodes[i];
            if(!company.equalsIgnoreCase(companiesCodes.get(l))){
                l++;
                companiesCodes.add(company);
            }
        }
        return companiesCodes;
    }
    
    
}
