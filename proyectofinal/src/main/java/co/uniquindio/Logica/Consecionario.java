package co.uniquindio.Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Consecionario {

    private static Consecionario consecionario;
    private static ArrayList<Cliente> clientes;
    private static Map<String, Administrador> administradores;
    private static Map<String, PersonaComponent> empleados;

    private Consecionario() {
        clientes = new ArrayList<>();
        administradores = new HashMap<>();
        empleados = new HashMap<>();
    }

    public static Map<String, PersonaComponent> getEmpleados() {
        return empleados;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static Map<String, Administrador> getAdministradores() {
        return administradores;
    }

    public static boolean validarUser(User user) {
        boolean centinela = false;
        int i = 0;
        while (i < clientes.size() && !centinela) {
            Cliente cliente = clientes.get(i);
            if (cliente.getUser().getUsuario().equals(user.getUsuario())
                    && cliente.getUser().getContraseña().equals(user.getContraseña())) {
                centinela = true;
            }
            i++;
        }
        return centinela;
    }

    public static synchronized Consecionario getConsecionario() {
        if (consecionario == null) {
            consecionario = new Consecionario();

        }

        return consecionario;
    }

    public static void agregarCliente(String nombre, String apellido, LocalDate date, String id, User user) {
        Cliente cliente = Cliente.builder().Apellido(apellido).Date(date).Id(id).nombre(nombre).user(user).build();
        if (validarCliente(cliente) == false) {
            clientes.add(cliente);
        }

    }

    public void agergarAdmin(String nombre, String apellido, LocalDate date, String id) {
        Administrador administrador = Administrador.builder().apellido(apellido).date(date).id(id).nombre(nombre)
                .build();
        if (administradores.size() == 0) {
            administradores.put(id, administrador);
        }

    }

    public void eliminiarClienet(String id) {
        administradores.remove(administradores.get(id));
    }

    public static boolean validarCliente(Cliente cliente) {

        boolean centinela = false;
        if (clientes.contains(cliente)) {
            centinela = true;
        }

        return centinela;
    }

}
