package co.uniquindio.Logica;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class Consecionario {

    private static Consecionario consecionario;
    private static Map<String, Cliente> clientes;
    private Map<String, AdministradorBuilder> administradores;

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    private Consecionario() {
        clientes = new HashMap<>();
        administradores = new HashMap<>();
    }

    public static synchronized Consecionario getConsecionario() {
        if (consecionario == null) {
            consecionario = new Consecionario();

        }

        return consecionario;
    }

    public static void agregarCliente(String nombre, String apellido, LocalDate date, String id) {
        Cliente cliente = Cliente.builder().Apellido(apellido).Date(date).Id(id).nombre(nombre).build();
        if (validarCliente(cliente) == false) {
            clientes.put(id, cliente);
        }

    }

    public void agergarAdmin(String nombre, String apellido, LocalDate date, String id, User user) {
        AdministradorBuilder administradorBuilder = new AdministradorBuilder().apellido(apellido).date(date).id(id)
                .nombre(nombre).user(user);
        if (validarAdmin(administradorBuilder) == false) {
            administradores.put(id, administradorBuilder);
        }

    }

    public static boolean validarCliente(Cliente cliente) {

        String id = cliente.getId();
        boolean centinela = false;
        if (clientes.containsKey(id)) {
            centinela = true;
        }

        return centinela;
    }

    public boolean validarAdmin(AdministradorBuilder admin) {
        String id = admin.getId();
        boolean centinela = false;
        if (administradores.containsKey(id)) {
            centinela = true;
        }

        return centinela;
    }

}
