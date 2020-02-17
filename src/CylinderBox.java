public class CylinderBox extends Box {
    double radius;
    double height;


    public CylinderBox(String name, double radius, double height) {
        super(name);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double size() {
        return (height * Math.PI * Math.pow(radius, 2));
    }
}
