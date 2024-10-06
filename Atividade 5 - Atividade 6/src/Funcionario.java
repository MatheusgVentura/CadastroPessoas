public class Funcionario extends Pessoa {
    protected float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    public float calculaImposto() {
        return salario * 0.05f;
    }

    @Override
    public void imprimeDados() {
        System.out.println("\nFuncionário = " + nome + ", \n\t-Imposto = " + calculaImposto() +
                ", \n\t-Salário = " + salario + ", \n\t-Nascimento = " + nascimento);
    }
}
