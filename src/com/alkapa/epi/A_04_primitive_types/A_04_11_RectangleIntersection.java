package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.11 Rectangle intersection</h3>
 * <p>
 * Write a program which tests if two rectangles have nonempty intersection. If the intersection is
 * nonempty, return the rectangle formed by their intersection.
 * </p>
 */
public class A_04_11_RectangleIntersection {
    public static class Rectangle {
        private final int x, y;
        private final int width, height;

        /**
         * Constructor
         *
         * @param x      bottom left point's x
         * @param y      bottom left point's y
         * @param width
         * @param height
         */
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        /**
         * Determined if current rectangle has intersection with other rectangle
         *
         * @param r2 other rectangle
         * @return true if they intersect
         */
        public boolean isIntersect(Rectangle r2) {
            Rectangle r1 = this;

            return
                    r1.x <= r2.x + r2.width // r1.x is within r2 border
                            && r2.x <= r1.x + r1.width // r2.x is within r1 boarder

                            && r1.y <= r2.y + r2.height // r1.y is within r2 border
                            && r2.y <= r1.y + r1.height; // r2.y is within r1 border
        }

        /**
         * if current rectangle intersects with other rectangle it returns rectangle equal to intersection
         *
         * @param r2 other rectangle
         * @return intersection of or null if there is no intersection
         */
        public Rectangle intersectRectangle(Rectangle r2) {
            Rectangle r1 = this;

            if (!isIntersect(r2)) {
                return null;
            }

            return new Rectangle(
                    Math.max(r1.x, r2.x), // new x is bigger x
                    Math.max(r1.y, r2.y), // new y is bigger y
                    Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x), // calc width
                    Math.min(r1.y + r1.width, r2.y + r2.width) - Math.max(r1.y, r2.y)); // cal height
        }

        @Override
        public String toString() {
            return String.format("x=%d, y=%d, wight=%d, height=%d", this.x, this.x, this.width, this.height);
        }
    }

    private static void test(Rectangle r1, Rectangle r2, Rectangle expected) {
        System.out.println(String.format("r1: %s", r1));
        System.out.println(String.format("r2: %s", r2));
        Rectangle intersect = r1.intersectRectangle(r2);
        if ((expected == null && intersect != null) || (expected != null && (expected.x != intersect.x
                || expected.y != intersect.y
                || expected.width != intersect.width
                || expected.height != intersect.height))) {
            System.out.println("Error: ");
        }
        System.out.println(String.format("r1/r2: %s", intersect));
        System.out.println();
    }

    public static void main(String[] argds) {
        Rectangle r1 = new Rectangle(5, 5, 4, 4);
        Rectangle r2 = new Rectangle(7, 7, 8, 8);
        test(r1, r2, null);
        r1 = new Rectangle(5, 5, 7, 7);
        r2 = new Rectangle(7, 7, 8, 8);
        test(r1, r2, new Rectangle(7, 7, 5, 5));
    }
}
