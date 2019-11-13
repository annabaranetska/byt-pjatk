import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class GeneralSortingtemplate{
    private ArrayList <Integer> array;
    protected ArrayList applySorting(ArrayList <Integer> arr){
        array = arr;
        return getSorted(array);
    }
    protected abstract ArrayList getSorted(ArrayList <Integer> arr);

}
class AscendingSort extends GeneralSortingtemplate{
    protected ArrayList getSorted(ArrayList <Integer> arr){
        Collections.sort(arr);
        return arr;
    }

}
class DescendingSort extends GeneralSortingtemplate{
    protected ArrayList getSorted(ArrayList <Integer> arr){
        Comparator c = Collections.reverseOrder();
        Collections.sort(arr, c);
        return arr;
    }
}

public class SortingDemo {
    public static void main(String[] args){
        ArrayList <Integer> list = new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(30);
        list.add(20);
        list.add(40);
        list.add(60);
        GeneralSortingtemplate asc = new AscendingSort();
        GeneralSortingtemplate desc = new DescendingSort();
        System.out.println("Ascending sort: " + asc.applySorting(list));
        System.out.println("Descending sort: " +  desc.applySorting(list));

    }
}
