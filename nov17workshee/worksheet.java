package nov17workshee;

public class worksheet {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,111,1,1,1};
        System.out.println(countClumps(nums));

        String[] answers = {"A","B","C","D","E","F"};
        String[] response = {"A", "B", "?", "G", "E", "?"};

        System.out.println(returnScore(answers, response));
        
    }
    public static int[] fix34(int[] nums) {
        int[] result = new int[nums.length];
        for (int a = 0; a < nums.length; a++ ) {
            result[a] = nums[a];
        }
        for (int i = 0; i < nums.length; i++) {
            if (result[i] == 3) {
                if (result[i+1] != 4) {
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == 4 && result[j-1] != 3) {
                            int temp = result[i+1];
                            result[i+1] = result[j];
                            result[j] = temp;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int countClumps(int[] nums) {
        int totalClumps = 0;
        boolean insideClump = false;
        for (int i = 1; i < nums.length; i++) { 
            if (nums[i] == nums[i-1]) {
                if (!insideClump) {
                    insideClump = true;
                    totalClumps++;
                }
            } else {
                insideClump = false;
            }
        }
        return totalClumps;
    }

    public static int returnScore(String[] key, String[] answers) {
        int score = 0;

        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(answers[i])) {
                score+=4;
            } else if (answers[i].equals("?"))
                score+=0;
            else
                score-=1;
        }
        return score;
    }
}
