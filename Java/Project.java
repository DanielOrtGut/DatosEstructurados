import java.util.ArrayList;
import java.util.Scanner;

public class Project {

    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("DISCO SSD 1TB", "SSD", 200000));
        listaProductos.add(new Producto("DISCO HDD 1TB", "HDD", 100000));

        ArrayList<ProductoCarrito> carrito = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            int opcion = 0;
            while (opcion != 5) {
                System.out.println("Bienvenido a la tienda de memorias de almacenamiento");
                System.out.println("Por favor seleccione una opción:");
                System.out.println("1. Ver lista de productos disponibles");
                System.out.println("2. Agregar productos al carrito");
                System.out.println("3. Ver contenido del carrito");
                System.out.println("4. Realizar compra");
                System.out.println("5. Salir");

                opcion = sc.nextInt();

                if (opcion == 1) {
                    System.out.println("Productos disponibles:");
                    for (Producto p : listaProductos) {
                        System.out.println(p.getNombre() + " - " + p.getTipo() + " - $" + p.getPrecio());
                    }
                } else if (opcion == 2) {
                    System.out.println("Por favor seleccione un tipo de disco:");
                    System.out.println("1. SSD");
                    System.out.println("2. HDD");

                    int tipoDisco = sc.nextInt();
                    int cantidad;

                    if (tipoDisco == 1) {
                        System.out.println("Por favor ingrese la cantidad de discos SSD que desea comprar:");
                        cantidad = sc.nextInt();
                        carrito.add(new ProductoCarrito("DISCO SSD 1TB", "SSD", cantidad));
                    } else if (tipoDisco == 2) {
                        System.out.println("Por favor ingrese la cantidad de discos HDD que desea comprar:");
                        cantidad = sc.nextInt();
                        carrito.add(new ProductoCarrito("DISCO HDD 1TB", "HDD", cantidad));
                    } else {
                        System.out.println("Opción inválida");
                    }
                } else if (opcion == 3) {
                    if (carrito.isEmpty()) {
                        System.out.println("El carrito está vacío");
                    } else {
                        System.out.println("Contenido del carrito:");
                        for (ProductoCarrito pc : carrito) {
                            System.out.println(pc.getNombre() + " - " + pc.getTipo() + " - " + pc.getCantidad());
                        }
                    }
                } else if (opcion == 4) {
                    if (carrito.isEmpty()) {
                        System.out.println("El carrito está vacío");
                    } else {
                        for (ProductoCarrito pc : carrito) {
                            System.out.println(pc.getNombre() + " - " + pc.getTipo() + " - " + pc.getCantidad());
                        }
                        System.out.println("COMPRA EXITOSA");
                    }
                } else if (opcion == 5) {
                    System.out.println("Gracias por visitar la tienda de memorias de almacenamiento");
                    System.exit(0);
                } else {
                    System.out.println("Opción inválida");
                }
            }
        }
    }
}

class Producto {
    private String nombre;
    private String tipo;
    private double precio;

    public Producto(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}

class ProductoCarrito {
    private String nombre;
    private String tipo;
    private int cantidad;

    public ProductoCarrito(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }
}
