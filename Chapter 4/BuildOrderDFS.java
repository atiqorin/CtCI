import java.util.*;

public class BuildOrderDFS {
    public static Stack<Project> createBuildOrder(String[] projects, String[][] dependencies){
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }
    public static Stack<Project> orderProjects(ArrayList<Project> projects){
        Stack<Project> stack = new Stack<>();
        for(Project project : projects){
            if(project.getState() == Project.State.BLANK) {
                if(!dfs(project, stack)){
                    return null;
                }
            }
        }
        return stack;
    }
    public static boolean dfs(Project project, Stack<Project> stack){
        if(project.getState() == Project.State.PARTIAL){
            return false;
        }
        if(project.getState() == Project.State.BLANK){
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for(Project child : children){
                if(!dfs(child, stack)){
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
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
    public static void main(String[] args){
        String[] projects = {"a","b","c","d","e","f"};
        String[][] dependencies = {{"a","d"}, {"f","b"},{"b","d"},{"f","a"},{"d","c"}};
        Stack<Project> order = createBuildOrder(projects, dependencies);
        while(!order.isEmpty()){
            System.out.print(order.pop().name+" ");
        }
        System.out.println();
    }
}
class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    public String name;
    public enum State {COMPLETE, PARTIAL, BLANK};
    private State state = State.BLANK;

    public State getState(){
        return state;
    }
    public void setState(State st){
        state = st;
    }
    public Project(String n){
        name = n;
    }

    public void addNeigbour(Project node){
        if(!map.containsKey(node.name)){
            children.add(node);
            map.put(node.name, node);
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