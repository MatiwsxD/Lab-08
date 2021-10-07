/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Date;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

        
        //Crear el mapper y usarlo: 
        ClienteMapper cm = sqlss.getMapper(ClienteMapper.class);
        //ItemMapper im = sqlss.getMapper(ItemMapper.class);
        //cm...
        //System.out.println(cm.consultarClientes());
        //cm.agregarItemRentadoACliente(1, 4, Date.valueOf("2020-09-25"), Date.valueOf("2020-09-26"));
        //new SimpleDateFormat("yyyy/MM/dd").parse("2020/09/25");
       //System.out.println(cm.consultarCliente(1));
        //cm.agregarItemRentadoACliente(2, 6, Date.valueOf("2021-08-20"), Date.valueOf("2021-08-26"));
        System.out.println(cm.consultarCliente(2));

        //System.out.println(im.consultarItems());
        //System.out.println(im.consultarItem(1));
        //System.out.println(cm.consultarClientes());
        //System.out.println(cm.consultarCliente(6));
        //cm.agregarItemRentadoACliente(998, 4, Date.valueOf("2021-10-21"), Date.valueOf("2021-10-22"));

        //im.insertarItem(new Item(new TipoItem(2, "Accion"), 12345, "funar o ser funado CR", "descripcion",
                //Date.valueOf("2020-09-25"), 2313, "formato renta", "accion"));
        //System.out.println(im.consultarItem(12345));

        sqlss.commit();
        
        
        sqlss.close();

        
        
    }


}
