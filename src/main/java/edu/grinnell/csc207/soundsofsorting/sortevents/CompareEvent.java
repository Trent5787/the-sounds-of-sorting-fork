package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> {
    
    private int i;
    private int j;

    public CompareEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
     /**
     * Applies this event to the array.
     * @param arr the array to modify
     */
    public void apply(T[] arr){
        // arr[i].compareTo(arr[j]); what goes here, if anything?
    }

    /**
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices(){
       List<Integer> lst = new ArrayList<>();
       lst.add(i); //is this appropriate?
       lst.add(j);
       return(lst);
    }

    /**
     * @return <code>true</code> iff this event is emphasized
     */
    public boolean isEmphasized(){
        return false;
    }
}
