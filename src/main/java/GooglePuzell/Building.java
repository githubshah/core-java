package GooglePuzell;

import java.util.Arrays;

public class Building {

    public static void main(String[] args) {

        boolean[][] buildings = {
                {false, true, false},
                {false, false, false},
                {true, false, false},
                {false, true, true},
                //{true, true, true},
                //{true, false, true}
        };

        boolean[] requirements = {true, false, true};

        int index = getApartment(buildings, requirements);
        System.out.println("index: " + Arrays.toString(aa));
    }

    static int comm = 1000;
    static int[] aa = new int[2];

    private static int getApartment(boolean[][] buildings, boolean[] requirements) {
        String a = "";
        boolean[] checklist = {false, false, false};
        for (int i = 0; i < buildings.length; i++) {
            for (int j = i; j < buildings.length; j++) {
                int requirementAvailable = isRequirementAvailable(buildings[j], requirements, checklist);
                if (requirementAvailable != -2) {
                    if (comm > requirementAvailable) {
                        comm = requirementAvailable;
                        aa[0] = i;
                        aa[1] = comm;
                    }
                    System.out.println("start: " + i + " step: " + requirementAvailable);
                    System.out.println("silver " + Arrays.toString(checklist));
                    checklist = new boolean[]{false, false, false};
                    ctr = -1;
                    break;
                }
            }
        }
        return comm;
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
