package learning.pattern.iterator;

public class CustomArrayList implements CustomList {
    public String names[] = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new CustomArrayListIterator();
    }

    private class CustomArrayListIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}