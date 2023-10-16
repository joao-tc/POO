package main;

import java.util.ArrayList;

public class Garagem<E> { // Nova classe que armazena Locomotivas e Vagoes
    
    /*Declaracao de variaveis*/
    
        // ArrayLists  principal
        private ArrayList<E> list;

    public Garagem() {
        list = new ArrayList<E>();
    }

    /*Metodos de acesso*/
    public int size() {
        return list.size();
    }

    public void push(E e) {
        list.add(e);
    }

    public E get(int index) {
        return list.get(index);
    }
    /***/
}
