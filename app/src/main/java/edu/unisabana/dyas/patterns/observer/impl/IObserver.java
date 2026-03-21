package edu.unisabana.dyas.patterns.observer;

/*Interfaz para los observadores*/
public interface IObserver {
    void notifyChange(String property, Object source);
}