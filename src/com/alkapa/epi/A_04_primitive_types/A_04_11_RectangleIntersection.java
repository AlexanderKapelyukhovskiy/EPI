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
        private int x, y;
        private int width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public boolean isIntersect(Rectangle r2) {
            Rectangle r1 = this;

            return r1.x <= r2.x + r2.width && r2.x <= r1.x + r1.width
                    && r1.y <= r2.y + r2.height && r2.y <= r1.y + r1.height;
        }

        public Rectangle intersectRectangle(Rectangle r2) {
            Rectangle r1 = this;

            if (!isIntersect(r2)) {
                return null;
            }

            return new Rectangle(
                    Math.max(r1.x, r2.x),
                    Math.max(r1.y, r2.y),
                    Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x),
                    Math.min(r1.y + r1.width, r2.y + r2.width) - Math.max(r1.y, r2.y));
        }

        @Override
        public String toString() {
            return String.format("x=%d, y=%d, wight=%d, height=%d", this.x, this.x, this.width, this.height);
        }
    }

    public static void main(String[] argds) {
        Rectangle r1 = new Rectangle(5, 5, 7, 7);
        Rectangle r2 = new Rectangle(7, 7, 8, 8);
        boolean intersect = r1.isIntersect(r2);
        System.out.println(intersect);
        Rectangle r0 = r1.intersectRectangle(r2);
        System.out.println(r0.toString());
    }
}
