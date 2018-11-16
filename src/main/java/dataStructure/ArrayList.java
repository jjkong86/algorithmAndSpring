package dataStructure;

public class ArrayList {
	private int size = 0;
    private Object[] elementData = new Object[100];
    
    public boolean addLast(Object element) {
    	elementData[size] = element;
    	size++;
    	return true;
    }

	public void add(int index, int element) {
		for (int i = size-1; i >= index ; i--) {
			elementData[i+1] = elementData[i]; 
		}
		elementData[index] = element;
		size++;
	}
	
	public void addFirst(int element) {
		add(0, element);
	}
	
	public void removeIndex(int index) {
		for (int i = index; i < size; i++) {
			elementData[i] = elementData[i+1];
		}
		size--;
		elementData[size] = null;
	}
	
	public void removeElement(int element) {
		for (int i = 0; i < size; i++) {
			if(Integer.valueOf(String.valueOf(elementData[i])) == element) {
				removeIndex(i);
			}
		}
	}
	
	public String printString() {
		String str = "size = "+(size-1)+", [";
	    for(int i=0; i < size; i++){
	        str += elementData[i];
	        if(i < size-1){
	            str += ",";
	        }
	    }
	    return str + "]";
	}
}
