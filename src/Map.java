import java.util.*;
//Luego, creamos una clase para representar el mapa y los métodos necesarios para el algoritmo:
public class Map {
    private int width, height;
    private Node[][] nodes;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.nodes = new Node[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                nodes[x][y] = new Node(x, y, false);
                //AÑADIMOS OBSTACULOS
                if (x==1 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==2 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==3 && y==5){ nodes[x][y].isObstacle=true;}
                //if (x==4 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==5 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==6 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==7 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==8 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==9 && y==5){ nodes[x][y].isObstacle=true;}
                if (x==0 && y==5){ nodes[x][y].isObstacle=true;}


            }
        }
    }

    public Node getNode(int x, int y) {
        return nodes[x][y];
    }

    public List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }

                int x = node.x + dx;
                int y = node.y + dy;

                if (x < 0 || x >= width || y < 0 || y >= height) {
                    continue;
                }

                Node neighbor = nodes[x][y];

                if (!neighbor.isObstacle) {
                    neighbors.add(neighbor);
                }
            }
        }

        return neighbors;
    }

    public double getDistance(Node node1, Node node2) {
        int dx = node1.x - node2.x;
        int dy = node1.y - node2.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public List<Node> findPath(Node start, Node end) {
        List<Node> openSet = new ArrayList<>();
        Set<Node> closedSet = new HashSet<>();

        start.gScore = 0;
        start.fScore = getDistance(start, end);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.stream().min(Comparator.comparing(n -> n.fScore)).get();

            if (current == end) {
                return reconstructPath(current);
            }

            openSet.remove(current);
            closedSet.add(current);

            for (Node neighbor : getNeighbors(current)) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                double tentativeGScore = current.gScore + getDistance(current, neighbor);

                if (!openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                } else if (tentativeGScore >= neighbor.gScore) {
                    continue;
                }

                neighbor.cameFrom = current;
                neighbor.gScore = tentativeGScore;
                neighbor.fScore = neighbor.gScore + getDistance(neighbor, end);
            }
        }

        return null;
    }

    private List<Node> reconstructPath(Node node) {
        List<Node> path = new ArrayList<>();
        path.add(node);

        while (node.cameFrom != null) {
            node = node.cameFrom;
            path.add(node);
        }

        Collections.reverse(path);
        return path;
    }




}
