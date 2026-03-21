package edu.unisabana.dyas.patterns.observer.impl;

import edu.unisabana.dyas.patterns.observer.IObservable;
import edu.unisabana.dyas.patterns.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

/*Clase abstracta que implementa la gestión de observers*/
public abstract class AbstractObservable implements IObservable {
    
    private List<IObserver> observers = new ArrayList<>();
    
    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyAllObservers(String property, Object source) {
        for (IObserver observer : observers) {
            observer.notifyChange(property, source);
        }
    }
}