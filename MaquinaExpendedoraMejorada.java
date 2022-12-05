public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private int numeroBilletesVendidos;
    // El Máximo de Billetes que se puede comprar
    private int cantidadMaximaBilletes;
    // Billetes Vendidos
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El premio del billete
    private boolean venderPremioBillete;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino,boolean venderBilletePremio, int cantidadMaximaBillete) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        venderPremioBillete = venderBilletePremio;
        cantidadMaximaBilletes = cantidadMaximaBillete;
    }

    /**
     * Nuevo Constructor
     */
    public MaquinaExpendedoraMejorada(boolean venderBilletePremio, int cantidadMaximaBillete) {
        precioBillete = 20;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Leon";
        estacionDestino = "Zamora";
        numeroBilletesVendidos = 0;
        venderPremioBillete = venderBilletePremio;
        cantidadMaximaBilletes = cantidadMaximaBillete;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroBilletesVendidos == cantidadMaximaBilletes) {
            System.out.println("No quedan Billetes para comprar.");
        }
        else {
            if (cantidadIntroducida >= 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        int descuentoDeBillete = (precioBillete * 25) /100;
        if (numeroBilletesVendidos < cantidadMaximaBilletes)
            if (cantidadDeDineroQueFalta <= 0) {
                if (venderPremioBillete == true) {
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println("Has conseguido un descuento de " + descuentoDeBillete + " euros en tu billete");

                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    //Calcula en numero de billetes vendidos
                    numeroBilletesVendidos = numeroBilletesVendidos + 1;
                }
                else {
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();         

                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    //Calcula en numero de billetes vendidos
                    numeroBilletesVendidos = numeroBilletesVendidos + 1;

                }
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");

                // Guarda la cantidad de dinero que falta para completar el precio del billete

            }
        else {
            System.out.println("Has llegado al Número Máximo de Billetes");

            // Número Maximo de Billetes

        }  
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }

    /**
     * Devuelve el número de Billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }

    /**
     * Imprime el número de Billetes vendidos
     */
    public void imprimirNumeroBilletesVendidos() {
        System.out.println("Numero de billetes vendidos " + numeroBilletesVendidos);
    }

    /**
     * Vacia el dinero introducido a la Maquina
     */
    public int vaciarDineroDeLaMaquina() {
        int vaciarDineroDeLaMaquina;
        if (balanceClienteActual == 0) {
            vaciarDineroDeLaMaquina = totalDineroAcumulado + balanceClienteActual;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            vaciarDineroDeLaMaquina = -1;
            System.out.println ("Error al vaciar la máquina. La máquina sigue cobrando el dinero");
        }
        return vaciarDineroDeLaMaquina;
    }
}