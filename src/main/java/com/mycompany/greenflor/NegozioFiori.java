/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greenflor;

/**
 *
 * @author Studente
 */
public class NegozioFiori {
    
    private Fiori [] elencoFiori;
    private final int N_MAX_FIORI=1000;
    private int nFioriPresenti;
    
    public NegozioFiori()
    {
        elencoFiori= new Fiori [N_MAX_FIORI];
    }
    
    public int getN_MAX_FIORI()
    {
        return N_MAX_FIORI;
    }
    
    public int getnFioriPresenti()
    {
        int contaFiori=0;
        for(int i=0; i<N_MAX_FIORI; i++)
        {
            if(elencoFiori[i]!=null)
                contaFiori++;
        }
        return contaFiori;
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
