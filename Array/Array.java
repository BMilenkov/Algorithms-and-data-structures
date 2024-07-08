package Array;

import java.util.Arrays;

public class Array<E>{
    private E[] data;
    private int size;
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = capacity;
    }
    public void set(int position, E o){
        if (position >= 0 && position <= size)
            data[position] = o;
        else
            System.out.println("Nemoze da se vmetne nisto na taa pozicija!!!");
    }
    public void insertLast(E o){
        if(size + 1 > data.length)
            this.resize();
            data[size++] = o;
        }
    public void insert(int position, E o) {
        if (position >= 0 && position <= size) {
            if(size + 1 > data.length)
                this.resize();
            for (int i = size; i > position; i--) {
                data[i] = data[i-1];
            }
            this.data[position] = o;
            size++;
        }
        else{
            System.out.println("Nemoze da se vmetne nisto na taa pozicija!!!");
        }
    }
    public E get(int position){
        if (position >= 0 && position <= size)
            return data[position];
        else
            System.out.println("Ne e valdina vnesenata pozicija!");
        return null;
    }
    public int getSize(){
        return size;
    }
    public int find(E o){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }
    public void delete(int position){
        if(position >=0 && position < size){
            E [] new_data = (E[]) new Object[size-1];
            for (int i = 0; i < position; i++) {
                new_data[i] = data[i];
            }
            for (int i = position + 1; i < size; i++) {
                new_data[i-1] = data[i];
            }
            data = new_data;
            size--;
        }
    }
    public void resize(){
        E [] new_data = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            new_data[i] = data[i];
        }
        this.data = new_data;
    }

    @Override
    public String toString() {
        return  Arrays.toString(data);
    }

    public static void main(String[] args) {
        Array<String> my_array = new Array<String>(3);
        my_array.set(0,"A");
        my_array.set(1,"B");
        my_array.set(2,"C");
        System.out.println("Nizata e: " + my_array);
        my_array.insertLast("D");
        System.out.println("Nizata e: " + my_array);
        my_array.insertLast("E");
        System.out.println("Nizata e: " + my_array);
        my_array.insertLast("F");
        System.out.println("Nizata e: " + my_array);
        System.out.println(my_array.getSize());
        my_array.insert(2,"INSERT");
        System.out.println(my_array.getSize());
        System.out.println("Nizata e: " + my_array);
        System.out.println(my_array.get(4));
        System.out.println(my_array.find("INSERT"));
        System.out.println(my_array.find("L"));
        my_array.delete(3);
        System.out.println("Nizata e: " + my_array);
    }
}
