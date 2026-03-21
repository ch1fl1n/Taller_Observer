package edu.unisabana.dyas.patterns.observer;

/*Interfaz para el sujeto observable*/
public interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyAllObservers(String property, Object source);
}