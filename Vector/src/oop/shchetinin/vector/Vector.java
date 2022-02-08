package oop.shchetinin.vector;

public class Vector {
    private double n;

    public Vector (double n){
       if(n <=0) {
           throw new IllegalArgumentException("Размерность вектора меньше либо равна нулю");
       }

        this.n = n;
    }

    public Vector(Vector vector){

    }

    public Vector(double[] array){

    }

    public Vector(double n, double[] array){

    }

    public double getSize(){
        return n;
    }

    @Override
    public String toString(){
        return "(" + n + ")";
    }
}
