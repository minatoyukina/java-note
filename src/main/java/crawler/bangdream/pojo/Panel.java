package crawler.bangdream.pojo;

public class Panel {
    private Integer number;
    private int performance;
    private int technique;
    private int visual;
    private int overall;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getTechnique() {
        return technique;
    }

    public void setTechnique(int technique) {
        this.technique = technique;
    }

    public int getVisual() {
        return visual;
    }

    public void setVisual(int visual) {
        this.visual = visual;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    @Override
    public String toString() {
        return "Panel{" +
                "number=" + number +
                ", performance=" + performance +
                ", technique=" + technique +
                ", visual=" + visual +
                ", overall=" + overall +
                '}';
    }
}
