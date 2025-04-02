package br.fiap.util;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

public class Util {
    private Fornecedor[] fornecedor = new Fornecedor[3];
    private Produto[] produto = new Produto[3];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    // método para exibir o menu de opcões
    public void menu(){
        int opcao;
        String msg = "1. Cadastrar Produto\n2. Pesquisar produto por nome" +
                "3. Pesquisar fornecedor por CNPJ\n Finalizar ";

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

    }

    private void pesquisarProduto() {
    }

    private Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i < idxFornecedor; i++){
           if (fornecedor[i].getCnpj() == cnpj);{
               return fornecedor[i]; // acessando o objeto
            }
        }
        showInputDialog(null, "CNPJ" + cnpj + "não cadastrado");
        return null;
    }

}
