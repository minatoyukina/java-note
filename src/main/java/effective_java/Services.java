package effective_java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

interface Service {
    void print();
}

interface Provider {
    Service newService();
}

public class Services {
    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    private static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null)
            throw new IllegalArgumentException("No provider registered with name: " + name);
        return p.newService();
    }

    public static void main(String[] args) {
        Provider1 provider1 = new Provider1();
        Services.registerDefaultProvider(provider1);
        Services.newInstance().print();

        Provider2 provider2 = new Provider2();
        Services.registerProvider("abc",provider2);
        Services.newInstance("abc").print();
    }
}

class Provider1 implements Provider {
    @Override
    public Service newService() {
        return () -> System.out.println("hello");
    }
}

class Provider2 implements Provider {
    @Override
    public Service newService() {
        return () -> System.out.println("java");
    }
}




