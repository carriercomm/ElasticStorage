package instance.common;

import instance.cpu.OperationDuration;


/**
 * 
 * @author Amir Moulavi
 * @date 2011-03-20
 *
 */

public class MemoryWriteOperation extends AbstractOperation {

	private long blockSize;

	public MemoryWriteOperation(long blockSize) {
		this.blockSize = blockSize;
	}
	
	@Override
	public long getDuration(long cpuSpeed) {
		return OperationDuration.getMemoryWriteDuration(cpuSpeed, blockSize);
	}

	@Override
	public int getNumberOfOperations() {
		return 1;
	}

}
