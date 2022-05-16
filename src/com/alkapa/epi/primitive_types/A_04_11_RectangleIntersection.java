package com.alkapa.epi.primitive_types;

public class A_04_11_RectangleIntersection {
    public static class Reactngle {
        private int x, y;
        private int width, height;

        public Reactngle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public boolean isIntersect(Reactngle r2) {
            Reactngle r1 = this;

            return r1.x <= r2.x + r2.width && r2.x <= r1.x + r1.width
                    && r1.y <= r2.y + r2.height && r2.y <= r1.y + r1.height;
        }

        public Reactngle intersectRectangle(Reactngle r2) {
            Reactngle r1 = this;

            if (!isIntersect(r2)) {
                return null;
            }

            return new Reactngle(
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
        Reactngle r1 = new Reactngle(5,5,7,7);
        Reactngle r2 = new Reactngle(7, 7, 8, 8);
        boolean intersect = r1.isIntersect(r2);
        System.out.println(intersect);
        Reactngle r0 = r1.intersectRectangle(r2);
        System.out.println(r0.toString());
    }
}
