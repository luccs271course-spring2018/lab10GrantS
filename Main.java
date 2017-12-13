import java.util.*;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.*;
import org.jgrapht.graph.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.*;

public class Main {

    static final String SA = "Saudi Arabia";
    static final String YE = "Yemen";
    static final String OM = "Oman";
    static final String IR = "Iraq";
    static final String EG = "Egypt";
    static final String KU = "Kuwait";
    static final String JO = "Jordan";

    public static void main(String[] args) {

        final SimpleGraph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

        myMap.addVertex(SA);
        myMap.addVertex(YE);
        myMap.addVertex(OM);
        myMap.addVertex(IR);
        myMap.addVertex(EG);
        myMap.addVertex(KU);
        myMap.addVertex(JO);


        // Saudi Arabia
        myMap.addEdge(YE,SA);
        myMap.addEdge(OM,SA);
        myMap.addEdge(IR,SA);
        myMap.addEdge(EG,SA);
        myMap.addEdge(KU,SA);
        myMap.addEdge(JO,SA);

        // Yemen
        myMap.addEdge(OM, YE);

        // Oman
        // Nothing to add

        // Iraq
        myMap.addEdge(JO,IR);
        myMap.addEdge(KU,IR);

        // Egypt
        myMap.addEdge(JO,EG);

        //Kuwait
        // Nothing to add

        System.out.println(myMap.toString());

        System.out.println("\n");
        System.out.println("Let's take a trip to Saudi Arabia");
        System.out.println("\n");
        System.out.println("BreadthFirst: ");
        final Iterator<String> bf = new BreadthFirstIterator<>(myMap, SA);
        while (bf.hasNext()) {
            final String country = bf.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("ClosestFirst: ");
        final Iterator<String> cf = new ClosestFirstIterator<>(myMap, SA);
        while (cf.hasNext()) {
            final String country = cf.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("DepthFirst: ");
        final Iterator<String> df = new DepthFirstIterator<>(myMap, SA);
        while (df.hasNext()) {
            final String country = df.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("RandomWalk: ");
        final Iterator<String> rw = new RandomWalkIterator<>(myMap, SA, false, 10);
        while (rw.hasNext()) {
            final String country = rw.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("Time for a change of Scenery");
        System.out.println("\n");
        System.out.println("BreadthFirst: ");
        final Iterator<String> bf2 = new BreadthFirstIterator<>(myMap, IR);
        while (bf2.hasNext()) {
            final String country = bf2.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("Closest First: ");
        final Iterator<String> cf2 = new ClosestFirstIterator<>(myMap, IR);
        while (cf2.hasNext()) {
            final String country = cf2.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("DepthFirst: ");
        final Iterator<String> df2 = new DepthFirstIterator<>(myMap, IR);
        while (df2.hasNext()) {
            final String country = df2.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("RandomWalk: ");
        final Iterator<String> rw2 = new RandomWalkIterator<>(myMap, IR, false, 10);
        while (rw2.hasNext()) {
            final String country = rw2.next();
            System.out.println(country);
        }

        System.out.println("\n");
        System.out.println("GreedyColoring: ");
        GreedyColoring<String, DefaultEdge> gc = new GreedyColoring<String, DefaultEdge>(myMap);
        final Iterator<Map.Entry<String, Integer>> gcIterator =
                gc.getColoring().getColors().entrySet().iterator();
        while (gcIterator.hasNext()) {
            final Map.Entry<String, Integer> color = gcIterator.next();
            System.out.println(color.getKey() + " = " + color.getValue());
        }
    }
}