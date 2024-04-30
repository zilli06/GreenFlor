/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greenflor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author Studente
 */
public class Fiori 
{
    private String tipo;
    private String colore;
    private int quantita;
    private LocalDate dataAcquisto;
    private int costo;
    private static long nextCodice=1;
    private long codice;
    

    public Fiori(String tipo, String colore, int quantita,int anno, int mese, int giorno, int costo) 
    {
        this.codice=nextCodice; //assegno il codice al nuovo pc 
        nextCodice++;
        this.tipo = tipo;
        this.colore = colore;
        this.quantita = quantita;
        dataAcquisto = LocalDate.of(anno,mese, giorno);
        this.costo = costo;
    }

    public Fiori(Fiori fi) 
    {
        this.colore=fi.getColore();
        this.quantita=fi.getQuantita();
        this.costo=fi.getCosto();
        this.codice=fi.getCodice();
    }
    
    

    public String getTipo() 
    {
        return tipo;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    public String getColore() 
    {
        return colore;
    }

    public void setColore(String colore) 
    {
        this.colore = colore;
    }

    public int getQuantita() 
    {
        return quantita;
    }

    public void setQuantita(int quantita) 
    {
        this.quantita = quantita;
    }

    

    public int getCosto() 
    {
        return costo;
    }

    public void setCosto(int costo) 
    {
        this.costo = costo;
    }

    public long getCodice() {
        return codice;
    }

    @Override
    public String toString() {
        return "Fiori{" + "tipo=" + tipo + ", colore=" + colore + ", quantita=" + quantita + ", dataAcquisto=" + dataAcquisto + ", costo=" + costo + ", codice=" + codice + '}';
    }
    
    

    
    
    
    
    
}
