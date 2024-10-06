public class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, Data nascimento, float salario, String departamento) {
        super(nome, nascimento, salario);
        this.departamento = departamento;
    }

    @Override
    public void imprimeDados() {
        System.out.println("\nGerente = " + nome + ", \n\t-Departamento = " + departamento + ", \n\t-Salário = " + salario + ", \n\t-Nascimento = " + nascimento);
    }
}
