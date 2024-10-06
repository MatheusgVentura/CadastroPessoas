import java.util.Scanner;

public class TestaCadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService(10);

        try {
            cadastraPessoa(scanner, pessoaService, "Cliente");
            cadastraPessoa(scanner, pessoaService, "Funcionário");
            cadastraPessoa(scanner, pessoaService, "Gerente");
            cadastraPessoa(scanner, pessoaService, "Cliente VIP");
        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        pessoaService.imprimeCadastro();
        scanner.close();
    }

    private static void cadastraPessoa(Scanner scanner, PessoaService pessoaService, String tipoPessoa) throws QuantidadeExcedidaException {
        System.out.println("\nCadastro de " + tipoPessoa + ":");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (dd mm aaaa): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        Data data = new Data(dia, mes, ano);

        switch (tipoPessoa) {
            case "Cliente":
                System.out.print("Número de Cadastro: ");
                int numeroCadastro = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha
                Cliente cliente = new Cliente(nome, data, numeroCadastro);
                pessoaService.cadastraPessoa(cliente);
                break;
            case "Cliente VIP":
                System.out.print("Número de Cadastro: ");
                int codigoVip = scanner.nextInt();
                System.out.print("Percentual de Desconto: ");
                float percentualDesconto = scanner.nextFloat();
                scanner.nextLine(); // Consumir nova linha
                ClienteVip clienteVip = new ClienteVip(nome, data, codigoVip, percentualDesconto);
                pessoaService.cadastraPessoa(clienteVip);
                break;
            case "Funcionário":
                System.out.print("Salário: ");
                float salarioFuncionario = scanner.nextFloat();
                scanner.nextLine(); // Consumir nova linha
                Funcionario funcionario = new Funcionario(nome, data, salarioFuncionario);
                pessoaService.cadastraPessoa(funcionario);
                break;
            case "Gerente":
                System.out.print("Salário: ");
                float salarioGerente = scanner.nextFloat();
                scanner.nextLine(); // Consumir nova linha
                System.out.print("Departamento: ");
                String departamento = scanner.nextLine();
                Gerente gerente = new Gerente(nome, data, salarioGerente, departamento);
                pessoaService.cadastraPessoa(gerente);
                break;
        }
    }
}