import java.util.*;
public class TrafficLightSystem {
    enum TrafficLightState {
        GREEN, YELLOW, RED
    } 

    static class TrafficLightGraph {
        private Map<TrafficLightState, List<TrafficLightState>> graph;
        public TrafficLightGraph() {
            graph = new HashMap<>();
            graph.put(TrafficLightState.RED, Arrays.asList(TrafficLightState.GREEN));
            graph.put(TrafficLightState.GREEN, Arrays.asList(TrafficLightState.YELLOW));
            graph.put(TrafficLightState.YELLOW, Arrays.asList(TrafficLightState.RED));
        }

        public TrafficLightState getNextState(TrafficLightState currentState) {
            List<TrafficLightState> nextStates = graph.get(currentState);
            if (nextStates != null && !nextStates.isEmpty()) {
                return nextStates.get(0); 
            }
            return currentState; 
        }

        public void displayGraph() {
            for (TrafficLightState state : graph.keySet()) {
                System.out.print(state + " -> ");
                for (TrafficLightState nextState : graph.get(state)) {
                    System.out.print(nextState + " ");
                }
                System.out.println();
            }
        }
    }

    private TrafficLightState currentState;
    private TrafficLightGraph graph;

    public TrafficLightSystem() {
        this.graph = new TrafficLightGraph();
        this.currentState = TrafficLightState.RED; 
    }

    public void changeState() {
        this.currentState = graph.getNextState(this.currentState);
    }

    public void displayState() {
        System.out.println("Current Traffic Light State: " + this.currentState);
    }

    public static void main(String[] args) throws InterruptedException {
        TrafficLightSystem tls = new TrafficLightSystem();
        tls.graph.displayGraph();
        for (int i = 0; i < 10; i++) {
            tls.displayState();  
            Thread.sleep(1000);
            tls.changeState();   
        }
    }
}
