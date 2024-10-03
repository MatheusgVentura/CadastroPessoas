public class Gerente extends Funcionario {
    private String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    @Override
    public float calculaImposto() {
        return salario * 0.05f;
    }

    @Override
    public void imprimeDados() {
        System.out.println("\nGerente = " + nome + ", \n\t-Área = " + area + ", \n\t-Salário = " + salario +
                ", \n\t-Imposto = " + calculaImposto() + ", \n\t-Nascimento = " + nascimento);
    }
}
