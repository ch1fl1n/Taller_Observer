package edu.unisabana.dyas.patterns.observer.impl.observers;

import edu.unisabana.dyas.patterns.observer.IObserver;
import edu.unisabana.dyas.patterns.observer.impl.ConfigurationManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/*Observer que reacciona a cambios en el formato de fecha*/
public class DateFormatObserver implements IObserver {
    
    private String name;
    
    public DateFormatObserver(String name) {
        this.name = name;
    }
    
    @Override
    public void notifyChange(String property, Object source) {
        // Solo reaccionar si el cambio es en defaultDateFormat
        if ("defaultDateFormat".equals(property)) {
            ConfigurationManager config = (ConfigurationManager) source;
            SimpleDateFormat sdf = config.getDefaultDateFormat();
            
            if (sdf != null) {
                String formattedDate = sdf.format(new Date());
                System.out.println("[" + name + "] 📅 Fecha formateada: " + formattedDate);
                System.out.println("[" + name + "]    Patrón usado: " + sdf.toPattern());
            } else {
                System.out.println("[" + name + "] ⚠️ Formato de fecha es null");
            }
        }
    }
}