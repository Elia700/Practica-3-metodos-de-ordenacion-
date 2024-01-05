/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import Controlador.TDA.Lista.DynamicList;

/**
 *
 * @author Elias
 */
public interface DaoInterface<T> {

    public Boolean Persist(T dato);

    public Boolean Merge(T data, Integer index);

    public DynamicList<T> all();

    public T get(Integer id);

}
