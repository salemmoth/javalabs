import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListHospital {
    private List<Hospital>list=new ArrayList<>();

    Hospital get(int i){
        return list.get(i);
    }
    int size(){return list.size(); }

    void add(Hospital dep){
        list.add(dep);
    }
    void remove(int i){
        list.remove(i);
    }
    void print(int i) {
         System.out.println((Hospital) list.toArray()[i]); }

    void sort(int f){
        if(f==1)
            list.sort(Comparator.comparing(Hospital::getNameOfHospital));
        if (f==2)
            list.sort(Comparator.comparing(Hospital::getFIOofDirector));
    }

}
