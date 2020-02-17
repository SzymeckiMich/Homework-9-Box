public class CuboidProduct extends Product {
    double width;
    double height;
    double length;

    public CuboidProduct(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    @Override
    public double size() {
        return (width*height*length);
    }
}

