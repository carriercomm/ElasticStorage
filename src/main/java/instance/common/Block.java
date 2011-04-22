package instance.common;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 
 * @author Amir Moulavi
 * @date 2011-03-19
 *
 */

public class Block implements Serializable {

	private static final long serialVersionUID = -9129663729280247524L;
	private String name;
	private long size;
	private long accessed = 0;
	private long timeEnteredInMemory = 0;
	
	public Block(String name, long size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public long getSize() {
		return size;
	}
	
	public synchronized void accessed() {
		accessed++;
	}
	
	public long getNrOfAccessedTimes() {
		return accessed;
	}

	public long getTimeEnteredInMemory() {
		return timeEnteredInMemory;
	}

	public void setTimeEnteredInMemory(long timeEnteredInMemory) {
		this.timeEnteredInMemory = timeEnteredInMemory;
	}
	
	public static class FrequencyComparator implements Comparator<Block> {
		
		@Override
		public int compare(Block o1, Block o2) {
			if (o1.getNrOfAccessedTimes() < o2.getNrOfAccessedTimes()) return 1;
			else if (o1.getNrOfAccessedTimes() == o2.getNrOfAccessedTimes()) {
				if ( o1.getTimeEnteredInMemory() < o2.getTimeEnteredInMemory() ) return 1;
				else if (o1.getTimeEnteredInMemory() == o2.getTimeEnteredInMemory()) return -1;
				else return 0;
			}
			else return -1;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
			sb.append("name: ").append(name).append(", ");
			sb.append("size: ").append(size).append(", ");
		sb.append("}");
		return sb.toString();
	}
}

