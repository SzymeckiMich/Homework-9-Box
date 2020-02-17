public class CuboidBox extends Box {
    double width;
    double height;
    double length;

    public CuboidBox(String name, double width, double height, double length) {
        super(name);
        this.width = width;
        this.height = height;
        this.length = length;
    }

    @Override
    public double size() {
        return (width * height * length);
    }
}
