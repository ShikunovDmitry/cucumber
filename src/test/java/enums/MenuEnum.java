package enums;

public enum MenuEnum {
    AUTO("Автобарахолка");

    public String getMenuText() {
        return menuText;
    }

    private String menuText;
        MenuEnum(String menu){
        this.menuText = menu;
        }
}
