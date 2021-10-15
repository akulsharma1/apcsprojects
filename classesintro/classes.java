package classesintro;

/*

Our class is for a tree.
There are 2 values: branch color and leaf color.
We have both getters and setters for it.
I worked with tanmay garg

*/
public class classes {
    public static void main(String[] args) {
        tree defaulttree = new tree();
        tree nondefault = new tree("White", "Yellow");

        System.out.println(nondefault.returnbranchcolor());
        nondefault.setbranchcolor("green");
        System.out.println(nondefault.returnbranchcolor());

        System.out.println(defaulttree.returnbranchcolor());
        defaulttree.setbranchcolor("red");
        System.out.println(defaulttree.returnbranchcolor());
    }
}

class tree {
    private String branchcolor;
    private String leafcolor;
    public tree() {
        branchcolor = "purple";
        leafcolor = "green";
    }

    public tree(String bcolor, String lcolor) {
        branchcolor = bcolor;
        leafcolor = lcolor;
    }

    public String returnbranchcolor() {
        return branchcolor;
    }

    public String returnleafcolor() {
        return leafcolor;
    }

    public void setbranchcolor(String b) {
        branchcolor = b;
    }
    
    public void setleafcolor(String b) {
        leafcolor = b;
    }

}
