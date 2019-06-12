package design_pattern.lambda;

import java.util.function.Consumer;

public class TemplateMain {
    public static void main(String[] args) {
        new OnlineBanking() {
            @Override
            protected void makeCustomerHappy(Customer c) {
                System.out.println("Hello " + c.getName());
            }
        }.processCustomer(1);

        new OnlineBankingLambda().processCustomer(1, (customer -> System.out.println("Hello " + customer.getName())));
    }

    private static abstract class OnlineBanking {
        void processCustomer(int id) {
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy(c);
        }

        abstract void makeCustomerHappy(Customer c);
    }

    private static class OnlineBankingLambda {
        void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy.accept(c);
        }
    }

    private static class Customer {
        private int id = 1;
        private String name = "Brian";

        public String getName() {
            return name;
        }
    }

    private static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
