public class Test {
    public static void main(String[] args) {
        BoxArray boxArray = new BoxArray();

        boxArray.boxes[0] = new CuboidBox("Pierwsze", 2, 2, 2);
        boxArray.boxes[1] = new CuboidBox("Drugie", 2, 2, 3);
        boxArray.boxes[2] = new CuboidBox("Trzecie", 3, 2, 3);
        boxArray.boxes[3] = new CuboidBox("Czwarte", 4, 2, 3);
        boxArray.boxes[4] = new CylinderBox("Piąte", 1, 2);

        Product kulka = new SphereProduct(1);

        boxArray.znajdźPudełko(kulka);

    }
}
