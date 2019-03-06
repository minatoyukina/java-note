package crawler.bangdream.pojo;

public class Card {
    private Integer id;
    private Integer number;
    private String member;
    private String title;
    private Integer rarity;
    private Panel panel;
    private String attribute;
    private String skill;
    private String icon;
    private String icon_trained;

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon_trained() {
        return icon_trained;
    }

    public void setIcon_trained(String icon_trained) {
        this.icon_trained = icon_trained;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number=" + number +
                ", member='" + member + '\'' +
                ", title='" + title + '\'' +
                ", rarity=" + rarity +
                ", panel=" + panel +
                ", attribute='" + attribute + '\'' +
                ", skill='" + skill + '\'' +
                ", icon='" + icon + '\'' +
                ", icon_trained='" + icon_trained + '\'' +
                '}';
    }
}
