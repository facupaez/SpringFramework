package com.example.componentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Facu Paez
 * Tema: Beans.
 * Manejo de beans con Spring Framework.
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        // Opción 1: Utilizando la palabra reservada new
        // CalculatorService calculatorWithNew = new CalculatorService();

        // Concepto 1: Como obtener beans de Spring
        // Opción 2: Recibir un objeto bean de Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("beansComponentScan.xml");

        // Instanciamos el objeto GreetingsService sin escribirlo ya que Spring lo hace por nosotros.
        CalculatorService calculatorService = (CalculatorService) context.getBean("calculatorService");

        String calculator = calculatorService.calculator();
        System.out.println(calculator);

        // Concepto 2. Cargar un bean dentro de otro bean.
        BillManager billManager = (BillManager) context.getBean("billManager");
        // accedemos a la clase factura, y desde alli a la clasa calculadora debido a que no esta encapsulada.
        System.out.println(billManager.calculatorService.calculator());

        // Concepto 3: Scope o alcance.
        // Los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación.
        // Podemos cambiar el scope a prototype si queremos que se cree un nuevo objeto cada vez.
    }
}