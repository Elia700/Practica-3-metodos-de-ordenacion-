/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import Controlador.TDA.Lista.DynamicList;
import Controlador.TDA.Lista.Exepciones.EmptyList;
import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Elias
 * @param <T>
 */
public class DaoImplement<T> implements DaoInterface<T> {

    private Class<T> clazz;
    private XStream conection;
    private String URL;

    public DaoImplement(Class<T> clazz) {
        this.clazz = clazz;
        conection = Bridge.getConection();
        URL = Bridge.URL + clazz.getSimpleName() + ".json";
    }

    @Override
    public DynamicList<T> all() {
        DynamicList<T> dl = new DynamicList<>();
        try {
            dl = (DynamicList<T>) conection.fromXML(new FileReader(URL));
        } catch (Exception e) {
        }
        return dl;
    }
     @Override
    public T get(Integer id) {
        return null;
    }

    @Override
    public Boolean Persist(T data) {
        DynamicList<T> ld = all();
        ld.add(data);
        try {
            this.conection.toXML(ld, new FileWriter(URL));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean Merge(T data, Integer index) {
       DynamicList<T> dl = all();
        try {
            dl.getgetNode(index).setInfo(data);
        } catch (EmptyList ex) {
            System.out.println(ex.getMessage());
        }
        try {
            this.conection.toXML(dl, new FileWriter(URL));
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}