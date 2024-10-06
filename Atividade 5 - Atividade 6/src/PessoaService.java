public class PessoaService {
    private Pessoa[] pessoas;
    private int quantidadeAtual;
    private int contadorGerente = 0;
    private int contadorFuncionario = 0;

    public PessoaService(int capacidade) {
        pessoas = new Pessoa[capacidade];
        quantidadeAtual = 0;
    }

    public void cadastraPessoa(Pessoa pessoa) throws QuantidadeExcedidaException {
        if (pessoa instanceof Gerente && contadorGerente >= 1) {
            throw new QuantidadeExcedidaException("Quantidade máxima de gerentes excedida.");
        } else if (pessoa instanceof Funcionario && !(pessoa instanceof Gerente) && contadorFuncionario >= 7) {
            throw new QuantidadeExcedidaException("Quantidade máxima de funcionários excedida.");
        }

        if (quantidadeAtual < pessoas.length) {
            pessoas[quantidadeAtual] = pessoa;
            quantidadeAtual++;

            if (pessoa instanceof Gerente) {
                contadorGerente++;
            } else if (pessoa instanceof Funcionario) {
                contadorFuncionario++;
            }
        } else {
            throw new QuantidadeExcedidaException("Cadastro cheio.");
        }
    }

    public void imprimeCadastro() {
        for (int i = 0; i < quantidadeAtual; i++) {
            pessoas[i].imprimeDados();
        }
    }
}