package calculadora;

import javax.swing.JOptionPane;

/**
 * @author Gonzalo Diaz
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Suma sum = new Suma();
        Multiplicacion mul = new Multiplicacion();
        Division div = new Division();
        double num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero 1"));
        double num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero 2"));
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Operacion: \n1. Suma\n2. Division\n3. Multiplicacion"));
        switch (opcion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Suma: " + sum.suma(num1,num2));

                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Division: " + div.division(num1,num2));

                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Multiplicacion: " + mul.multiplicacion(num1, num2));

                break;
        }
    }

}
