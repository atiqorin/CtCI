import java.util.*;

public class BuildOrder {
    public static Project[] createBuildOrder(String[] projects, String[][] dependencies){
        Graph graph = buildGraph(projects, dependencies);
        return orderProjcets(graph.getNodes());
    }
    public static Graph buildGraph(String[] projects, String[][] dependencies){
        Graph graph = new Graph();
        for(String project : projects){
            graph.getOrCreateNode(project);
        }
        for(String[] dependency : dependencies){
            String start = dependency[0];
            String end = dependency[1];
            graph.addEdge(start, end);
        }
        return graph;
    }
    public static Project[] orderProjcets(ArrayList<Project> projects){
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependentProject(order, projects, 0);

        int toBeProcessed = 0;
        while(toBeProcessed < order.length){
            Project current = order[toBeProcessed];

            if(current == null){
                return null;
            }
            ArrayList<Project> children = current.getChildren();
            for(Project child : children){
                child.dependencies = child.dependencies - 1;
            }
            endOfList = addNonDependentProject(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }
    public static int addNonDependentProject(Project[] order, ArrayList<Project> projects, int offset){
        for(Project project : projects){
            if(project.dependencies == 0){
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
    public static void main(String[] args){
        String[] projects = {"a","b","c","d","e","f"};
        String[][] dependencies = {{"a","d"}, {"f","b"},{"b","d"},{"f","a"},{"d","c"}};
        Project[] order = createBuildOrder(projects, dependencies);
        for(Project p : order){
            System.out.print(p.name+" ");
        }
        System.out.println();
    }
}
class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    public String name;
    public int dependencies = 0;

    public Project(String n){
        name = n;
    }

    public void addNeigbour(Project node){
        if(!map.containsKey(node.name)){
            children.add(node);
            map.put(node.name, node);
            node.dependencies++;
        }
    }

    public ArrayList<Project> getChildren() {
        return children;
    }
}
class Graph{
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            map.put(name, node);
            nodes.add(node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName){
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeigbour(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}