package GooglePuzell;

import java.util.Arrays;

public class Building {

    public static void main(String[] args) {

        boolean[][] buildings = {
                {true, false, false, false}, //0
                {false, false, false, false}, //1
                {false, true, false, true}, //2
                {false, false, false, false}, //3
                {false, false, true, false}, //4
                {false, false, false, false}, //5
                {false, false, false, true},//6
                {true, false, false, false} //7
        };

        boolean[] requirements = {true, true, true, true};

        int[] apartment = getApartment(buildings, requirements);
        System.out.println("index: " + Arrays.toString(apartment));
        System.out.println("flat index : " + (((apartment[0] + apartment[1]) / 2)));
    }

    static int minimumSteps = Integer.MAX_VALUE;
    static int ctr = -1;

    private static int[] getApartment(boolean[][] buildings, boolean[] requirements) {
        int[] result = new int[2];
        boolean[] checklist = creatEmptyCheckList(requirements.length);
        for (int i = 0; i < buildings.length; i++) {
            for (int j = i; j < buildings.length; j++) {
                int requirementAvailable = isRequirementAvailable(buildings[j], requirements, checklist);
                if (requirementAvailable != -2) {
                    if (minimumSteps > requirementAvailable) {
                        minimumSteps = requirementAvailable;
                        result[0] = i;
                        result[1] = minimumSteps;
                    }
                    System.out.println("start: " + i + " step: " + requirementAvailable + " arrays: " + Arrays.toString(checklist));
                    checklist = creatEmptyCheckList(requirements.length);
                    ctr = -1;
                    break;
                }
            }
        }
        return result;
    }

    private static boolean[] creatEmptyCheckList(int length) {
        return new boolean[length];
    }

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
