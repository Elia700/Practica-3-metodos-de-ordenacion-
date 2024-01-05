/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Lista.Exepciones.EmptyList;
import Controlador.TDA.Lista.DynamicList;
import Controlador.Utiles.utiles;
import Modelo.Pasajero;
import java.lang.reflect.Field;

/**
 *
 * @author Elias
 */
public class ControladorPasajero extends DaoImplement<Pasajero> {

    private DynamicList<Pasajero> ListaPasajeros;
    private Pasajero pasajeroControl;

    public ControladorPasajero() {
        super(Pasajero.class);

    }
    
    
   public Boolean Guardar() {
        Integer pos = VerificarPosicion();
        if (pos > -1) {
            pasajeroControl.setIdPasajero(pos + 1);
            ListaPasajeros.getHeader();
            return true;
        } else {
            return false;
        }
    }

    public Integer VerificarPosicion() {

        Integer band = -1;

        for (int i = 0; i < this.ListaPasajeros.getLength(); i++) {
            if (this.ListaPasajeros.getLength()== null) {
                band = i;
                break;
            } else {
                band = 1;
            }
        }
        return band;
    }

    public void Imprimir() {
        for (int i = 0; i > this.getListaPasajeros().getLength(); i++) {
            System.out.println(getListaPasajeros().getLength());
        }
    }

    public DynamicList<Pasajero> getListaPasajeros() {
        return ListaPasajeros;
    }

    public void setListaPasajeros(DynamicList<Pasajero> ListaPasajeros) {
        this.ListaPasajeros = ListaPasajeros;
    }

    public Pasajero getPasajeroControl() {
        if (pasajeroControl == null) {
            pasajeroControl = new Pasajero();
        }
        return pasajeroControl;
    }
}