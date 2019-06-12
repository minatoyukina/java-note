package design_pattern.monad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        User user = new User("", 31, Sex.FEMALE, "foobar.com");
        LOGGER.info(Validator.of(user)
                .validate(User::getName, name -> !name.isEmpty(), "name is null")
                .validate(User::getEmail, email -> email.contains("@"), "email doesn't contains '@'")
                .validate(User::getAge, age -> age > 20 && age < 30, "age isn't between...")
                .get().toString());
    }
}
