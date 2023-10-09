package org.df;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EmpleadoManager empleadoManager = new EmpleadoManager();

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
                    EmpleadoManager.agregarEmpleado();
                    break;
                case 2:
                    EmpleadoManager.editarEmpleado();
                    break;
                case 3:
                    EmpleadoManager.eliminarEmpleado();
                    break;
                case 4:
                    EmpleadoManager.mostrarEmpleadosYSalarios();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 5);
    }
}
