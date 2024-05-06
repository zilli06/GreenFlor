/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greenflor;

import eccezioni.EccezioneCodeNonPresente;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.Ordinatore;

/**
 *
 * @author Studente
 */
public class NegozioFiori implements Serializable{
    
    private Fiori [] elencoFiori;
    private final int N_MAX_FIORI=1000;
    private int nFioriPresenti;
    
    public NegozioFiori()
    {
        elencoFiori= new Fiori [N_MAX_FIORI];
    }
    
    public int getNFioriPresenti()
    {
        return nFioriPresenti;
    }
    public int getN_MAX_FIORI()
    {
        return N_MAX_FIORI;
    }
    
    public Fiori getFiori(int code) throws EccezioneCodeNonPresente
    {
        Fiori fio;
        for(int i=0;i<nFioriPresenti;i++)
        {
            if(elencoFiori[i].getCodice()==code)
            {
                fio=new Fiori(elencoFiori[i]);
                return fio;
            }
        }
        throw new EccezioneCodeNonPresente();
    }
    public int aggiungiFiori(Fiori fi)
    {
        if(nFioriPresenti>=N_MAX_FIORI)
            return -1;
        else
        {
            elencoFiori[nFioriPresenti]=new Fiori(fi);
            nFioriPresenti++;
            return 0;
        }
    }
    
     public Fiori cercaFiori(int codiceDaCercare)
    {
         for(int i=0;i<N_MAX_FIORI;i++)
        {
            if(elencoFiori[i].getCodice()==codiceDaCercare)
                return new Fiori(elencoFiori[i]);   
                    
        }
        return null;
    }
     
     
     public void eliminaFioriPosizione(int pos)
     {
        for(int i=pos; i<nFioriPresenti-1;i++)
        {
            elencoFiori[i]=elencoFiori[i+1];
        }
        elencoFiori[nFioriPresenti]=null;
        nFioriPresenti--;
     }
     
     public int eliminaFiori(long codiceDaEliminare)
     {
         for(int i=0; i<nFioriPresenti;i++)
         {
             if(elencoFiori[i].getCodice()==codiceDaEliminare)
             {
                 eliminaFioriPosizione(i);
                 return 0;
             }
         }
         return -1;
     }
     
     public void modificaCestista(int codice) throws EccezioneCodeNonPresente, IOException
    {
        int sceltaFiore=0;
        String[] voci={"Annulla","tipo","colore","Data acquisto","quantità"};
        Menu menu;
        String tipo,colore;
        int quantita,costo;
        int giorno = 0,mese,anno;
        LocalDate dataAcquisto;
        ConsoleInput tastiera=new ConsoleInput();
        
        for(int i=0;i<nFioriPresenti;i++)
        {
            if(elencoFiori[i].getCodice()==codice)
            {
                System.out.println(elencoFiori[i].toString());
                menu=new Menu(voci);
                sceltaFiore=menu.sceltaMenu();
                switch (sceltaFiore) 
                {
                    case 0:
                        break;
                    case 1:
                        System.out.print("Nuovo tipo-->");
                        tipo=tastiera.readString();
                        elencoFiori[i].setTipo(tipo);
                        break;
                    case 2:
                        System.out.print("Nuovo colore-->");
                        colore=tastiera.readString();
                        elencoFiori[i].setColore(colore);
                        break;
                    case 3:
                        System.out.println("Nuova data:");
                        System.out.print("anno-->");
                        anno=tastiera.readInt();
                        System.out.print("mese-->");
                        mese=tastiera.readInt();
                        System.out.print("anno-->");
                        anno=tastiera.readInt();
                        elencoFiori[i].setDataAcquisto(LocalDate.of(anno,mese,giorno));
                        break;
                    case 4:
                        System.out.println("nuova quantita:");
                        quantita=tastiera.readInt();
                        elencoFiori[i].setQuantita(quantita);
                        break;

                }
                return;
            }     
        }
        throw new EccezioneCodeNonPresente();
    }
     
    public Fiori[] ordinaQuantitaCrescente(NegozioFiori f)
    {
        //creo una copia di "s" e lo chiamo "vOrdinato"
        Fiori[] vOrdinato=new Fiori[getNFioriPresenti()];
        for(int i=0;i<getNFioriPresenti();i++)
        {
            try 
            {
                vOrdinato[i]=this.getFiori(i);
            } 
            catch (EccezioneCodeNonPresente ex) 
            {
                //non fare nulla
            }
        }
        for(int i=0;i<getNFioriPresenti()-1;i++)
        {
            for(int j=i+1;j<getNFioriPresenti();j++)
            {
                if(vOrdinato[j].getQuantita()<vOrdinato[i].getQuantita())
                    Ordinatore.scambiaFiori(vOrdinato, i, j);
            }
        }
        return vOrdinato;
    } 
     
     
     
     public String toString()
     {
        String s="";
        for(int i=0; i<nFioriPresenti;i++)
        {
            s=s+elencoFiori[i].toString()+"\n";
            
        }
        return s;
     }
     
    
}
