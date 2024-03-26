/* 
 *
 * This class provides methods to manage the two lists of tasks.
 * Your code will complete the methods below.
 * author: ashongtical
 */

import java.util.*;
import java.util.Collections;
public class ListsManager {

    // the two lists of tasks    
	public ArrayList <String> highPriority;
    public ArrayList <String> lowPriority;
	
    public TaskListGUI controller; // a reference to the main program, with the GUI

    /* Constructs a ListManager object. */
    public ListsManager(TaskListGUI ref) {
        // (you should not change the code in this method)
        controller = ref;
        highPriority = new ArrayList<String>();
        lowPriority = new ArrayList<String>();

        highPriority.add("return books");
        highPriority.add("finish off practical5 for OOP");
        lowPriority.add("pick up a delivery from Dongyuan");
        lowPriority.add("play basketball");

    /* Initialises both lists, to initially be empty. */
    }

    /* Adds the given task to the end of the low-priority list.
     */
    public void addTask(String task) {
        if (task.contains("*"))
        {
            //highPriority = new ArrayList<String>();
            highPriority.add(task.substring(0, task.length()-1));
        }
        else
        {
            lowPriority.add(task);
        }

    }

    /* Removes the given task to the end of the high-priority list.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that index is a
     * valid position in the relevant list.)
     */
    public void removeLowPriorityTask(int index) {
        lowPriority.remove(index);
    }

    /* Removes the given task from the high-priority list.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that the index is a
     * valid position in the relevant list.)
     */
    public void removeHighPriorityTask(int index) {
        highPriority.remove(index);
    }

    /* Changes the priority of the given task.
     * The given boolean important indicates the previous priority
     * of the task. e.g. if the important is true, then the task was
     * a high-priority task.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that the index is a
     * valid position in the relevant list.)
     */
    public void changePriority(boolean important, int index) {
        if(important)
        {
            lowPriority.addFirst(highPriority.get(index));
            highPriority.remove(index);
        }
        else
        {
            highPriority.add(lowPriority.get(index));
            lowPriority.remove(index);
        }

    }

    /* Produces a string that can be used to save the task lists. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("highPriority task: \n");
        for(String task : highPriority)
        {
            sb.append(task).append('\n');
        }

        sb.append("lowPriority task: \n");
        for(String task: lowPriority)
        {
            sb.append(task).append('\n');
        }

        return sb.toString();
    }

    /* Pushes an important task one higher up.
     * The index gives the current position of the task in the
     * highPriority list. (You can assume that index is a
     * valid position in the highPriority list.)
     */
    public void promote(int index) {
        if(index > 0) {
            Collections.swap(highPriority, index, index - 1);
        }
    }

    void initialiseLists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
