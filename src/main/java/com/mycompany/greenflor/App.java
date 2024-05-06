/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.greenflor;

import java.io.IOException;
import java.time.LocalDate;
import utilita.ConsoleInput;
import utilita.Menu;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) 
    {
        String[] vociMenu;
        int numeroVoci=11;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        NegozioFiori n1=new NegozioFiori(); //creo lo scaffale vuoto
        int esito;
        //Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera = new ConsoleInput();
        String tipo,colore;
        int quantita,anno,mese,giorno,codice;
        LocalDate dataAcquisto;
        Fiori fio;
        int ripiano, posizione;
        String[] elencoTitoliAutore;
        Fiori[] fioriPresenti;
        String nomeFile = "volumi.CSV";
        String nomeFileBinario = "scaffale.bin";
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutti i fiori";
        vociMenu[2]="\t--> Aggiungi volume";
        vociMenu[3]="\t--> Visualizza volume (ripiano, posizione) ";
        vociMenu[4]="\t--> Elimina volume (ripiano, posizione)";
        vociMenu[5]="\t--> Mostra libri di un autore";
        vociMenu[6]="\t--> Mostra libri presenti in ordine alfabetico di titolo";
        vociMenu[7]="\t--> Esporta i volumi su file CSV";
        vociMenu[8]="\t--> importa i volumi su file CSV";
        vociMenu[9]="\t--> salva dati scaffale";
        vociMenu[10]="\t--> carica dati scaffale";
        
        menu=new Menu(vociMenu);
       
        
        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0: //esci
                    System.out.println("Arrivederci!");    
                    break;
                case 1: //visualizza tutti
                    System.out.println(n1.toString());
                    break;
                case 2: //aggiungi fiore
                    
                    try
                    {
                        System.out.println("tipo --> ");
                        tipo=tastiera.readString();
                        
                        System.out.println("colore --> ");
                        colore=tastiera.readString();
                    
                    do
                    {
                        try
                        {
                            System.out.println("quantita --> ");
                            quantita=tastiera.readInt();
                            
                            break;
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("errore! devi inserire un numero!");
                        }
                    }while(true);
                    
                    do
                    {
                        try
                        {
                            System.out.println("data aa/mm/gg ");
                            dataAcquisto=tastiera.readInt();
                            
                            break;
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("errore! devi inserire un numero!");
                        }
                    }while(true);
                    
                    do
                    {
                        try
                        {
                            System.out.println("Ripiano (0..4) --> ");
                            ripiano=tastiera.readInt();
                            
                            break;
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("errore! devi inserire un numero!");
                        }
                    }while(true);
                    
                    do
                    {
                        try
                        {
                            System.out.println("Posizione (0..14) --> ");
                            posizione=tastiera.readInt();  
                            
                            break;
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("errore! devi inserire un numero!");
                        }
                    }while(true);
                        
                    try 
                        {
                            s1.setLibro(new Libro(titolo,autore,numeroPagine), ripiano, posizione);
                            System.out.println("Volume aggiunto correttamente");
                        } 
                        catch (EccezioneRipianoNonValido ex) 
                        {
                            System.out.println("Ripiano inesistente");
                        } 
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione inesistente");
                        } 
                        catch (EccezionePosizioneOccupata ex)
                        {
                            System.out.println("Posizione già occupata");
                        }
                    }
                    catch(IOException e)
                    {
                        
                    }
                        break;
                        
                    

                case 3: //visualizza voliume ripiano posizione
                    
                    
                    
                    
                
                    try
                    {
                         do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();  

                                break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("errore! devi inserire un numero!");
                            }
                        }while(true);
                    
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..14) --> ");
                                posizione=tastiera.readInt();    

                                break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("errore! devi inserire un numero!");
                            }
                        }while(true);
                    
                    
                    
                         lib=s1.getLibro(ripiano, posizione);
                         System.out.println("Libro cercato: "+lib.toString());
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano inesistente");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("Libro non trovato!");
                    }
                    catch (IOException e)
                    {
                        System.out.println("impossibile leggere la tastiera");
                    }
                    
                       
                
                    
                                
                    
                    
                    
                    break;

                case 4://elimina volume 
                    
                    
                
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();  

                                break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("errore! devi inserire un numero!");
                            }
                        }while(true);
                    
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..14) --> ");
                                posizione=tastiera.readInt();    

                                break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("errore! devi inserire un numero!");
                            }
                        }while(true);
                    
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("Volume rimosso correttamente");
                    } 
                     catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano inesistente");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                          System.out.println("Posizione già vuota. Nessun libro è stato rimosso.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("impossibile acquisire da tastiera");
                    }
                               
                    break;

                case 5://mostra libri autore
                    
                    try
                    {
                        System.out.println("Autore --> ");
                        autore=tastiera.readString();
                        elencoTitoliAutore=s1.elencoTitoliAutore(autore);
                        if(elencoTitoliAutore==null)
                            System.out.println("Nessun libro presente");
                        else
                        {
                            for(int i=0;i<elencoTitoliAutore.length;i++)
                            {
                                System.out.println(elencoTitoliAutore[i]);
                            }
                    }
                    }
                    catch (IOException e)
                    {
                        System.out.println("impossibile leggere da tastiera");
                    }
                    
                    
                    break;
                case 6: //mostra elenco libri ordinati
                    libriPresenti=s1.elencoLibriPresenti();
                    libriPresenti=Ordinatore.selectionSortCrescenteLibri(libriPresenti);
                    for(int i=0;i<libriPresenti.length;i++)
                    {
                        System.out.println(libriPresenti[i].toString());
                    }
                    break;
                    
                case 7: //esporta su file CSV
                    try 
                    {
                       s1.esportaCSV(nomeFile);
                        System.out.println("esportazione avvenuta con successo!!!");
                    }
                    catch (IOException ex)
                    {
                        System.out.println("errore di scrittura, impossibile accedere il file ");
                    }
                    catch (FileException ex) 
                    {
                        System.out.println("file aperto in lettura!");
                    }
                
                    break;
                    
                case 8: //importa da file CSV
                    try
                    {
                        s1.importaCSV(nomeFile);
                        System.out.println("importazione avvenuta con successo.");
                    }
                    catch (IOException ex)
                    {
                        System.out.println("impossibile leggere dal file");
                    }
                    break;
                
                case 9:
                    try
                    {
                        
                        s1.salvaScaffale(nomeFileBinario);
                        System.out.println("salvataggion avvenuto correttamente");
                    }
                    catch (IOException ex)
                    {
                        System.out.println("impossibile salvarr ");
                    }
                    break;
                
                case 10:
                   
                {
                    try 
                    {
                        s1=s1.caricaScaffale(nomeFileBinario);
                        System.out.println("caricamento avvenuto con successo");
                                
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("file non trovato");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("file non trovato");
                    }
                }
                    
                    
                    break;

                    
            }  
        }while(voceScelta!=0);
        
    }
}
