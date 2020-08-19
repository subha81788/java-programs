import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatternAdapterDemo {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();
        nums.add(34);
        nums.add(2);
        nums.add(12);
        nums.add(1);

        var sortednums = new ListSortAdapter().sort(nums);
        System.out.println(sortednums);
    }
}

// this is target interface; client expects this contract
interface ListSorter {
    public List<Integer> sort(List<Integer> numbers);
}

class ListSortAdapter implements ListSorter {
    // wrapping happens here
    private ArraySorter sorter = new ArraySorterImpl();

    @Override
    public List<Integer> sort(List<Integer> numbers) {
        int[] ns = new int[numbers.size()];
        int i=0;
        for(int n : numbers) {
            ns[i++] = n;
        }
        int[] sortedNumbers = sorter.sort(ns);
        return Arrays.stream(sortedNumbers).boxed().collect(Collectors.toList());
    }
}

// this is 3rd party adaptee interface to make use of
interface ArraySorter {
    public int[] sort(int[] numbers);
}
class ArraySorterImpl implements ArraySorter {
    @Override
    public int[] sort(int[] numbers) {
        Arrays.sort(numbers);
        return numbers;
    }
}
