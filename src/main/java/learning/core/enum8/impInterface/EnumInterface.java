package learning.core.enum8.impInterface;

interface EnumInterface {
    int calculate(int first, int second);
}

enum EnumClassOperatorEnum implements EnumInterface { // An Enum implements an interface
    ADD {
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    },
    SUBTRACT {
        @Override
        public int calculate(int first, int second) {
            return first - second;
        }
    };
}