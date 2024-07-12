public class List<Type> {

    private Type[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Type element) {
        if (this.values.length == this.firstFreeIndex) {
            grow();
        }
        this.values[this.firstFreeIndex] = element;
        this.firstFreeIndex++;
    }

    private void grow() {
        // Replaces values with new array 1.5 times longer
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];

        for (int i=0; i < this.firstFreeIndex; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }

    public int indexOf(Type element) {
        for (int i=0; i < this.firstFreeIndex; i++) {
            if (this.values[i] == element || this.values[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Type element) {
        return indexOf(element) > 0;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.values.length - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public void remove(Type element) {
        int elementIndex = indexOf(element);
        if (elementIndex < 0) {
            return;
        }
        shiftLeft(elementIndex);
        this.firstFreeIndex--;
    }

    public Type value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }
    
        return this.values[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }

}
