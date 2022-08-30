package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

interface Chip {
    boolean check(Chip others);
    boolean good();
    int getId();
}

class PairC {
    Chip a;
    Chip b;

    public PairC(Chip a, Chip b) {
        this.a = a;
        this.b = b;
    }

    public Chip getA() {
        return a;
    }
}

class PairB {
    boolean a;
    boolean b;

    public PairB(boolean a, boolean b) {
        this.a = a;
        this.b = b;
    }

    boolean isBothTrue(){
        return a && b;
    }


}


class GoodChip implements Chip{

    public GoodChip(int id) {
        this.id = id;
    }

    int id;

        public boolean good() {
            return true;
        }

        public boolean check(Chip other){
            return other.good();
        }

    @Override
    public int getId() {
        return id;
    }
}

class BadChip implements Chip {

    int id;

    public BadChip(int id) {
        this.id = id;
    }

    public boolean good() {
        return false;
    }

    public boolean check(Chip other) {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public int getId() {
        return id;
    }
}

class Main {
    public static PairB jig(Chip a, Chip b) {
        PairB res = new PairB(a.check(b), b.check(a));
        return res;
    }

    public static Chip findSingleGood(List<Chip> chips) {
        if (chips.size() <= 2) {
            return chips.get(0);
        } else {
            int halfpoint = (int) Math.floor(chips.size() / 2);
            ArrayList<PairC> pairs = new ArrayList<>();

            int start = chips.size() % 2;

            for (int i = start ; i < halfpoint+start; i++) {
                pairs.add(new PairC(chips.get(i), chips.get(i + halfpoint)));
            }

            List<Chip> kept =
                    pairs.stream()
                            .filter(p -> jig(p.a, p.b).isBothTrue()).map(p -> p.getA())
                            .collect(Collectors.toList());

            if (chips.size() % 2 == 1) {
                kept.add(chips.get(0));
            }

            return findSingleGood(kept);
        }

    }


    public static void main(String[] arr) {

        List<Chip> chips = List.of(
                new GoodChip(0)
                ,new GoodChip(1)
                ,new BadChip(2)
                ,new GoodChip(3)
                ,new GoodChip(4));

        Chip good = findSingleGood(chips);

        chips.stream().filter(c -> jig(good, c).isBothTrue())
                .forEach(c->System.out.println(c.getId()+" "+c.good()));
    }
}
