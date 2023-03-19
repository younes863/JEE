package presentation;

import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationSpringV2 {
    public static  void main (String[] args){
        ApplicationContext context= new AnnotationConfigApplicationContext("dao","Metier");
        IMetier metier= context.getBean(IMetier.class);
        System.out.println("R: " +metier.calcul());
    }
}
