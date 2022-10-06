public abstract class Cuenta {
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular = new Cliente();

    private static int total = 0;

    public Cuenta() {

    }

    public Cuenta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
        System.out.println("Estoy creando una cuenta");

        Cuenta.total++;
    }
    /* public Cuenta(int agencia) {
        if (agencia <= 0) {
            System.out.println("No se permite 0.");
            this.agencia = 1;
        } else {
            this.agencia = agencia;
        }
        total++;

        System.out.println("Se han creado "
                + total + " cuentas.");
    }*/

    // Este método no retorna ningún valor
    // (por eso usamos "void").
    public abstract void depositar(double valor);

    /*
    public boolean saca(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
   */

    // Este método nos retorna un valor booleano.
    public void retirar(double valor) throws SaldoInsuficienteException {
        if(this.saldo < valor) {
            throw new SaldoInsuficienteException("No tiene saldo");
        }
        this.saldo -= valor;
    }

    public boolean transferir(double valor, Cuenta cuenta) {
        if (this.saldo >= valor) {
            try {
                this.retirar(valor);
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
                //throw new RuntimeException(e);
            }
            cuenta.depositar(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public static int getTotal() {
        return Cuenta.total;
    }
}