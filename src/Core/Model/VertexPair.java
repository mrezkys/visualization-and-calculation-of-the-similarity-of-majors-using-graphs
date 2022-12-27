package Core.Model;


import java.util.List;

public class VertexPair {
    private final Vertex vertex1;
    private final Vertex vertex2;
    private final double similarity;

    public VertexPair(Vertex vertex1, Vertex vertex2, double similarity) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.similarity = similarity;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public double getSimilarity() {
        return similarity;
    }
    public static void printListVertexPair(List<VertexPair> list){
        for (VertexPair element : list){
            System.out.println(element.getVertex1().name + " and " + element.getVertex2().name + " : " + element.getSimilarity());
        }
    }
    public static void sort(List<VertexPair> pairs) {
        for (int i = 0; i < pairs.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < pairs.size(); j++) {
                if (pairs.get(j).similarity > pairs.get(maxIndex).similarity) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                VertexPair temp = pairs.get(i);
                pairs.set(i, pairs.get(maxIndex));
                pairs.set(maxIndex, temp);
            }
        }
    }
}