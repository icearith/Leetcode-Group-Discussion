class Solution {
    private double x_center, y_center;
    private double radius;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double angle = 2 * Math.PI * Math.random();
        double len = radius * Math.sqrt(Math.random());
        return new double[]{Math.cos(angle) * len + x_center, Math.sin(angle) * len + y_center};
    }

    public static void main(String[] args) {
        double radius = 1;
        double x_center = 0, y_center = 0;
        Solution obj = new Solution(radius, x_center, y_center);
        double[] param_1 = obj.randPoint();
        System.out.println("(" + param_1[0] + ", " + param_1[1] + ")");
    }
}
