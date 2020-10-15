/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import repositories.Repository;

/**
 *
 * @author harmony
 */
public class DAOObjectFileImpl implements DAOInterface {

    @Override
    public Repository load(String filename){
        Repository repository= null;
        FileInputStream fin = new FileInputStream(filename);
        try(ObjectInputStream ois= new ObjectInputStream(fin)){
           repository.add( (Customer)ois.readObject());
            fin.close();
        } catch (IOException ex) {
            
            Logger.getLogger(DAOObjectFileImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return repository;
    }

    @Override
    public void store(String filename,Repository repository) {
        ObjectOutputStream output =null;
        repository.store(filename);
        try{
           output = new ObjectOutputStream(new FileOutputStream(filename)); 
           output.writeObject(repository);
           output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOObjectFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOObjectFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(DAOObjectFileImpl.class.getName()).log(Level.SEVERE, null, ex);
            }}
        }
    
}
