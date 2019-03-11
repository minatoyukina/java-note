package oop.generics;

public class Wildcards {
    static void rawArgs(Holder holder, Object arg) {
        Object obj = holder.get();
    }

    static void unboundedArg(Holder<?> holder, Object arg) {
//        holder.set(arg);
//        holder.set(new Wildcards());
//        T t = holder.get();
        Object obj = holder.get();
    }

    static <T> T exect1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exect2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T extends Holder<? super T>> T wildSubSupertype(Holder<T> holder) {
        return (T) holder;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
//        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
//        T t = holder.get();
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder();
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exect1(raw);
        Long r2 = exect1(qualified);
        Object r3 = exect1(unbounded);
        Long r4 = exect1(bounded);

        Long r5 = exect2(raw, lng);
        Long r6 = exect2(qualified, lng);
//        Long r7 = exect2(unbounded, lng);
//        Long r8 = exect2(bounded, lng);

        Long r9 = wildSubtype(raw, lng);
        Long r10 = wildSubtype(qualified, lng);
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        wildSupertype(raw, lng);
        wildSupertype(qualified, lng);
//        wildSupertype(unbounded, lng);
    }
}
