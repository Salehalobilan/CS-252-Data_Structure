public class Desk extends Item{

    private String type , color,material;

    public Desk(String id,String type,  int quantity,  String color, String material,double price) {
        super(id, price, quantity);
        this.type = type;
        this.color = color;
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return String.format("Desk -> %s ,Color= %s ,Material= %s ,Type= %s %n",super.toString(), color , material ,type );
    }

}
