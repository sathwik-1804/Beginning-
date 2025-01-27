//6.5
/*import java.util.ArrayDeque;
import java.util.Deque;
public class DequeOperations {
    private Deque<Integer> deque;
    public DequeOperations() {
        deque = new ArrayDeque<>();
    }
    public void append(int value) {
        deque.addLast(value);
    }
    public void appendLeft(int value) {
        deque.addFirst(value);
    }
    public int pop() {
        return deque.removeLast();
    }
    public int popLeft() {
        return deque.removeFirst();
    }
    public int index(int ele) {
        int index = 0;
        for (int value : deque) {
            if (value == ele) {
                return index;
            }
            index++;
        }
        return -1; // Element not found
    }
    public void insert(int i, int a) {
        if (i < 0 || i > deque.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Deque<Integer> tempDeque = new ArrayDeque<>();
        int index = 0;
        for (int value : deque) {
            if (index == i) {
                tempDeque.add(a); // Insert the new element
            }
            tempDeque.add(value);
            index++;
        }
        if (index == i) {
            tempDeque.add(a); // Insert if at the end
        }
        deque = tempDeque; // Update the original deque
    }
    public void remove(int value) {
        deque.remove(value);
    }
    public int count(int value) {
        int count = 0;
        for (int val : deque) {
            if (val == value) {
                count++;
            }
        }
        return count;
    }
    public int size() {
        return deque.size();
    }
    public int getFront() {
        return deque.peekFirst();
    }
    public int getBack() {
        return deque.peekLast();
    }
    public void extend(int[] values) {
        for (int value : values) {
            append(value);
        }
    }
    public void extendLeft(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            appendLeft(values[i]);
        }
    }
    public void reverse() {
        Deque<Integer> tempDeque = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            tempDeque.addFirst(deque.removeFirst());
        }
        deque = tempDeque;
    }
    public void rotate(int n) {
        if (n < 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                if (!deque.isEmpty()) {
                    deque.addLast(deque.removeFirst());
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!deque.isEmpty()) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }
    }
    public static void main(String[] args) {
        DequeOperations dequeOps = new DequeOperations();
        dequeOps.append(1);
        dequeOps.append(2);
        dequeOps.appendLeft(0);
        System.out.println("Front: " + dequeOps.getFront()); // Output: 0
        System.out.println("Back: " + dequeOps.getBack());   // Output: 2
        System.out.println("Pop left: " + dequeOps.popLeft()); // Output: 0
        System.out.println("Pop right: " + dequeOps.pop());     // Output: 2
        System.out.println("Index of 1: " + dequeOps.index(1)); // Output: 0
        dequeOps.remove(1);
        System.out.println("Size after removal: " + dequeOps.size()); // Output: 0
        dequeOps.extend(new int[]{3, 4, 5});
        System.out.println("Front after extend: " + dequeOps.getFront()); // Output: 3
        dequeOps.reverse();
        System.out.println("Front after reverse: " + dequeOps.getFront()); // Output: 5
    }
}
*/



import java.util.ArrayDeque;
import java.util.Deque;
public class DequeOperations {
    private Deque<Integer> deque;
    public DequeOperations() {
        deque = new ArrayDeque<>();
    }
    public void append(int value) {
        deque.addLast(value);
    }
    public void appendLeft(int value) {
        deque.addFirst(value);
    }
    public int pop() {
        return deque.removeLast();
    }
    public int popLeft() {
        return deque.removeFirst();
    }
    public int index(int ele) {
        int index = 0;
        for (int value : deque) {
            if (value == ele) return index;
            index++;
        }
        return -1;
    }
    public void insert(int i, int a) {
        if (i < 0 || i > deque.size()) throw new IndexOutOfBoundsException();
        Deque<Integer> tempDeque = new ArrayDeque<>();
        int index = 0;
        for (int value : deque) {
            if (index == i) tempDeque.add(a); // Insert the new element
            tempDeque.add(value);
            index++;
        }
        if (index == i) tempDeque.add(a); // Insert at the end if needed
        deque = tempDeque; // Update the original deque
    }
    public void remove(int value) {
        deque.remove(value);
    }
    public int count(int value) {
        return (int) deque.stream().filter(val -> val == value).count();
    }
    public int size() {
        return deque.size();
    }
    public int getFront() {
        return deque.peekFirst();
    }
    public int getBack() {
        return deque.peekLast();
    }
    public void extend(int[] values) {
        for (int value : values) append(value);
    }
    public void extendLeft(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) appendLeft(values[i]);
    }
    public void reverse() {
        Deque<Integer> tempDeque = new ArrayDeque<>();
        while (!deque.isEmpty()) tempDeque.addFirst(deque.removeFirst());
        deque = tempDeque;
    }
    public void rotate(int n) {
        int size = deque.size();
        if (size == 0) return;
        n = ((n % size) + size) % size; // Normalize n
        for (int i = 0; i < n; i++) appendLeft(deque.removeLast());
    }
    public static void main(String[] args) {
        DequeOperations dequeOps = new DequeOperations();
        dequeOps.append(1);
        dequeOps.append(2);
        dequeOps.appendLeft(0);
        System.out.println("Front: " + dequeOps.getFront()); // 0
        System.out.println("Back: " + dequeOps.getBack());   // 2
        System.out.println("Pop left: " + dequeOps.popLeft()); // 0
        System.out.println("Pop right: " + dequeOps.pop());     // 2
        System.out.println("Index of 1: " + dequeOps.index(1)); // 0
        dequeOps.remove(1);
        System.out.println("Size after removal: " + dequeOps.size()); // 0
        dequeOps.extend(new int[]{3, 4, 5});
        System.out.println("Front after extend: " + dequeOps.getFront()); // 3
        dequeOps.reverse();
        System.out.println("Front after reverse: " + dequeOps.getFront()); // 5
    }
}