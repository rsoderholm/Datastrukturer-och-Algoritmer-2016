package p2;

/**
 * Created by Robin on 2016-09-22.
 */
public class Entry {
    private Object key;
    private Object value;

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        Entry keyToCompare = new Entry(obj, null);
        return key.equals(keyToCompare.key);
    }

}





