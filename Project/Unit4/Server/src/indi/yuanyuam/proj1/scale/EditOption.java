package indi.yuanyuam.proj1.scale;

import indi.yuanyuam.proj1.model.*;
import indi.yuanyuam.proj1.exception.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class EditOption extends Thread {
	private Automobile editedAuto;// The Automobile object need to be edited
	private int threadID;
	private EditOptionEnum editOptionEnum;
	/*
	 * editedInfo[0]: model name editedInfo[1]: option set name editedInfo[2]:
	 * option name editedInfo[3]: new option set name or new option name or new
	 * price
	 */
	private String[] editedInfo;

	// Constructor with parameters
	public EditOption(Automobile editedAuto, int threadID, String[] editedInfo,
			EditOptionEnum editOptionEnum) {
		super();
		this.editedAuto = editedAuto;
		this.threadID = threadID;
		this.editedInfo = editedInfo;
		this.editOptionEnum = editOptionEnum;
	}

	// Override the run method
	@Override
	public void run() {
		switch (editOptionEnum.getValue()) {
		case 1:
			ThreadUpdateOptionSetName();
			break;
		case 2:
			ThreadUpdateOptionName();
			break;
		case 3:
			ThreadUpdateOptionPrice();
			break;
		default:
			break;
		}
	}

	// Method to edit option set name
	public void ThreadUpdateOptionSetName() {

		synchronized (editedAuto) {
			String[] optionSetNameList = { editedInfo[1], "Set1", "Set2",
					"Set3", editedInfo[1] };
			for (int i = 0; i < optionSetNameList.length - 1; i++) {
				// wait for a random time
				randomWait();

				/*
				 * update option set name optionSetNameList[i] is the old name
				 * optionSetNameList[i+1] is the new name
				 */
				editedAuto.updateOptionSetName(optionSetNameList[i],
						optionSetNameList[i + 1]);
				try {
					System.out
							.println("Thread"
									+ threadID
									+ " : "
									+ "Change Option Set Name From "
									+ optionSetNameList[i]
									+ " To "
									+ editedAuto
											.getOptionSetName(optionSetNameList[i + 1]));
				} catch (AutoException e) {
					e.printStackTrace();
				}
			}

		}
	}

	// Method to edit option name
	public void ThreadUpdateOptionName() {
		synchronized (editedAuto) {
			String[] optionNameList = { editedInfo[2], "Op1", "Op2", "Op3",
					editedInfo[2] };
			for (int i = 0; i < optionNameList.length - 1; i++) {
				// wait for a random time
				randomWait();
				/*
				 * Update the option name editedInfo[1]: option set name
				 * optionNameList[i]: option name optionNameList[i+1]: new
				 * option name
				 */
				editedAuto.updateOptionName(editedInfo[1], optionNameList[i],
						optionNameList[i + 1]);
				try {
					System.out.println("Thread"
							+ threadID
							+ " : "
							+ "Change Option Set Name From "
							+ optionNameList[i]
							+ " To "
							+ editedAuto.getOptionName(editedInfo[1],
									optionNameList[i + 1]));
				} catch (AutoException e) {
					e.printStackTrace();
				}

			}
		}

	}

	// Method to edit option price
	public void ThreadUpdateOptionPrice() {
		for (int i = 0; i < 5; i++) {
			synchronized (editedAuto) {
				// wait for a random time
				randomWait();
				
				/*
				 * Update the option editedInfo[1]: option set name
				 * editedInfo[2]: option name 
				 *
				 */
				editedAuto.updateOptionPrice(editedInfo[1], editedInfo[2],
						i*1000);
				System.out.println("Thread" + threadID + " : "
						+ "Change Option Set Price To " + i*1000);
			}
		}

	}

	// Method to let thread to wait a random time
	void randomWait() {
		try {
			Thread.currentThread();
			Thread.sleep((long) (3000 * Math.random()));
		} catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}

	}
}