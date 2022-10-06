public class Gerente extends Funcionario implements Autenticable {

    public double getBonificacion() {
        System.out.println("Ejecutando desde gerente");
        //return super.getSalario() + this.getSalario() * 0.05;
        return 2000;
    }

    @Override
    public void setClave(String clave) {

    }

    @Override
    public boolean iniciarSesion(String clave) {
        return false;
    }
}
