public class SphereProduct extends Product {
    double radius;

    public SphereProduct(double radius) {
        this.radius = radius;
    }

    @Override
    public double size() {
        return ((4 / 3) * Math.PI * Math.pow(radius, 3));
    }
}
