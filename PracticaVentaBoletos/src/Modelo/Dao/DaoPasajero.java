/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

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
public class DaoPasajero extends DaoImplement<Pasajero> {

    private DynamicList<Pasajero> PasajerosLista = new DynamicList<>();
    private Pasajero pasajero;

    public DaoPasajero() {
        super(Pasajero.class);
    }

    public DynamicList<Pasajero> getPasajerosLista() {
        PasajerosLista = all();
        return PasajerosLista;
    }

    public void setPasajerosLista(DynamicList<Pasajero> PasajerosLista) {
        this.PasajerosLista = PasajerosLista;
    }

    public Pasajero getPasajero() {
        if (pasajero == null) {
            pasajero = new Pasajero();
        }
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Boolean Persist() {
        pasajero.setIdPasajero(all().getLength() + 1);
        return Persist(pasajero);
    }
    // ordenar Burbuja
//    public DynamicList<Pasajero> ordenar(DynamicList<Pasajero> lista, Integer tipo, String field) throws EmptyList, Exception {
//        Field attribute = utiles.getField(Pasajero.class, field);
//        Integer n = lista.getLength();
//        Pasajero[] personas = lista.toArray();
//        if (attribute != null) {
//            for (int i = 0; i < n; i++) {
//                int k = i;
//                Pasajero t = personas[i];
//                for (int j = i + 1; j < n; j++) {
////                    if (personas[j].getApellidos().compareTo(t.getApellidos()) < 0) {
//                    if (personas[j].compare(t, field, tipo)) {
//                        t = personas[j];
//                        k = j;
//                    }
//                }
//                personas[k] = personas[i];
//                personas[i] = t;
//            }
//        } else {
//            throw new Exception("No existe el criterio de busqueda");
//        }
//        return lista.toList(personas);
//
//    }
//    public static void main(String[] args) {
//        try {
//            DaoPasajero pc = new DaoPasajero();
//            System.out.println(pc.all().toString());
//            System.out.println("-------");
//            System.out.println(pc.ordenar( pc.all(), 0, "Apellido".toString()));
//                    
//        } catch (Exception e) {
//        }
//    }

    public DynamicList<Pasajero> quicksort(DynamicList<Pasajero> lista, Integer tipo, String field) throws EmptyList, Exception {
        Pasajero[] personas = lista.toArray();
        quicksort(personas, 0, personas.length - 1, tipo, field);
        return lista.toList(personas);
    }

    public static void quicksort(Pasajero[] personas, int izq, int der, Integer tipo, String field) {
        int i = izq;
        int j = der;
        Pasajero pivote = personas[izq];

        while (i <= j) {
            while (compare(personas[i], pivote, tipo, field) < 0) {
                i++;
            }
            while (compare(personas[j], pivote, tipo, field) > 0) {
                j--;
            }
            if (i <= j) {
                Pasajero temp = personas[i];
                personas[i] = personas[j];
                personas[j] = temp;
                i++;
                j--;
            }
        }

        if (izq < j) {
            quicksort(personas, izq, j, tipo, field);
        }
        if (i < der) {
            quicksort(personas, i, der, tipo, field);
        }
    }

    public static int compare(Pasajero p1, Pasajero p2, Integer tipo, String field) {
        int resultado = 0;

        switch (field) {
            case "Apellidos":
                resultado = p1.getApellido().compareTo(p2.getApellido());
                break;
            case "Nombre":
                resultado = p1.getNombre().compareTo(p2.getNombre());
                break;
            case "NumeroIdentificacion":
                resultado = p1.getNumeroIdentificacion().compareTo(p2.getNumeroIdentificacion());
                break;
            default:
                throw new IllegalArgumentException("Campo de comparación no válido: " + field);
        }

        if (resultado == 0) {

            return 0;
        }

        return resultado * tipo;
    }

    public DynamicList<Pasajero> shellsort(DynamicList<Pasajero> lista, Integer tipo, String field) throws EmptyList, Exception {
        Pasajero[] personas = lista.toArray();
        int n = personas.length;

    
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Pasajero temp = personas[i];
                int j = i;
                while (j >= gap && compare(personas[j - gap], temp, tipo, field) > 0) {
                    personas[j] = personas[j - gap];
                    j -= gap;
                }
                personas[j] = temp;
            }
        }

        return lista.toList(personas);
    }

//    public static void main(String[] args) {
//    try {
//        // Suponiendo que DaoPasajero tiene un método 'all' que devuelve DynamicList<Pasajero>
//        DaoPasajero pc = new DaoPasajero();
//        DynamicList<Pasajero> listaOriginal = pc.all();
//
//        System.out.println("Lista original:");
//        System.out.println(listaOriginal.toString());
//
//        System.out.println("-------");
//
//        // Ordenar por apellidos en orden ascendente (tipo 1)
//        Pasajero[] personasAsc = listaOriginal.toArray();
//        quicksort(personasAsc, 0, personasAsc.length - 1, 1, "Apellidos");
//        DynamicList<Pasajero> listaOrdenadaAsc = listaOriginal.toList(personasAsc);
//
//        System.out.println("Lista ordenada por apellidos (ascendente):");
//        System.out.println(listaOrdenadaAsc.toString());
//
//        System.out.println("-------");
//
//        // Ordenar por apellidos en orden descendente (tipo -1)
//        Pasajero[] personasDesc = listaOriginal.toArray();
//        quicksort(personasDesc, 0, personasDesc.length - 1, -1, "Apellidos");
//        DynamicList<Pasajero> listaOrdenadaDesc = listaOriginal.toList(personasDesc);
//
//        System.out.println("Lista ordenada por apellidos (descendente):");
//        System.out.println(listaOrdenadaDesc.toString());
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
}
