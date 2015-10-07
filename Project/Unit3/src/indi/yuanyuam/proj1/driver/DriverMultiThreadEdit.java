package indi.yuanyuam.proj1.driver;

import indi.yuanyuam.proj1.adapter.*;
import indi.yuanyuam.proj1.scale.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class DriverMultiThreadEdit {

	public static void main(String[] args) {
		BuildAuto auto = new BuildAuto();
		auto.buildAuto("FocusWagonZTW.txt");
		
		/*
		 * Test the editing option set name
		 */
		// editedInfo: [0]model name, [1]option set name,[2]option name [3]new
		// option set name
		String[] editedInfo1 = { "Focus Wagon ZTW", "Color", "", "newColor" };
		String[] editedInfo2 = { "Focus Wagon ZTW", "Color", "", "newColor" };

		// edit auto to edit option set name
		auto.edit(EditOptionEnum.EditOptionSetName, editedInfo1);
		auto.edit(EditOptionEnum.EditOptionSetName, editedInfo2);
		
		/*
		 * Test the editing option name
		 */
		// editedInfo: [0]model name, [1]option set name,[2]option name [3]new
		// option name
		String[] editedInfo3 = { "Focus Wagon ZTW", "Color",
				"Fort Knox Gold Clearcoat Metallic", "newName" };
		String[] editedInfo4 = { "Focus Wagon ZTW", "Color",
				"Fort Knox Gold Clearcoat Metallic", "newName" };

		// edit auto to edit option name
		auto.edit(EditOptionEnum.EditOptionName, editedInfo3);
		auto.edit(EditOptionEnum.EditOptionName, editedInfo4);

		/*
		 * Test the editing option price
		 */
		// editedInfo: [0]model name, [1]option set name,[2]option name [3]new
		// option price
		String[] editedInfo5 = { "Focus Wagon ZTW", "Color",
				"Fort Knox Gold Clearcoat Metallic", "1000" };
		String[] editedInfo6 = { "Focus Wagon ZTW", "Color",
				"Fort Knox Gold Clearcoat Metallic", "1000" };

		// edit auto to edit option name
		auto.edit(EditOptionEnum.EditOptionPrice, editedInfo5);
		auto.edit(EditOptionEnum.EditOptionPrice, editedInfo6 );

	}
}
