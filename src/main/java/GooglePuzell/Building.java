package GooglePuzell;

import java.util.Arrays;

public class Building {

    public static void main(String[] args) {

        boolean[][] buildings = {
                {false, true, false}, //0
                {false, false, false}, //1
                {true, false, false}, //2
                {false, true, false}, //3
                //{true, true, true},
                {false, false, true}
        };

        boolean[] requirements = {true, true, true};

        System.out.println("index: " + Arrays.toString(getApartment(buildings, requirements)));
    }

    static int comm = 1000;


    private static int[] getApartment(boolean[][] buildings, boolean[] requirements) {
        int[] result = new int[2];
        boolean[] checklist = {false, false, false};
        for (int i = 0; i < buildings.length; i++) {
            for (int j = i; j < buildings.length; j++) {
                int requirementAvailable = isRequirementAvailable(buildings[j], requirements, checklist);
                if (requirementAvailable != -2) {
                    if (comm > requirementAvailable) {
                        comm = requirementAvailable;
                        result[0] = i;
                        result[1] = comm;
                    }
                    System.out.println("start: " + i + " step: " + requirementAvailable + " arrays: " + Arrays.toString(checklist));
                    checklist = new boolean[]{false, false, false};
                    ctr = -1;
                    break;
                }
            }
        }
        return result;
    }

    static int ctr = -1;

    private static int isRequirementAvailable(boolean[] apartment, boolean[] requirements, boolean[] checklist) {
        ctr++;
        for (int i = 0; i < requirements.length; i++) {
            if (requirements[i]) {
                if (apartment[i] == requirements[i]) {
                    checklist[i] = true;
                }

                if (Arrays.equals(checklist, requirements)) {
                    return ctr;
                }
            }
        }
        return -2;
    }
}
