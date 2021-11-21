package Entidade;

import Servico.Acervo;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Livro> livros;


    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Usuario(String nome) {
        this.nome = nome;
        livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostrarLivrosUsers(){
        int contador=0;
        for(Livro l:livros){
            System.out.println(contador + " - " + l.getNome());
            contador++;
        }
    }
    public void addLivroUser(Livro livro){
        livros.add(livro);
    }
}
