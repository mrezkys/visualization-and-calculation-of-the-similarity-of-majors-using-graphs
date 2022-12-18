package Core.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import Core.Model.Edge;
import Core.Model.Graph;
import Core.Model.Vertex;
import Core.Model.VertexPair;

public class GraphPanel extends JPanel {
    private Graph graph;
    private static final int RADIUS = 40;
    private static final double REPULSION = 100.0;
    private static final double ATTRACTION = 0.1;
    private static final double DAMPING = 0.5;
    private static final int MAX_ITERATIONS = 1000;

    private Map<Vertex, Point> positions;
    private Map<Vertex, Point> forces;

    public GraphPanel(Graph graph) {
        this.graph = graph;
        positions = new HashMap<>();
        forces = new HashMap<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Compute the center and radius of the circle
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 2 - RADIUS;
        // Initialize the positions and forces of the vertices
        Vertex vertex = graph.head;
        int index = 0;
        while (vertex != null) {
            double angle = 2 * Math.PI * index / graph.size;
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));
            positions.put(vertex, new Point(x, y));
            forces.put(vertex, new Point(0, 0));
            vertex = vertex.next;
            index++;
        }

        // Run the force-directed layout algorithm
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            vertex = graph.head;
            while (vertex != null) {
                Point position = positions.get(vertex);
                Point force = forces.get(vertex);

                // Calculate the attractive force from the edges
                Edge edge = vertex.listEdge.head;
                while (edge != null) {
                    Vertex neighbor = edge.destination;
                    Point neighborPosition = positions.get(neighbor);
                    double dx = neighborPosition.x - position.x;
                    double dy = neighborPosition.y - position.y;
                    double distance = Math.sqrt(dx * dx + dy * dy);
                    if (distance > 0) {
                        double fx = ATTRACTION * dx / distance;
                        double fy = ATTRACTION * dy / distance;
                        force.x -= fx;
                        force.y -= fy;
                    }
                    edge = edge.next;
                }

                // Calculate the repulsive force from other vertices
                Vertex other = graph.head;
                while (other != null) {
                    if (other != vertex) {
                        Point otherPosition = positions.get(other);
                        double dx = position.x - otherPosition.x;
                        double dy = position.y - otherPosition.y;
                        double distance = Math.sqrt(dx * dx + dy * dy);
                        if (distance > 0) {
                            double fx = REPULSION * dx / distance / distance;
                            double fy = REPULSION * dy / distance / distance;
                            force.x += fx;
                            force.y += fy;
                        }
                    }
                    other = other.next;
                }
                // Update the position based on the forces
                position.x += force.x * DAMPING;
                position.y += force.y * DAMPING;
                force.x = 0;
                force.y = 0;
                vertex = vertex.next;
            }
        }

        // Draw the graph
        g.setColor(Color.BLACK);
        vertex = graph.head;
        while (vertex != null) {
            Point position = positions.get(vertex);
            g.drawOval(position.x - RADIUS, position.y - RADIUS, RADIUS * 2, RADIUS * 2);
            g.drawString(vertex.name, position.x, position.y); // ditambahin biar agak bawahan

            Edge edge = vertex.listEdge.head;
            while (edge != null) {
                Vertex neighbor = edge.destination;
                Point neighborPosition = positions.get(neighbor);
                g.drawLine(position.x, position.y, neighborPosition.x, neighborPosition.y);
                // Draw the similarity value along the edge
                int midX = (position.x + neighborPosition.x) / 2;
                int midY = (position.y + neighborPosition.y) / 2;
                g.drawString(edge.getSimilarityString(), midX, midY);
                edge = edge.next;
            }
            vertex = vertex.next;
        }
    }
}