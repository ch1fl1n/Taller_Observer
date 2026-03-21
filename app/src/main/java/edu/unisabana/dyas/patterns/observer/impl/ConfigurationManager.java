package edu.unisabana.dyas.patterns.observer.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Gestor de configuración - Implementa el patrón Singleton y Observable
 */
public class ConfigurationManager extends AbstractObservable {

    private SimpleDateFormat defaultDateFormat;
    private NumberFormat moneyFormat;
    private Date lastModified;

    private static ConfigurationManager configurationManager;

    /*Constructor privado para Singleton
     * Inicializa con valores por defecto*/
    private ConfigurationManager() {
        // Valores por defecto
        this.defaultDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.moneyFormat = new DecimalFormat("$#,##0.00");
        this.lastModified = new Date();
    }

    /*Obtiene la instancia única (Singleton)*/
    public static ConfigurationManager getInstance() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    // ==================== GETTERS ====================

    public SimpleDateFormat getDefaultDateFormat() {
        return defaultDateFormat;
    }

    public NumberFormat getMoneyFormat() {
        return moneyFormat;
    }

    public Date getLastModified() {
        return lastModified;
    }

    // ==================== SETTERS CON NOTIFICACIÓN ====================

    /*Establece el formato de fecha y notifica a los observers*/
    public void setDefaultDateFormat(SimpleDateFormat defaultDateFormat) {
        String oldPattern = this.defaultDateFormat != null ? this.defaultDateFormat.toPattern() : "null";
        String newPattern = defaultDateFormat != null ? defaultDateFormat.toPattern() : "null";
        
        System.out.println("\n>>> [ConfigurationManager] Cambio de formato de fecha: " 
                + oldPattern + " → " + newPattern);
        
        this.defaultDateFormat = defaultDateFormat;
        this.lastModified = new Date();
        
        // Notificar a todos los observers pasando la propiedad cambiada y la referencia a this
        notifyAllObservers("defaultDateFormat", this);
    }

    /*Establece el formato de dinero y notifica a los observers*/
    public void setMoneyFormat(NumberFormat moneyFormat) {
        System.out.println("\n>>> [ConfigurationManager] Cambio de formato de dinero");
        
        this.moneyFormat = moneyFormat;
        this.lastModified = new Date();
        
        // Notificar a todos los observers
        notifyAllObservers("moneyFormat", this);
    }

    // ==================== MÉTODOS ADICIONALES ====================

    /*Restablece los valores por defecto y notifica*/
    public void resetToDefaults() {
        System.out.println("\n>>> [ConfigurationManager] Restableciendo valores por defecto");
        
        this.defaultDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.moneyFormat = new DecimalFormat("$#,##0.00");
        this.lastModified = new Date();
        
        // Notificar ambos cambios
        notifyAllObservers("defaultDateFormat", this);
        notifyAllObservers("moneyFormat", this);
    }

    /*Muestra el estado actual de la configuración*/
    public void printCurrentConfig() {
        System.out.println("\n--- Estado Actual de Configuración ---");
        System.out.println("Formato de fecha: " + 
                (defaultDateFormat != null ? defaultDateFormat.toPattern() : "null"));
        System.out.println("Formato de dinero: " + 
                (moneyFormat != null ? moneyFormat.format(1234.56) : "null"));
        System.out.println("Última modificación: " + lastModified);
        System.out.println("--------------------------------------\n");
    }
}