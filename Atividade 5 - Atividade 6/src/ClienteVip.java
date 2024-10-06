public class ClienteVip extends Cliente {
    private float percentualDesconto;

    public ClienteVip(String nome, Data nascimento, int codigo, float percentualDesconto) {
        super(nome, nascimento, codigo);
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public void imprimeDados() {
        System.out.println("\nCliente VIP = " + nome + ", \n\t-Código = " + codigo + ", \n\t-Nascimento = " + nascimento + ", \n\t-Desconto = " + percentualDesconto + "%");
    }
}