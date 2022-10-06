public class TestCuentaExceptionSaldo {
    public static void main(String[] args) {
        Cuenta cuenta = new CuentaAhorros(123, 456);
        cuenta.depositar(210);
        try {
            cuenta.retirar(200);
            cuenta.retirar(10);
        } catch (SaldoInsuficienteException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
