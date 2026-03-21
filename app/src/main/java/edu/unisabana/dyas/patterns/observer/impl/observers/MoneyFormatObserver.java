package edu.unisabana.dyas.patterns.observer.impl.observers;

import edu.unisabana.dyas.patterns.observer.IObserver;
import edu.unisabana.dyas.patterns.observer.impl.ConfigurationManager;

import java.text.NumberFormat;

/*Observer que reacciona a cambios en el formato de dinero*/
public class MoneyFormatObserver implements IObserver {
    
    private String name;
    private double amount;
    
    public MoneyFormatObserver(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
    
    @Override
    public void notifyChange(String property, Object source) {
        // Solo reaccionar si el cambio es en moneyFormat
        if ("moneyFormat".equals(property)) {
            ConfigurationManager config = (ConfigurationManager) source;
            NumberFormat nf = config.getMoneyFormat();
            
            if (nf != null) {
                String formattedMoney = nf.format(amount);
                System.out.println("[" + name + "] 💰 Monto formateado: " + formattedMoney);
            } else {
                System.out.println("[" + name + "] ⚠️ Formato de dinero es null");
            }
        }
    }
}