package Modelo.Dao;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Lista.DynamicList;
import Modelo.Boleto;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elias
 */
public class DaoBoleto extends DaoImplement<Boleto>{
    private DynamicList<Boleto> BoletosLista = new DynamicList<>();
    private Boleto boletos;
    
    public DaoBoleto(){
        super (Boleto.class);
    }

    public DynamicList<Boleto> getBoletosLista() {
        BoletosLista = all();
        return BoletosLista;
    }

    public void setBoletosLista(DynamicList<Boleto> BoletosLista) {
        this.BoletosLista = BoletosLista;
    }

    public Boleto getBoletos() {
        if(boletos == null){
            boletos = new Boleto();
        }
        return boletos;
    }

    public void setBoletos(Boleto boletos) {
        this.boletos = boletos;
    }
    
    public Boolean Persist(){
        boletos.setIdBoleto(all().getLength()+1);
        return Persist(boletos);
    }
}
