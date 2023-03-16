import java.util.List;
//Y por último, podemos crear un objeto Map y utilizar el método findPath para encontrar el camino más corto:
public class Main {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        Node start = map.getNode(0, 0);
        Node end = map.getNode(9, 9);

        List<Node> path = map.findPath(start, end);

        if (path == null) {
            System.out.println("No se pudo encontrar un camino.");
        } else {
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        }
    }
}