package org.entu;

import org.entu.controller.Event;
import org.entu.controller.Listener;
import org.entu.model.Operation;
import org.entu.model.Type;
import org.entu.model.User;
import org.entu.model.Value;
import org.entu.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

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

        Operation operation = new Operation() {
            @Override
            public Long id() {
                return 1L;
            }

            @Override
            public Type type() {
                return new Type() {
                    public int s = 10;
                };
            }

            @Override
            public String label() {
                return "some";
            }

            @Override
            public Value value() {
                return new Value() {
                    @Override
                    public Object getValue() {
                        return "done.";
                    }
                };
            }

            @Override
            public User executor() {
                return new User() {
                    @Override
                    public Long id() {
                        return 2L;
                    }

                    @Override
                    public String login() {
                        return "42";
                    }

                    @Override
                    public String name() {
                        return "name";
                    }

                    @Override
                    public Date created() {
                        return new Date();
                    }
                };
            }

            @Override
            public Date timestamp() {
                return new Date();
            }
        };

        view.show(Arrays.asList(operation));

        view.registerListener(new Listener() {
            @Override
            public void notify(Event event) {
                System.out.println("Some event came, strange");
            }
        });
    }
}