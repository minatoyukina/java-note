package lambda.option;

public class PersonRaw {
    private CarRaw carRaw;

    public CarRaw getCarRaw() {
        return carRaw;
    }

    public static void main(String[] args) {
        PersonRaw personRaw = new PersonRaw();
        String name = personRaw.getCarRaw().getInsuranceRaw().getName();
        System.out.println(name);
    }
}

class CarRaw {
    private InsuranceRaw insuranceRaw;

    public InsuranceRaw getInsuranceRaw() {
        return insuranceRaw;
    }
}

class InsuranceRaw {
    private String name;

    public String getName() {
        return name;
    }
}
