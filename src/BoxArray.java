public class BoxArray {
    Box[] boxes = new Box[5];

    public Box znajdźPudełko(Product product) {
        if (dobierzPudełko(product) == null) {
            System.out.println("Brak odpowiedniego pudełka");
            return null;
        } else {
            System.out.println("Odpowiednie pudełko to: " + dobierzPudełko(product).name);
            return dobierzPudełko(product);
        }

    }

    public Box dobierzPudełko(Product product) {
        Box najlepsze = null;
        double space = 0;
        int i;
        for (i = 0; i < boxes.length; i++) {
            if ((czyNieWiększeOdPudełka(product, boxes[i])) &&
                    (czySięZmieści(product, boxes[i]))) {
                najlepsze = boxes[i];
                space = freeSpace(product, boxes[i]);
                break;
            }
        }
        for (int j = 0; j < boxes.length; j++) {
            if ((czyNieWiększeOdPudełka(product, boxes[j])) && (czySięZmieści(product, boxes[j])) &&
                    (freeSpace(product, boxes[j]) < space)) {
                najlepsze = boxes[j];
            }
        }
        return najlepsze;
    }

    private boolean czyNieWiększeOdPudełka(Product product, Box box) {
        return (box.size() - product.size() >= 0);
    }

    private boolean czySięZmieści(Product product, Box box) {
        if ((product instanceof CuboidProduct) && (box instanceof CuboidBox)) return cuboidOnCuboid(product, box);
        else if ((product instanceof CuboidProduct) && (box instanceof CylinderBox))
            return cuboidOnCylinder(product, box);
        else if ((product instanceof SphereProduct) && (box instanceof CylinderBox))
            return sphereOnCylinder(product, box);
        else return sphereOnCuboid(product, box);
    }

    public boolean cuboidOnCuboid(Product product, Box box) {
        double prodWidth = ((CuboidProduct) product).width;
        double prodHeight = ((CuboidProduct) product).height;
        double prodLength = ((CuboidProduct) product).length;

        double boxWidth = ((CuboidBox) box).width;
        double boxLength = ((CuboidBox) box).length;
        double boxHeight = ((CuboidBox) box).height;

        return (((prodHeight <= boxHeight) && (prodWidth <= boxWidth) && (prodLength <= boxLength)) ||   // 1
                ((prodHeight <= boxHeight) && (prodLength <= boxWidth) && (prodWidth <= boxLength)) ||  // 2
                ((prodWidth <= boxHeight) && (prodLength <= boxWidth) && (prodHeight <= boxLength)) ||  // 3
                ((prodWidth <= boxHeight) && (prodHeight <= boxWidth) && (prodLength <= boxLength)) ||  // 4
                ((prodLength <= boxHeight) && (prodHeight <= boxWidth) && (prodWidth <= boxLength)) ||  // 5
                ((prodLength <= boxHeight) && (prodWidth <= boxWidth) && (prodHeight <= boxLength)));  // 6
    }

    private boolean cuboidOnCylinder(Product product, Box box) {
        double prodWidth = ((CuboidProduct) product).width;
        double prodHeight = ((CuboidProduct) product).height;
        double prodLength = ((CuboidProduct) product).length;
        double boxHeight = ((CylinderBox) box).height;
        double boxRadius = ((CylinderBox) box).radius;

        return (((prodHeight <= boxHeight) && (diagonal(prodLength, prodWidth) <= (2 * boxRadius))) ||
                ((prodWidth <= boxHeight) && (diagonal(prodLength, prodHeight) <= (2 * boxRadius))) ||
                ((prodLength <= boxHeight) && (diagonal(prodWidth, prodHeight) <= (2 * boxRadius))));
    }

    private double diagonal(double a, double b) {
        double sumOfSquares = (a * a) + (b * b);
        return Math.sqrt(sumOfSquares);
    }

    private boolean sphereOnCylinder(Product product, Box box) {
        double boxHeight = ((CylinderBox) box).height;
        double boxRadius = ((CylinderBox) box).radius;
        double radius = ((SphereProduct) product).radius;
        return ((2 * radius) <= boxHeight) && (radius <= boxRadius);
    }

    private boolean sphereOnCuboid(Product product, Box box) {
        double boxWidth = ((CuboidBox) box).width;
        double boxLength = ((CuboidBox) box).length;
        double boxHeight = ((CuboidBox) box).height;
        double radius = ((SphereProduct) product).radius;

        return (((2 * radius) <= boxHeight) && ((2 * radius) <= boxLength) && ((2 * radius) <= boxWidth));
    }

    private double freeSpace(Product product, Box box) {
        return (box.size() - product.size());
    }
}
