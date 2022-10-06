public class Contador extends Funcionario {

    @Override
    public double getBonificacion() {
        System.out.println("Ejecutando desde contador");
        return 200;
    }
}
