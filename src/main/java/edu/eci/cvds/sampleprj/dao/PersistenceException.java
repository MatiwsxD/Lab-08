package edu.eci.cvds.sampleprj.dao;
/**
 * @author (Juan Mejia y Julian Peña)
 * @version (12/10/2021)
 */
public class PersistenceException extends Exception{
    public PersistenceException(String mensaje,Exception e){
        super(mensaje,e);
    }
    public PersistenceException(String mensaje){
        super(mensaje);
    }
}