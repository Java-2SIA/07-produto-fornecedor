package br.fiap.util;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import java.text.DecimalFormat;

public class Util {
    private Fornecedor[] fornecedor = new Fornecedor[3];
    private Produto[] produto = new Produto[3];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    // método para exibir o menu de opcões
    public void menu(){
        int opcao;
        String msg = "1. Cadastrar Produto\n2. Pesquisar produto por nome" +
                "\n3. Pesquisar fornecedor por CNPJ\n4. Finalizar ";

        while (true){
            opcao = parseInt(showInputDialog(msg));
                if (opcao == 4){
                    return;
                }
                    switch (opcao){
                        case 1:
                            cadastrarProduto();
                            break;
                        case 2:
                            pesquisarProduto();
                            break;
                        case 3:
                            pesquisarFornecedor();
                            break;
                        default:
                            showInputDialog(null, "Opção Inválida");
                    }
                }
            }

    private void cadastrarProduto() {
        String nome;
        int qtdEstoque;
        double valorUnitario;
        Fornecedor fornecedor = pesquisarFornecedor();
        if (fornecedor == null){
            fornecedor = cadastrarFornecedor();
        }
        nome = showInputDialog("Nome do produto");
        qtdEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        valorUnitario = parseDouble(showInputDialog("Valor unitário"));
        produto[idxProduto++] = new Produto(nome, qtdEstoque, valorUnitario, fornecedor);
    }

    private Fornecedor cadastrarFornecedor() {
        Fornecedor fornecedor = null;
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor: "));
        String nome = showInputDialog("Nome do fornecedor: ");
        fornecedor = new Fornecedor(nome, cnpj);
        this.fornecedor[idxFornecedor++] = fornecedor;
        return fornecedor;
    }

    private void pesquisar(){
        Fornecedor fornecedor =  pesquisarFornecedor();
        String msg = "";
        if (fornecedor != null){
            msg += "Fornecedor: " + fornecedor.getNome() + "\n";
            msg += "CNPJ: " + fornecedor.getCnpj() + "\n";
            showMessageDialog(null, msg);
        }
    }

    private void pesquisarProduto() {
        DecimalFormat df = new DecimalFormat("0.00");
        String msg = "Produto não cadastrado";
        String nome = showInputDialog("Nome do produto");
        for (int i = 0; i < idxProduto; i++){
            if (produto[i].getNome().equalsIgnoreCase(nome)){
                msg = "";
                msg += "Nome do produto: " + nome + "\n";
                msg += "Valor unitario: " + df.format(produto[i].getValorUnitario()) + "\n";
                msg += "Nome fornecedor: " + produto[i].getFornecedor().getNome() + "\n";
            }
        }
        showInputDialog(null, msg);

    }

    private Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i < idxFornecedor; i++){
           if (fornecedor[i].getCnpj() == cnpj);{
               return fornecedor[i]; // acessando o objeto
            }
        }
        showInputDialog(null, "CNPJ " + cnpj + " não cadastrado");
        return null;
    }

}
