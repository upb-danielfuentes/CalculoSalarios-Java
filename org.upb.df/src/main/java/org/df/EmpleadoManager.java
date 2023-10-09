package org.df;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoManager {
    private static final List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seleccione una opción:\n" +
                            "1. Agregar Empleado\n" +
                            "2. Editar Empleado\n" +
                            "3. Eliminar Empleado\n" +
                            "4. Mostrar Empleados y Salarios\n" +
                            "5. Salir"
            ));

            switch (opcion) {
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    editarEmpleado();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    mostrarEmpleadosYSalarios();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarEmpleado() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        float horasSemana = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad de horas que trabaja en la semana:"));
        float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la hora:"));

        Empleado empleado = new Empleado(nombre, horasSemana, valorHora);
        empleados.add(empleado);
        JOptionPane.showMessageDialog(null, "Empleado agregado con éxito.");
    }

    public static void editarEmpleado() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        } else {
            int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del empleado que desea editar:")) - 1;
            if (indice >= 0 && indice < empleados.size()) {
                Empleado empleado = empleados.get(indice);
                String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del empleado:");
                float horasSemana = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la nueva cantidad de horas que trabaja en la semana:"));
                float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo valor de la hora:"));

                empleado.setNombre(nombre);
                empleado.setHorasSemana(horasSemana);
                empleado.setValorHora(valorHora);

                JOptionPane.showMessageDialog(null, "Empleado editado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Número de empleado no válido.");
            }
        }
    }

    public static void eliminarEmpleado() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        } else {
            int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del empleado que desea eliminar:")) - 1;
            if (indice >= 0 && indice < empleados.size()) {
                Empleado empleado = empleados.remove(indice);
                JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito: " + empleado.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "Número de empleado no válido.");
            }
        }
    }

    public static void mostrarEmpleadosYSalarios() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        } else {
            StringBuilder resultado = new StringBuilder("Empleados y Salarios:\n");
            for (int i = 0; i < empleados.size(); i++) {
                Empleado empleado = empleados.get(i);
                resultado.append("Empleado ").append(i + 1).append(": ")
                        .append("Nombre: ").append(empleado.getNombre())
                        .append(", Salario Mensual: COP ").append(empleado.getSalarioMensual())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, resultado.toString());
        }
    }
}