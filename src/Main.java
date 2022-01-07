import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    HashMap<String, String> recipes = new HashMap<>();
    TreeMap<String, String> recipesOrdered = new TreeMap<>();
    ArrayList<String> recipeItemArrayList = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Integer> nums = new ArrayList<>();

    public Main() throws FileNotFoundException {
        // Inputs the components.dat file
        Scanner sc = new Scanner(new File("U:\\COMPUTER SCIENCE 3\\Components\\src\\components.dat"));
        int num = sc.nextInt();
        sc.nextLine();

        // Puts the recipes into a hashmap
        for (int i=0; i<num; i++){
            String[] line = sc.nextLine().split( " >> ");
            recipes.put(line[0], line[1]);
        }
        //System.out.println(recipes);

        // Takes in the number of recipes to craft
        num = sc.nextInt();
        sc.nextLine();

        // Runs through each recipe and outputs the items needed
        for (int i=0; i<num; i++){
            recipeItemArrayList.clear();
            items.clear();
            nums.clear();

            String recipeItems = recipes.get(sc.nextLine());
            String[] recipeItemArray = recipeItems.split( " ");
            recipeItemArrayList.addAll(Arrays.asList(recipeItemArray));

            // Sets up double ArrayList to traverse
            for (int j=0; j<recipeItemArrayList.size(); j++){

                // Adds a new item if it's not on the list
                if (!items.contains(recipeItemArrayList.get(j))){

                    // If item is a craftable item
                    if (recipes.containsKey(recipeItemArrayList.get(j))){
                        String newItems = recipes.get(recipeItemArrayList.get(j));
                        String[] newItemsArray = newItems.split( " ");
                        recipeItemArrayList.addAll(Arrays.asList(newItemsArray));

                    }
                    /// If item is not on the list
                    else {
                        items.add(recipeItemArrayList.get(j));
                        nums.add(1);
                    }
                }
                // Adds +1 for every duplicate item
                else {
                    for (int k=0; k<items.size(); k++){
                        if (Objects.equals(items.get(k), recipeItemArrayList.get(j))){
                            nums.set(k, nums.get(k)+1);
                        }
                    }
                }
            }

            // Puts items and nums into a TreeMap to sort
            for (int k=0; k<items.size(); k++){
                recipesOrdered.put(items.get(k), "" + nums.get(k) );
            }

            // Prints out the TreeMap using MapEntry
            for (Map.Entry<String, String> entry : recipesOrdered.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            System.out.println("***");
        }


    }
}


