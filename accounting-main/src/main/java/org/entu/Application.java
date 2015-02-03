package org.entu;

import org.entu.controller.Event;
import org.entu.controller.Listener;
import org.entu.model.Operation;
import org.entu.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by MSI-Pc on 03.02.2015.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    View mockView() {
        return new View() {
            @Override
            public void show(Collection<Operation> operations) {
                System.out.println("Show: " + operations);
            }

            @Override
            public void registerListener(Listener listener) {
                System.out.println("Register Listener: " + listener);
                listener.notify(new Event() {
                });
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        View view = context.getBean(View.class);

        view.registerListener(new Listener() {
            @Override
            public void notify(Event event) {
                System.out.println("Notify: " + event);
            }
        });
    }
}