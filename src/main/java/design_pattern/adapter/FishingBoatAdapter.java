package design_pattern.adapter;

public class FishingBoatAdapter implements RowingBoat {
    private FishingBoat boat;

    FishingBoatAdapter() {
        boat = new FishingBoat();
    }

    @Override
    public void row() {
        boat.sail();
    }
}
