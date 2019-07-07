package design_pattern.adapter;

public class Captain implements RowingBoat {
    private RowingBoat rowingBoat;

    Captain(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    @Override
    public void row() {
        rowingBoat.row();
    }
}
