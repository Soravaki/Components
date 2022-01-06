import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    HashMap<String, String> recipes = new HashMap<String, String>();
    public Main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("U:\\COMPUTER SCIENCE 3\\Components\\src\\components.dat"));
        int num = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<num; i++){
            Split(sc.nextLine());
        }
        System.out.println(recipes);


        num = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<num; i++){
            String sentence = recipes.get(sc.nextLine());
            String[] line = sentence.split( " ");
            ArrayList<String> items = new ArrayList<>();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int j=0; j<line.length; j++){
                if (!items.contains(line[j])){
                    
                    items.add(line[i]);
                    nums.add(1);
                }
                else {
                    for (int k=0; k<items.size(); k++){
                        if (Objects.equals(items.get(k), line[i])){
                            nums.set(k, nums.get(k)+1);
                        }
                    }
                }
            }
            for (int k=0; k<items.size(); k++){
                System.out.println(items.get(k) +" "+ nums.get(k) );
            }
            System.out.println("***");
        }


    }
    public void Split(String s){
        String[] line = s.split( " >> ");
        System.out.println(line.length);
        recipes.put(line[0], line[1]);
    }
}


