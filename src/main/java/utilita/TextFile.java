/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import eccezioni.FileException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * rappresenta un file di testo.
 * consente di scrivere sul file di testo e di leggere
 * dal file di testo.
 * @author nicola
 * 
 */
public class TextFile 
{
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;

/**
 * costruttore 
 * @param fileName pathname dal file fisico da aprire 
 * @param mode indica la modalità di apertura del file 
 * può assumere due valori, W(apertura in scrittura), R(apertura in lettura).
 * qualsiasi altro valore assegnato a questo paramentro fa si che il file venga aperto 
 * in lettura.
 * @throws FileNotFoundException sollevata quando il file non viene trovato
 * @throws IOException sollevata quando non è possibile accedere al file
 */   
    
    public TextFile(String fileName, char mode) throws FileNotFoundException, IOException
    {
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
            
        
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName));
        }
    
    }
    
/**
    * costruttore 
    * @param fileName pathname dal file fisico da aprire 
    * @param mode indica la modalità di apertura del file 
    * può assumere due valori, W(apertura in scrittura), R(apertura in lettura).
    * qualsiasi altro valore assegnato a questo paramentro fa si che il file venga aperto 
    * in lettura.
    * @throws FileNotFoundException sollevata quando il file non viene trovato
    * @throws IOException sollevata quando non è possibile accedere al file
    * @append specifica se il file, quando è aperto in lettura, è aperto in  append o no.
    * Valore True= aperto, valore False= aperto non in  append.
*/
    
    public TextFile(String fileName, char mode, boolean append) throws FileNotFoundException, IOException
    {
        
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
            
        
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName, append));
        }
    
    }
    
    /**
     * scrive una stringa sul file aperto in scrittura 
     * @param line stringa da scrivere 
     * @throws FileException quando il file è aperto in lettura anzichè in scrittura
     * @throws IOException sollevata quando non è possibile accedere al file
     */
    
    public void toFile(String line) throws FileException, IOException
    {
        if (mode=='R')
        {
            throw new FileException("il file è aperto in lettura!!!");
        }
        else
            writer.write(line);
            writer.newLine();
    }

/**
 * legge una stringa da un file aperto in lettura
 * @return stringa letta 
 * @throws FileException viene sollevata quando il file è aperto in 
 * scrittura anzichè in lettura
 * viene sollevata anche quando sono state lette tutte le righe 
 * @throws IOException sollevata quando non è possibile accedere al file
 */    
    
    public String fromFile() throws FileException, IOException
    {
        String line;
        if (mode=='W')
        {
            throw new FileException("il file è aperto in scrittura");
        }
        else
            line=reader.readLine();
        
        if(line==null)
            throw new FileException("fine del file");
        return line;
    }
    
    /**
     * chiude il file
     * @throws IOException sollevata quando non è possibile accedere al file
     */
    
    public void close() throws IOException
    {
        if(mode=='R')
        {
            reader.close();
        }
        else
            writer.close();
    }
    
    
    
    
}
