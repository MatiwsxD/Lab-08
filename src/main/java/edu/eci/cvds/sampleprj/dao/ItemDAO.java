package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;

import java.util.Date;
import java.util.List;

public interface ItemDAO {

    public void save(Item it) throws PersistenceException;

    public Item load(int id) throws PersistenceException;

    public List<Item> loadItems() throws PersistenceException;

    public List<Item> consultarItemsDisponibles() throws PersistenceException ;

    public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException ;


}
