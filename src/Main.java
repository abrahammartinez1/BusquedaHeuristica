import java.util.List;
//Y por último, podemos crear un objeto Map y
// utilizar el método findPath para encontrar el camino más corto:
public class Main {
    public static void main(String[] args) {
        Map map = new Map(10, 10); // creamos objeto map con numero total de filas y columnas de la matriz
        Node start = map.getNode(0, 0); // creamos objeto node "inicio" - nodo de inicio
        Node end = map.getNode(9, 9);   // creamos objeto node "final" - nodo final

        // Creamos una lista de objetos tipo nodo que llamamos path
        //llamamos al metodo findPath que devuelva la lista de nodos hasta el final
        List<Node> path = map.findPath(start, end);

        if (path == null) {
            System.out.println("No se pudo encontrar un camino.");
        } else {
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")"); //recorremos la lista de nodos y los mostramos
            }
        }
    }
}