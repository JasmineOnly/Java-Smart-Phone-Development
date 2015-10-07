package indi.yuanyuam.proj1.scale;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public enum EditOptionEnum {
	EditOptionSetName(1), EditOptionName(2), EditOptionPrice(3);
	private int value;

	
	private EditOptionEnum(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}

}
