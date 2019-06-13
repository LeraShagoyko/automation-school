import java.util.Comparator;

public class ChildAgeComparator implements Comparator<Child>
{
    public int compare(Child object1, Child object2)
    {
        return object1.getAge().compareTo(object2.getAge());
    }
}