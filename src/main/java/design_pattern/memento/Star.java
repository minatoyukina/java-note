package design_pattern.memento;

public class Star {
    private StarType type;
    private int ageYears;
    private int massTons;

    Star(StarType type, int ageYears, int massTons) {
        this.type = type;
        this.ageYears = ageYears;
        this.massTons = massTons;
    }

    void timePasses() {
        ageYears *= 2;
        massTons *= 8;
        switch (type) {
            case SUN:
                type = StarType.RED_GIANT;
                break;
            case RED_GIANT:
                type = StarType.WHITE_DWARF;
                break;
            case WHITE_DWARF:
                type = StarType.SUPERNOVA;
                break;
            case SUPERNOVA:
                type = StarType.DEAD;
                break;
            case DEAD:
                ageYears *= 2;
                massTons = 0;
                break;
            default:
                break;
        }
    }

    StarMemento getMemento() {
        StarMementoInternal state = new StarMementoInternal();
        state.setAgeYears(ageYears);
        state.setMassTons(massTons);
        state.setType(type);
        return state;
    }

    void setMemento(StarMemento memento) {
        StarMementoInternal state = (StarMementoInternal) memento;
        this.type = state.getType();
        this.ageYears = state.getAgeYears();
        this.massTons = state.getMassTons();
    }

    @Override
    public String toString() {
        return String.format("%s age: %d years mass: %d tons", type.toString(), ageYears, massTons);
    }

    private class StarMementoInternal implements StarMemento {
        private StarType type;
        private int ageYears;
        private int massTons;

        public StarType getType() {
            return type;
        }

        void setType(StarType type) {
            this.type = type;
        }

        int getAgeYears() {
            return ageYears;
        }

        void setAgeYears(int ageYears) {
            this.ageYears = ageYears;
        }

        int getMassTons() {
            return massTons;
        }

        void setMassTons(int massTons) {
            this.massTons = massTons;
        }
    }
}
