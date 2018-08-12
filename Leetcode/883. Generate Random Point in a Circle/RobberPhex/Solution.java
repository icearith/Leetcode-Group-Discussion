class Solution {
    private double x_center, y_center;
    private double radius;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double[] point = new double[2];
        do {
            point[0] = (2 * Math.random() - 1) * radius;
            point[1] = (2 * Math.random() - 1) * radius;
        } while (point[0] * point[0] + point[1] * point[1] > radius * radius);
        return new double[]{point[0] + x_center, point[1] + y_center};
    }

    public static void main(String[] args) {
        double radius = 1;
        double x_center = 1, y_center = 1;
        Solution obj = new Solution(radius, x_center, y_center);
        double[] param_1 = obj.randPoint();
        System.out.println("(" + param_1[0] + ", " + param_1[1] + ")");
    }
}
