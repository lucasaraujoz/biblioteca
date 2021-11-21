import Entidade.Usuario;
import Servico.Acervo;
import Entidade.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Acervo bibliotecaPf = new Acervo();
        bibliotecaPf.adicionarLivro("Duna");
        bibliotecaPf.adicionarLivro("1984");
        bibliotecaPf.adicionarLivro("A batalha do apocalipse");
        bibliotecaPf.adicionarLivro("Harry Potter e o calice de fogo");
        bibliotecaPf.adicionarLivro("Coraline");
        bibliotecaPf.adicionarLivro("5 minutos depois da meia noite");
        bibliotecaPf.adicionarLivro("O homem de giz");
        bibliotecaPf.novoUsuario("Bob");
        bibliotecaPf.novoUsuario("Raul");
        bibliotecaPf.novoUsuario("Peter Park");

        Scanner input = new Scanner(System.in);
        int op = -1, select=-1;
        String nome;
        Usuario conta;
        //conectar usuario
        System.out.println("Selecione um usuario pra se conectar");
        bibliotecaPf.mostrarUsuarios();
        select = input.nextInt();
        conta = bibliotecaPf.getUsuarios().get(select);
        System.out.println(conta.getNome() + " online.");

        while(op!=999){
            bibliotecaPf.menu();
            op = input.nextInt();
            switch (op){
                case 1:
                    //ADICIONAR NOVO USUARIO
                    System.out.println("Insira o nome do novo usuario:");
                    nome = input.next();
                    bibliotecaPf.novoUsuario(nome);
                    break;
                case 2:
                    //ADICIONAR NOVO LIVRO
                    System.out.println("Insira o nome do novo livro:");
                    nome = input.next();
                    bibliotecaPf.adicionarLivro(nome);
                    break;
                case 3:
                    // LIVROS DISPONIVEIS
                    bibliotecaPf.mostrarLivrosAcervo();
                    break;
                case 4:
                    //EMPRESTAR LIVRO PRA USUARIO
                    bibliotecaPf.mostrarLivrosAcervo();
                    System.out.println("Escolha o livro:");
                    op = input.nextInt();
                    Livro livro = bibliotecaPf.getLivros().get(op);
                    bibliotecaPf.addLivroUsuario(conta, livro);
                    bibliotecaPf.getLivros().remove(livro); // remove o livro do acervo
                    break;
                case 5:
                    // DEVOLVE LIVRO Q ESTA COM USUARIO PRO ACERVO
                    conta.mostrarLivrosUsers();
                    System.out.println("Escolha o livro:");
                    op = input.nextInt();
                    livro = conta.getLivros().get(op);
                    bibliotecaPf.devolverLivro(livro);
                    conta.getLivros().remove(livro); // remove o livro do usuario
                    break;
                case 6:
                    // mostra o perfil do usuario e livros q ele pegou
                    System.out.println(conta.getNome() + "----------------");
                    System.out.println("Livros alugados:");
                    System.out.println("------------------------");
                    conta.mostrarLivrosUsers();
                    System.out.println("------------------------");
                    break;
            }
        }
    }
}
