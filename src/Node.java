
//Primero, creamos una clase para representar cada nodo en el mapa:
public class Node {
    public int x, y;
    public boolean isObstacle;
    public double gScore;
    public double fScore;
    public Node cameFrom;

    public Node(int x, int y, boolean isObstacle) {
        this.x = x;
        this.y = y;
        this.isObstacle = isObstacle;
        this.gScore = Double.POSITIVE_INFINITY;
        this.fScore = Double.POSITIVE_INFINITY;
        this.cameFrom = null;
    }
}
