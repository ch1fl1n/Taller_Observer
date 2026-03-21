package edu.unisabana.dyas.patterns.observer.impl;

import edu.unisabana.dyas.patterns.observer.impl.observers.DateFormatObserver;
import edu.unisabana.dyas.patterns.observer.impl.observers.MoneyFormatObserver;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/*Clase principal para probar el patrón Observer*/
public class ObserverMain {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   PATRÓN OBSERVER - CONFIGURACIÓN");
        System.out.println("========================================\n");
        
        // Obtener la instancia del ConfigurationManager (Singleton)
        ConfigurationManager config = ConfigurationManager.getInstance();
        
        // Crear observers
        DateFormatObserver dateObserver1 = new DateFormatObserver("DateObserver-1");
        DateFormatObserver dateObserver2 = new DateFormatObserver("DateObserver-2");
        MoneyFormatObserver moneyObserver1 = new MoneyFormatObserver("MoneyObserver-1", 1500.50);
        MoneyFormatObserver moneyObserver2 = new MoneyFormatObserver("MoneyObserver-2", 999999.99);
        
        System.out.println("--- Registrando observers ---");
        
        // Registrar observers al observable
        config.addObserver(dateObserver1);
        config.addObserver(dateObserver2);
        config.addObserver(moneyObserver1);
        config.addObserver(moneyObserver2);
        
        System.out.println("Observers registrados: 4\n");
        
        // ============================================================
        // CAMBIO 1: Establecer formato de fecha
        // ============================================================
        System.out.println("========================================");
        System.out.println("   CAMBIO 1: Formato de fecha");
        System.out.println("========================================");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        config.setDefaultDateFormat(sdf1);
        
        // ============================================================
        // CAMBIO 2: Establecer formato de dinero
        // ============================================================
        System.out.println("\n========================================");
        System.out.println("   CAMBIO 2: Formato de dinero");
        System.out.println("========================================");
        DecimalFormat df1 = new DecimalFormat("$#,##0.00");
        config.setMoneyFormat(df1);
        
        // ============================================================
        // CAMBIO 3: Cambiar formato de fecha nuevamente
        // ============================================================
        System.out.println("\n========================================");
        System.out.println("   CAMBIO 3: Nuevo formato de fecha");
        System.out.println("========================================");
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
        config.setDefaultDateFormat(sdf2);
        
        // ============================================================
        // CAMBIO 4: Cambiar formato de dinero
        // ============================================================
        System.out.println("\n========================================");
        System.out.println("   CAMBIO 4: Formato de dinero (EUR)");
        System.out.println("========================================");
        DecimalFormat df2 = new DecimalFormat("€#,##0.00");
        config.setMoneyFormat(df2);
        
        // ============================================================
        // REMOVER UN OBSERVER
        // ============================================================
        System.out.println("\n========================================");
        System.out.println("   REMOVIENDO DateObserver-2");
        System.out.println("========================================");
        config.removeObserver(dateObserver2);
        
        // ============================================================
        // CAMBIO 5: Verificar que DateObserver-2 no recibe notificación
        // ============================================================
        System.out.println("\n========================================");
        System.out.println("   CAMBIO 5: Formato de fecha (sin Obs-2)");
        System.out.println("========================================");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        config.setDefaultDateFormat(sdf3);
        
        System.out.println("\n========================================");
        System.out.println("   FIN DEL DEMO");
        System.out.println("========================================");
    }
}