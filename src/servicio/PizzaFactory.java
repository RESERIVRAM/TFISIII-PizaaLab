package servicio;

import modelo.*;

public class PizzaFactory {
    public Pizza crearPizza(String tipo, String tamanio, String tipoMasa) {
        switch (tipo.toLowerCase()) {
            case "americana":
                return new Americana(tamanio, tipoMasa);
            case "hawaiana":
                return new Hawaiana(tamanio, tipoMasa);
            case "mozzarella":
                return new Mozzarella(tamanio, tipoMasa);
            case "margarita":
                return new Margarita(tamanio, tipoMasa);
            default:
                throw new IllegalArgumentException("Tipo de pizza no válido: " + tipo);
        }
    }
}

/*Clase PizzaFactory que implementa el patron Factory para crear objetos Pizza segun el tipo solicitado.
Recibe el tipo de pizza, tamaño y tipo de masa como parámetros y devuelve la instancia correspondiente.
Centraliza la creación de objetos Pizza, simplificando la instanciacion y manteniendo el codigo desacoplado.
Lanza una excepcion si se solicita un tipo de pizza no soportado.*/