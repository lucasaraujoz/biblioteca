package Servico;
import Entidade.Livro;
import Entidade.Usuario;
import jdk.jfr.Name;

import java.util.ArrayList;

public class Acervo {
    ArrayList<Usuario> usuarios;
    ArrayList<Livro> livros;
    
    public Acervo() {
        livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    /***
     * adiciona livro por string no acervo do objeto
     * @param nome eh o nome livro
     * @return n sei pra q esse retorno funciona, podia ser void
     */
    public Livro adicionarLivro(String nome){
        Livro liv = new Livro(nome);
        livros.add(liv);
        return liv; // ?
    }

    /***
     * recebe tipo livro e adiciona o objeto livro no arraylist livros do acerbo
     * @param livro tem q ser do tipo livro
     */
    public void devolverLivro(Livro livro){
        livros.add(livro);
    }

    public void novoUsuario(String nome){
        Usuario user = new Usuario(nome);
        usuarios.add(user);
    }
    public void menu(){
        System.out.println("----------MENU---------");
        System.out.println("----------ADM----------");
        System.out.println("1 - NOVO USUARIO");
        System.out.println("2 - NOVO LIVRO");
        System.out.println("----------USUARIO------");
        System.out.println("3 - LIVROS DISPONIVEIS");
        System.out.println("4 - EMPRESTAR LIVRO...");
        System.out.println("5 - DEVOLVER LIVRO....");
        System.out.println("6 - PERFIL USUARIO....");
        System.out.println("------------------------");
    }

    /***
     * imprime no console todos os usuarios da arraylist usuarios desse acervo
     */
    public void mostrarUsuarios(){
        int contador = 0;
        for(var c:usuarios){
            System.out.println(contador + " - "+ c.getNome());
            contador++;
        }
    }
    public void mostrarLivrosAcervo(){
        int contador=0;
        for(Livro l: livros){
            System.out.println(contador + " - " + l.getNome());
            contador++;
        }
    }

    public void addLivroUsuario(Usuario user, Livro livro){
        user.addLivroUser(livro);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    @Override
    public String toString() {
        return "Acervo{" +
                "usuarios=" + usuarios +
                ", livros=" + livros +
                '}';
    }
}
