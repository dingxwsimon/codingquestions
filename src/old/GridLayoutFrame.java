package old;

// Fig. 11.43: GridLayoutFrame.java
// Demonstrating GridLayout.
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutFrame extends JFrame implements ActionListener {
    private JButton buttons[]; // array of buttons
    private final String names[] = { "0", "1", "2", "3", "4", "5", "6", "7",
	    "8", "9", "10", "11", "12", "13", "14", "", "Hint" };
    private boolean toggle = true; // toggle between two layouts
    private Container container; // frame container
    private GridLayout gridLayout1; // first gridlayout
    private GridLayout gridLayout2; // second gridlayout

    int buttonpos[][] = { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11 },
	    { 12, 13, 14, 15 } };

    int xindex[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int yindex[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int indicator1 = 0, indicator2 = 0;
    int indicator3 = 0, indicator4 = 0;

    // no-argument constructor
    public GridLayoutFrame() {
	super("GridLayout Demo");
	gridLayout1 = new GridLayout(5, 4, 5, 5); // 4 by 4; gaps of 5
	gridLayout2 = new GridLayout(5, 4); // 4 by 4; no gaps
	container = getContentPane(); // get content pane
	setLayout(gridLayout1); // set JFrame layout
	buttons = new JButton[names.length]; // create array of JButtons

	for (int count = 0; count < names.length; count++) {
	    buttons[count] = new JButton(names[count]);
	    buttons[count].addActionListener(this); // register listener
	    add(buttons[count]); // add button to JFrame
	} // end for
    } // end GridLayoutFrame constructor

    // handle button events by toggling between layouts
    /*
     * public void actionPerformed( ActionEvent event ) { if ( toggle )
     * container.setLayout( gridLayout2 ); // set layout to second else
     * container.setLayout( gridLayout1 ); // set layout to first toggle =
     * !toggle; // set toggle to opposite value container.validate(); //
     * re-layout container } // end method actionPerformed
     */
    public void actionPerformed(ActionEvent event) {
	String x;
	int i = 0, j = 0, ix = 0;
	int hi, hj, mi, mj; // matrix index of hole and button
	int xSpace, ySpace, xm, ym, hx, hy, temp;

	x = event.getActionCommand();

	System.out.println(x + " clicked");

	if (x != "Hint") {
	    ix = Integer.parseInt(x);

	    if (ix == 16)
		return;

	    // Find where the hole is
	    outer: for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++) {
		    if (buttonpos[i][j] == 15)
			break outer;
		}
	    hi = i;
	    hj = j;
	    System.out.println("Before the click");
	    System.out.println("The hole is located at (" + hi + ", " + hj
		    + ")");

	    outer2: for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++) {
		    if (buttonpos[i][j] == ix)
			break outer2;
		}
	    mi = i;
	    mj = j;

	    xSpace = buttons[15].getX();
	    ySpace = buttons[15].getY();

	    System.out.println("The button is located at (" + mi + ", " + mj
		    + ")");
	    System.out.println("Button pos array is");
	    for (int k = 0; k < 4; k++)
		for (int k1 = 0; k1 < 4; k1++)
		    System.out.print(buttonpos[k][k1] + " ");
	    System.out.println("");

	    if ((hi == mi && hj == mj + 1)
		    || // hole as the immediate neighbor of button)
		    (hi == mi && hj == mj - 1) || (hi == mi + 1 && hj == mj)
		    || (hi == mi - 1 && hj == mj)) {
		// buttonpos [mi][mj] = 5;
		// buttonpos [hi][hj] = ix;
		// switch button and hole

		buttons[15].setLocation(buttons[buttonpos[mi][mj]]
			.getLocation());
		// buttons[5].setY(ym);

		buttons[buttonpos[mi][mj]].setLocation(xSpace, ySpace);
		buttonpos[mi][mj] = 15;
		buttonpos[hi][hj] = ix;
		System.out.println("After the click");
		System.out.println("The new button sequence is");
		for (int k2 = 0; k2 < 4; k2++)
		    for (int k3 = 0; k3 < 4; k3++)
			System.out.print(buttonpos[k2][k3] + "  ");
		System.out.println("");

	    } // end of if
	}
	// when "Hint" is clicked
	else {
	    for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++) {
		    xindex[buttonpos[i][j]] = j;
		    yindex[buttonpos[i][j]] = i;
		}
	    for (i = 0; i < 16; i++) {
		System.out.print(i + ":" + xindex[i] + " " + yindex[i] + " ,");
	    }
	    int k = 0;
	    for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++) {
		    if ((i * 4 + j < 15)
			    && (buttonpos[i][j] == Integer.parseInt(names[i * 4
				    + j])))
			k++;
		}
	    if (k == 15)
		System.out.println("No MOVE needed!!");
	    else if ((yindex[0] != 0) | (xindex[0] != 0))
	    // move button 0 to upper left corner
	    {
		// if the space is right above or on the right of button 0
		if (((xindex[0] - xindex[15] == 1) && (yindex[0] == yindex[15]))
			| ((yindex[0] - yindex[15] == 1) && (xindex[0] == xindex[15]))) { // toggle
											  // space
											  // with
											  // button
											  // 0
		    ToggleNumSpace(0);
		} else {
		    // move space towards button 0
		    // if the space is above button 0, move the space down
		    // if the both space and button 0 on the first row and space
		    // is to the
		    // right of button 0
		    // we also need move space down
		    if (((xindex[0] == xindex[15]) && (yindex[15] < yindex[0]))
			    | ((yindex[15] == yindex[0]) && (yindex[0] == 0) && (xindex[15] > xindex[0]))) {
			// move space down
			MoveSpaceDown();
		    }
		    // if the space is on the left of button 0, move the space
		    // to the
		    // right
		    // if the space is below button 0 and button 0 is on the 1st
		    // column,
		    // also move the space to the right
		    else if (((xindex[0] > xindex[15]) && (yindex[15] <= yindex[0]))
			    | ((xindex[15] == xindex[0]) && (xindex[0] == 0) && (yindex[0] < yindex[15]))) {
			MoveSpaceRight();
		    }
		    // if the space is below button 0 and button 0 is not on the
		    // 1st
		    // column,
		    // move the space to the left
		    // if space is on the left up to button 0 or button 0 is on
		    // the 1st
		    // row,
		    // space is on the right side, also move space to the left
		    else if (((xindex[15] == xindex[0]) && (xindex[0] != 0) && (yindex[0] < yindex[15]))
			    | ((xindex[15] > xindex[0]) && (yindex[15] < yindex[0]))
			    | ((yindex[0] == 0) && (xindex[15] + 1 > xindex[0]))) {
			MoveSpaceLeft();
		    }
		    // if the space is on the lower row of button 0, move space
		    // up, also
		    // if space is
		    // on the left of button 0, it needs to be moved to one
		    // level above
		    // button 0
		    else if (((yindex[15] > yindex[0]) && (xindex[0] > xindex[15]))
			    | ((xindex[0] < xindex[15])
				    && (yindex[15] + 1 >= yindex[0]) && (yindex[0] != 0))) {
			MoveSpaceUp();
		    }
		}

	    } else if ((yindex[1] != 0) | (xindex[1] != 1)) {
		if (xindex[1] >= 1) {
		    // when button 1 is on right panel, move it to upper left
		    // corner (1,0)
		    // if the space is on the right and button 1 is not on the
		    // 2nd column,
		    // if the space is above button 1, toggle space with button
		    // 1
		    if (((xindex[1] - xindex[15] == 1)
			    && (yindex[1] == yindex[15]) && (xindex[1] != 1))
			    | ((yindex[1] - yindex[15] == 1) && (xindex[1] == xindex[15]))) { // toggle
											      // space
											      // with
											      // button
											      // 1
			ToggleNumSpace(1);
		    }
		    // when space is above button 1 and when both button 1 and
		    // space on
		    // 1st row
		    // space is to the right of button 1, move space down
		    // when space is in (0,1), button 1 in (1,1), move space
		    // down
		    else if (((xindex[1] == xindex[15]) && (yindex[15] < yindex[1]))
			    | ((yindex[15] == yindex[1]) && (yindex[1] == 0) && (xindex[15] > xindex[1]))
			    | ((xindex[1] == 1) && (yindex[15] == 1)
				    && (xindex[15] == 0) && (yindex[1] == 1))) {
			// move space down
			MoveSpaceDown();
		    }
		    // when space is on the left side of button 1, move space to
		    // the right
		    // when both space and button 1 on the 2nd column, and space
		    // is below
		    // button 1
		    // move space to the right
		    // when button 1 is on the 2nd column, space is on the 1st
		    // column and
		    // they are not on the same row
		    // move space to the right
		    else if (((xindex[1] > xindex[15])
			    && (yindex[15] <= yindex[1]) && (xindex[1] != 1))
			    | ((xindex[15] == xindex[1]) && (xindex[1] == 1) && (yindex[1] < yindex[15]))
			    | ((xindex[1] == 1) && (xindex[15] == 0) && (yindex[15] != yindex[1]))
			    | ((xindex[15] == 0) && (yindex[1] == 0) && (yindex[15] == 1))) {
			MoveSpaceRight();
		    }
		    // if the space is below button 1 and button 1 is not on the
		    // 1st
		    // column,
		    // move the space to the left
		    // if space is on the left up to button 1 or button 1 is on
		    // the 1st
		    // row,
		    // space is on the right side, also move space to the left
		    else if (((xindex[15] == xindex[1]) && (xindex[1] != 0) && (yindex[1] < yindex[15]))
			    | ((xindex[15] > xindex[1]) && (yindex[15] < yindex[1]))
			    | ((yindex[1] == 0) && (xindex[15] + 1 > xindex[1]))) {
			MoveSpaceLeft();
		    }
		    // if the space is on the lower row of button 1, move space
		    // up, also
		    // if space is
		    // on the left of button 1, it needs to be moved to one
		    // level above
		    // button 1
		    // if
		    else if (((yindex[15] > yindex[1]) && (xindex[1] > xindex[15]))
			    | ((xindex[1] < xindex[15])
				    && (yindex[15] + 1 >= yindex[1]) && (yindex[1] != 0))
			    | ((xindex[1] == 1) && (xindex[15] == 0)
				    && (yindex[15] == yindex[1]) && (yindex[15] != 1))) {
			MoveSpaceUp();
		    }
		}
		// when button 1 is on the left panel
		else {
		    // when button 1 is on left panel, move it to right
		    // if the space is right above button 1, move button 1 up
		    if (((xindex[15] - xindex[1] == 1) && (yindex[1] == yindex[15]))
			    | ((yindex[1] - yindex[15] == 1) && (xindex[1] == xindex[15]))) { // toggle
											      // space
											      // with
											      // button
											      // 1
			ToggleNumSpace(1);
		    }
		    // move the space to the right of button 1
		    // Move Space Up when space is lower than button 1
		    else if ((yindex[15] > yindex[1])
			    && (xindex[15] != xindex[1]))
			MoveSpaceUp();
		    // Move space down when space is upper than button 1
		    else if ((yindex[15] < yindex[1])
			    && (xindex[15] != xindex[1]))
			MoveSpaceDown();
		    // when Space and button 1 on the same level, move space
		    // left towards
		    // button 1
		    else if ((yindex[15] == yindex[1])
			    && (xindex[15] > xindex[1]))
			MoveSpaceLeft();
		    // if space is below button 1, it needs to be moved right
		    else
			MoveSpaceRight();
		}
	    }
	    // make sure button 2 and button 3 are in the right spot
	    else if ((yindex[2] != 0) | (xindex[2] != 2) | (yindex[3] != 0)
		    | (xindex[3] != 3)) {
		// make sure button 2 is at (3,0), button 3 is at (3,1)
		if (((yindex[2] != 0) | (xindex[2] != 3) | (yindex[3] != 1) | (xindex[3] != 3))
			&& (indicator1 == 0)) {
		    if ((yindex[2] != 0) | (xindex[2] != 3)) {
			// if the space is right above or on the left of button
			// 2
			if (((xindex[15] - xindex[2] == 1) && (yindex[2] == yindex[15]))
				| ((yindex[2] - yindex[15] == 1) && (xindex[2] == xindex[15]))) { // toggle
												  // space
												  // with
												  // button
												  // 2
			    ToggleNumSpace(2);
			}
			// move space towards button 2
			// Move space down when space is above button 2
			// Move space down when space is on the same level with
			// button 2,
			// but they are not on last row and the space is on the
			// left of
			// button 2
			else if (((xindex[2] == xindex[15]) && (yindex[15] < yindex[2]))
				| ((xindex[2] > xindex[15])
					&& (yindex[15] == yindex[2])
					&& (yindex[2] != 3) && (xindex[2] != 3))
				| ((yindex[2] - yindex[15] >= 1) && (xindex[2] < xindex[15])))
			    MoveSpaceDown();
			// Move space left when space is on the right side of
			// button 2
			// Also when both space and button 2 are on the 4th
			// column
			else if (((xindex[2] < xindex[15] - 1))
				| ((xindex[2] == xindex[15])
					&& (xindex[2] == 3) && (yindex[2] < yindex[15])))
			    MoveSpaceLeft();
			// move space up when space is lower right to button 2
			// also when both space and button 2 are last row and
			// space is on
			// the left of button 2
			// move space up when space is right
			else if (((xindex[15] > xindex[2]) && (yindex[15] > yindex[2]))
				| ((xindex[2] > xindex[15])
					&& (yindex[15] == yindex[2]) && (yindex[2] == 3))
				| ((xindex[2] == 3) && (yindex[2] <= yindex[15])))
			    MoveSpaceUp();
			// move space right when space is to the left of button
			// 2, but
			// button 2 is not at 4th column
			else if (((xindex[2] >= xindex[15]) && (xindex[2] != 3))
				| ((xindex[2] >= xindex[15])
					&& (xindex[2] == 3) && (xindex[15] < 2))
				| ((xindex[2] == 3) && (yindex[2] > yindex[15])))
			    MoveSpaceRight();
		    } else if ((yindex[3] != 1) | (xindex[3] != 3)) {
			if ((yindex[3] == 0) && (xindex[3] == 2)) {
			    // dead point for button 3
			} else {
			    // if the space is right above or on the left of
			    // button 3
			    if (((xindex[15] - xindex[3] == 1) && (yindex[3] == yindex[15]))
				    | ((yindex[3] - yindex[15] == 1) && (xindex[3] == xindex[15]))) { // toggle
												      // space
												      // with
												      // button
												      // 3
				ToggleNumSpace(3);
			    }
			    // move space towards button 3
			    // Move space down when space is above button 3
			    // Move space down when space is on the same level
			    // with button 3,
			    // but they are not on last row and the space is on
			    // the left of
			    // button 3
			    else if (((xindex[3] == xindex[15]) && (yindex[15] < yindex[3]))
				    | ((xindex[3] > xindex[15])
					    && (yindex[15] == yindex[3])
					    && (yindex[3] != 3) && (xindex[3] != 3))
				    | ((yindex[3] - yindex[15] >= 1) && (xindex[3] < xindex[15])))
				MoveSpaceDown();
			    // Move space left when space is on the right side
			    // of button 3
			    // Also when both space and button 3 are on the 4th
			    // column
			    else if (((xindex[3] < xindex[15] - 1))
				    | ((xindex[3] == xindex[15])
					    && (xindex[3] == 3) && (yindex[3] < yindex[15])))
				MoveSpaceLeft();
			    // move space up when space is lower right to button
			    // 3
			    // also when both space and button 3 are last row
			    // and space is on
			    // the left of button 3
			    // move space up when space is right
			    else if (((xindex[15] > xindex[3]) && (yindex[15] > yindex[3]))
				    | ((xindex[3] > xindex[15])
					    && (yindex[15] == yindex[3]) && (yindex[3] == 3))
				    | ((xindex[3] == 3) && (yindex[3] <= yindex[15])))
				MoveSpaceUp();
			    // move space right when space is to the left of
			    // button 3, but
			    // button 3 is not at 4th column
			    else if (((xindex[3] >= xindex[15]) && (xindex[3] != 3))
				    | ((xindex[3] >= xindex[15])
					    && (xindex[3] == 3) && (xindex[15] < 2))
				    | ((xindex[3] == 3) && (yindex[3] > yindex[15])))
				MoveSpaceRight();
			}
		    }
		} else {
		    // move space to (2,0) and also push button 2, 3 to (2,0)
		    // and (3,0)
		    if ((xindex[15] == 3) && (xindex[2] == 3)
			    && (yindex[2] == 0)) {
			MoveSpaceLeft();
			indicator1 = 1;
		    } else if (yindex[15] != 0) {
			MoveSpaceUp();
			indicator1 = 1;
		    } else if ((yindex[15] == 0) && (xindex[15] == 2)
			    && (xindex[2] == 3) && (yindex[2] == 0))
			ToggleNumSpace(2);
		    else if ((yindex[15] == 0) && (xindex[15] == 3)
			    && (xindex[3] == 3) && (yindex[3] == 1)) {
			ToggleNumSpace(3);
			indicator1 = 0;
		    }
		}
	    } else if ((yindex[4] != 1) | (xindex[4] != 0))
	    // move button 4 to (0,1)
	    {
		// if the space is right above or on the right of button 4
		if (((xindex[4] - xindex[15] == 1) && (yindex[4] == yindex[15]))
			| ((yindex[4] - yindex[15] == 1) && (xindex[4] == xindex[15]))) { // toggle
											  // space
											  // with
											  // button
											  // 4
		    ToggleNumSpace(4);
		} else {
		    // move space towards button 4
		    // if the space is above button 4, move the space down
		    // if the both space and button 4 on the 2nd row and space
		    // is to the
		    // right of button 4
		    // we also need move space down
		    if (((xindex[4] == xindex[15]) && (yindex[15] < yindex[4]))
			    | ((yindex[15] == yindex[4]) && (yindex[4] == 1) && (xindex[15] > xindex[4]))) {
			// move space down
			MoveSpaceDown();
		    }
		    // if the space is on the left of button 4, move the space
		    // to the
		    // right
		    // if the space is below button 4 and button 4 is on the 1st
		    // column,
		    // also move the space to the right
		    else if (((xindex[4] > xindex[15]) && (yindex[15] <= yindex[4]))
			    | ((xindex[15] == xindex[4]) && (xindex[4] == 0) && (yindex[4] < yindex[15]))) {
			MoveSpaceRight();
		    }
		    // if the space is below button 4 and button 4 is not on the
		    // 1st
		    // column,
		    // move the space to the left
		    // if space is on the left up to button 4 or button 4 is on
		    // the 1st
		    // row,
		    // space is on the right side, also move space to the left
		    else if (((xindex[15] == xindex[4]) && (xindex[4] != 0) && (yindex[4] < yindex[15]))
			    | ((xindex[15] > xindex[4]) && (yindex[15] < yindex[4]))
			    | ((yindex[4] == 1) && (xindex[15] + 1 > xindex[4]))) {
			MoveSpaceLeft();
		    }
		    // if the space is on the lower row of button 4, move space
		    // up, also
		    // if space is
		    // on the left of button 4, it needs to be moved to one
		    // level above
		    // button 4
		    else if (((yindex[15] > yindex[4]) && (xindex[4] > xindex[15]))
			    | ((xindex[4] < xindex[15])
				    && (yindex[15] + 1 >= yindex[4]) && (yindex[4] != 1))) {
			MoveSpaceUp();
		    }
		}

	    } else if ((yindex[5] != 1) | (xindex[5] != 1)) {
		if (xindex[5] >= 1) {
		    // when button 5 is on right panel, move it to upper left
		    // corner (1,1)
		    // if the space is on the right and button 5 is not on the
		    // 2nd column,
		    // if the space is above button 5, toggle space with button
		    // 5
		    if (((xindex[5] - xindex[15] == 1)
			    && (yindex[5] == yindex[15]) && (xindex[5] != 1))
			    | ((yindex[5] - yindex[15] == 1) && (xindex[5] == xindex[15]))) { // toggle
											      // space
											      // with
											      // button
											      // 1
			ToggleNumSpace(5);
		    }
		    // when space is above button 5 and when both button 5 and
		    // space on
		    // 2nd row
		    // space is to the right of button 5, move space down
		    // when space is in (0,2), button 5 in (1,2), move space
		    // down
		    else if (((xindex[5] == xindex[15]) && (yindex[15] < yindex[5]))
			    | ((yindex[15] == yindex[5]) && (yindex[5] == 1) && (xindex[15] > xindex[5]))
			    | ((xindex[5] == 1) && (yindex[15] == 2)
				    && (xindex[15] == 0) && (yindex[5] == 2))) {
			// move space down
			MoveSpaceDown();
		    }
		    // when space is on the left side of button 5, move space to
		    // the right
		    // when both space and button 5 on the 2nd column, and space
		    // is below
		    // button 1
		    // move space to the right
		    // when button 5 is on the 2nd column, space is on the 1st
		    // column and
		    // they are not on the same row
		    // move space to the right
		    else if (((xindex[5] > xindex[15])
			    && (yindex[15] <= yindex[5]) && (xindex[5] != 1))
			    | ((xindex[15] == xindex[5]) && (xindex[5] == 1) && (yindex[5] < yindex[15]))
			    | ((xindex[5] == 1) && (xindex[15] == 0) && (yindex[15] != yindex[5]))
			    | ((xindex[15] == 0) && (yindex[5] == 1) && (yindex[15] == 2))) {
			MoveSpaceRight();
		    }
		    // if the space is below button 5 and button 5 is not on the
		    // 1st
		    // column,
		    // move the space to the left
		    // if space is on the left up to button 5 or button 5 is on
		    // the 2nd
		    // row,
		    // space is on the right side, also move space to the left
		    else if (((xindex[15] == xindex[5]) && (xindex[5] != 0) && (yindex[5] < yindex[15]))
			    | ((xindex[15] > xindex[5]) && (yindex[15] < yindex[5]))
			    | ((yindex[5] == 1) && (xindex[15] + 1 > xindex[5]))) {
			MoveSpaceLeft();
		    }
		    // if the space is on the lower row of button 5, move space
		    // up, also
		    // if space is
		    // on the left of button 5, it needs to be moved to one
		    // level above
		    // button 5
		    // if
		    else if (((yindex[15] > yindex[5]) && (xindex[5] > xindex[15]))
			    | ((xindex[5] < xindex[15])
				    && (yindex[15] + 1 >= yindex[5]) && (yindex[5] != 1))
			    | ((xindex[5] == 1) && (xindex[15] == 0)
				    && (yindex[15] == yindex[5]) && (yindex[15] != 2))) {
			MoveSpaceUp();
		    }
		}
		// when button 5 is on the left panel
		else {
		    // when button 5 is on left panel, move it to right
		    // if the space is right or above button 5, move button 5 up
		    if (((xindex[15] - xindex[5] == 1) && (yindex[5] == yindex[15]))
			    | ((yindex[5] - yindex[15] == 1) && (xindex[5] == xindex[15]))) { // toggle
											      // space
											      // with
											      // button
											      // 1
			ToggleNumSpace(5);
		    }
		    // move the space to the right of button 5
		    // Move Space Up when space is lower than button 5
		    else if ((yindex[15] > yindex[5])
			    && (xindex[15] != xindex[5]))
			MoveSpaceUp();
		    // Move space down when space is upper than button 5
		    else if ((yindex[15] < yindex[5])
			    && (xindex[15] != xindex[5]))
			MoveSpaceDown();
		    // when Space and button 5 on the same level, move space
		    // left towards
		    // button 5
		    else if ((yindex[15] == yindex[5])
			    && (xindex[15] > xindex[5]))
			MoveSpaceLeft();
		    // if space is below button 5, it needs to be moved right
		    else
			MoveSpaceRight();
		}
	    }
	    // make sure button 6 and button 7 are in the right spot
	    else if ((yindex[6] != 1) | (xindex[6] != 2) | (yindex[7] != 1)
		    | (xindex[7] != 3)) {
		// make sure button 6 is at (3,1), button 7 is at (3,2)
		if (((yindex[6] != 1) | (xindex[6] != 3) | (yindex[7] != 2) | (xindex[7] != 3))
			&& (indicator2 == 0)) {
		    if ((yindex[6] != 1) | (xindex[6] != 3)) {
			// if the space is right above or on the left of button
			// 6
			if (((xindex[15] - xindex[6] == 1) && (yindex[6] == yindex[15]))
				| ((yindex[6] - yindex[15] == 1) && (xindex[6] == xindex[15]))) { // toggle
												  // space
												  // with
												  // button
												  // 6
			    ToggleNumSpace(6);
			}
			// move space towards button 6
			// Move space down when space is above button 6
			// Move space down when space is on the same level with
			// button 6,
			// but they are not on last row and the space is on the
			// left of
			// button 6
			else if (((xindex[6] == xindex[15]) && (yindex[15] < yindex[6]))
				| ((xindex[6] > xindex[15])
					&& (yindex[15] == yindex[6])
					&& (yindex[6] != 3) && (xindex[6] != 3))
				| ((yindex[6] - yindex[15] >= 1) && (xindex[6] < xindex[15])))
			    MoveSpaceDown();
			// Move space left when space is on the right side of
			// button 6
			// Also when both space and button 6 are on the 4th
			// column
			else if (((xindex[6] < xindex[15] - 1))
				| ((xindex[6] == xindex[15])
					&& (xindex[6] == 3) && (yindex[6] < yindex[15])))
			    MoveSpaceLeft();
			// move space up when space is lower right to button 6
			// also when both space and button 6 are last row and
			// space is on
			// the left of button 6
			// move space up when space is right
			else if (((xindex[15] > xindex[6]) && (yindex[15] > yindex[6]))
				| ((xindex[6] > xindex[15])
					&& (yindex[15] == yindex[6]) && (yindex[6] == 3))
				| ((xindex[6] == 3) && (yindex[6] <= yindex[15])))
			    MoveSpaceUp();
			// move space right when space is to the left of button
			// 6, but
			// button 6 is not at 4th column
			else if (((xindex[6] >= xindex[15]) && (xindex[6] != 3))
				| ((xindex[6] >= xindex[15])
					&& (xindex[6] == 3) && (xindex[15] < 2))
				| ((xindex[6] == 3) && (yindex[6] > yindex[15])))
			    MoveSpaceRight();
		    } else if ((yindex[7] != 2) | (xindex[7] != 3)) {
			if ((yindex[7] == 1) && (xindex[7] == 2)) {
			    // dead point for button 7
			} else {
			    // if the space is right above or on the left of
			    // button 7
			    if (((xindex[15] - xindex[7] == 1) && (yindex[7] == yindex[15]))
				    | ((yindex[7] - yindex[15] == 1) && (xindex[7] == xindex[15]))) { // toggle
												      // space
												      // with
												      // button
												      // 3
				ToggleNumSpace(7);
			    }
			    // move space towards button 7
			    // Move space down when space is above button 7
			    // Move space down when space is on the same level
			    // with button 7,
			    // but they are not on last row and the space is on
			    // the left of
			    // button 7
			    else if (((xindex[7] == xindex[15]) && (yindex[15] < yindex[7]))
				    | ((xindex[7] > xindex[15])
					    && (yindex[15] == yindex[7])
					    && (yindex[7] != 3) && (xindex[7] != 3))
				    | ((yindex[7] - yindex[15] >= 1) && (xindex[7] < xindex[15])))
				MoveSpaceDown();
			    // Move space left when space is on the right side
			    // of button 7
			    // Also when both space and button 7 are on the 4th
			    // column
			    else if (((xindex[7] < xindex[15] - 1))
				    | ((xindex[7] == xindex[15])
					    && (xindex[7] == 3) && (yindex[7] < yindex[15])))
				MoveSpaceLeft();
			    // move space up when space is lower right to button
			    // 7
			    // also when both space and button 7 are last row
			    // and space is on
			    // the left of button 7
			    // move space up when space is right
			    else if (((xindex[15] > xindex[7]) && (yindex[15] > yindex[7]))
				    | ((xindex[7] > xindex[15])
					    && (yindex[15] == yindex[7]) && (yindex[7] == 3))
				    | ((xindex[7] == 3) && (yindex[7] <= yindex[15])))
				MoveSpaceUp();
			    // move space right when space is to the left of
			    // button 7, but
			    // button 7 is not at 4th column
			    else if (((xindex[7] >= xindex[15]) && (xindex[7] != 3))
				    | ((xindex[7] >= xindex[15])
					    && (xindex[7] == 3) && (xindex[15] < 2))
				    | ((xindex[7] == 3) && (yindex[7] > yindex[15])))
				MoveSpaceRight();
			}
		    }
		} else {
		    // move space to (2,1) and also push button 6, 7 to (2,1)
		    // and (3,1)
		    if ((xindex[15] == 3) && (xindex[6] == 3)
			    && (yindex[6] == 0)) {
			MoveSpaceLeft();
			indicator2 = 1;
		    } else if (yindex[15] != 1) {
			MoveSpaceUp();
			indicator2 = 1;
		    } else if ((yindex[15] == 1) && (xindex[15] == 2)
			    && (xindex[6] == 3) && (yindex[6] == 1))
			ToggleNumSpace(6);
		    else if ((yindex[15] == 1) && (xindex[15] == 3)
			    && (xindex[7] == 3) && (yindex[7] == 2)) {
			ToggleNumSpace(7);
			indicator2 = 0;
		    }
		}
	    }
	    // make sure button 8 and button 12 are in the right spot
	    else if ((yindex[8] != 2) | (xindex[8] != 0) | (yindex[12] != 3)
		    | (xindex[12] != 0)) {
		// make sure button 12 is at (0,2), button 8 is at (1,2)
		if (((yindex[12] != 2) | (xindex[12] != 0) | (yindex[8] != 2) | (xindex[8] != 1))
			&& (indicator3 == 0)) {
		    if ((yindex[12] != 2) | (xindex[12] != 0)) {
			// if the space is right above or on the right of button
			// 12
			if (((xindex[12] - xindex[15] == 1) && (yindex[12] == yindex[15]))
				| ((yindex[12] - yindex[15] == 1) && (xindex[12] == xindex[15]))) { // toggle
												    // space
												    // with
												    // button
												    // 12
			    ToggleNumSpace(12);
			}
			// move space towards button 12
			else {
			    // if both button 12 and space is on 4th row and
			    // space
			    // button is on the right of button 12 move space up
			    // also if button 12 is on 3rd row, space button is
			    // on 4th,
			    // and space is just left of button 12, move space
			    // up
			    if (((yindex[15] == yindex[12])
				    && (yindex[12] == 3) && (xindex[15] > xindex[12]))
				    | ((yindex[12] == yindex[15] - 1) && (xindex[12] == xindex[15] + 1)))
				MoveSpaceUp();
			    // if both button 12 and space is on 3rd row and
			    // space
			    // button is on the right of button 12 move space
			    // down
			    else if ((yindex[15] == yindex[12])
				    && (yindex[12] == 2)
				    && (xindex[15] > xindex[12]))
				MoveSpaceDown();
			    // when space button is left of button 12, move
			    // space to the right
			    else if (xindex[15] < xindex[12])
				MoveSpaceRight();
			    // when space button is right or in the same column
			    // of button 12,
			    // move space left
			    else
				MoveSpaceLeft();
			}
		    } else if ((yindex[8] != 2) | (xindex[8] != 1)) {
			if ((yindex[8] == 3) && (xindex[8] == 0)) {
			    // dead spot for button 8
			} else {
			    // if the space is right above or on the right of
			    // button 8
			    if (((xindex[8] - xindex[15] == 1) && (yindex[8] == yindex[15]))
				    | ((yindex[8] - yindex[15] == 1) && (xindex[8] == xindex[15]))) { // toggle
												      // space
												      // with
												      // button
												      // 12
				ToggleNumSpace(8);
			    }
			    // move space towards button 8
			    else {
				// if both button 8 and space is on 4th row and
				// space
				// button is on the right of button 8 move space
				// up
				// also if button 8 is on 3rd row, space button
				// is on 4th,
				// and space is just left of button 8, move
				// space up
				if (((yindex[15] == yindex[8])
					&& (yindex[8] == 3) && (xindex[15] > xindex[8]))
					| ((yindex[8] == yindex[15] - 1) && (xindex[8] == xindex[15] + 1)))
				    MoveSpaceUp();
				// if both button 8 and space is on 3rd row and
				// space
				// button is on the right of button 8 move space
				// down
				else if ((yindex[15] == yindex[8])
					&& (yindex[8] == 2)
					&& (xindex[8] > xindex[12]))
				    MoveSpaceDown();
				// when space button is left of button 8, move
				// space to the
				// right
				else if (xindex[15] < xindex[8])
				    MoveSpaceRight();
				// when space button is right or in the same
				// column of button 8,
				// move space left
				else
				    MoveSpaceLeft();
			    }
			}

		    }
		} else {
		    // move space to (0,3) and also push button 8, 12 to (0,2)
		    // and (0,3)
		    if ((yindex[15] == 2) && (xindex[12] == 0)
			    && (yindex[12] == 2)) {
			MoveSpaceDown();
			indicator3 = 1;
		    } else if (xindex[15] != 0) {
			MoveSpaceLeft();
			indicator3 = 1;
		    } else if ((yindex[15] == 3) && (xindex[15] == 0)
			    && (xindex[12] == 0) && (yindex[12] == 2))
			ToggleNumSpace(12);
		    else if ((yindex[15] == 2) && (xindex[15] == 0)
			    && (xindex[8] == 1) && (yindex[8] == 2)) {
			ToggleNumSpace(8);
			indicator3 = 0;
		    }
		}
	    }
	    // make sure button 9 and button 13 are in the right spot
	    else if ((yindex[9] != 2) | (xindex[9] != 1) | (yindex[13] != 3)
		    | (xindex[13] != 1)) {
		// make sure button 13 is at (1,2), button 9 is at (2,2)
		if (((yindex[13] != 2) | (xindex[13] != 1) | (yindex[9] != 2) | (xindex[9] != 2))
			&& (indicator4 == 0)) {
		    if ((yindex[13] != 2) | (xindex[13] != 1)) {
			// if the space is right above or on the right of button
			// 13
			if (((xindex[13] - xindex[15] == 1) && (yindex[13] == yindex[15]))
				| ((yindex[13] - yindex[15] == 1) && (xindex[13] == xindex[15]))) { // toggle
												    // space
												    // with
												    // button
												    // 13
			    ToggleNumSpace(13);
			}
			// move space towards button 13
			else {
			    // if both button 13 and space is on 4th row and
			    // space
			    // button is on the right of button 12 move space up
			    // also if button 13 is on 3rd row, space button is
			    // on 4th,
			    // and space is just left of button 13, move space
			    // up
			    if (((yindex[15] == yindex[13])
				    && (yindex[13] == 3) && (xindex[15] > xindex[13]))
				    | ((yindex[13] == yindex[15] - 1) && (xindex[13] == xindex[15] + 1)))
				MoveSpaceUp();
			    // if both button 13 and space is on 3rd row and
			    // space
			    // button is on the right of button 13 move space
			    // down
			    else if ((yindex[13] == yindex[12])
				    && (yindex[13] == 2)
				    && (xindex[13] > xindex[12]))
				MoveSpaceDown();
			    // when space button is left of button 13, move
			    // space to the right
			    else if (xindex[15] < xindex[13])
				MoveSpaceRight();
			    // when space button is right or in the same column
			    // of button 13,
			    // move space left
			    else
				MoveSpaceLeft();
			}
		    } else if ((yindex[9] != 2) | (xindex[9] != 2)) {
			if ((yindex[9] == 3) && (xindex[9] == 1)) {
			    // dead spot for button 9
			} else {
			    // if the space is right above or on the right of
			    // button 9
			    if (((xindex[9] - xindex[15] == 1) && (yindex[9] == yindex[15]))
				    | ((yindex[9] - yindex[15] == 1) && (xindex[9] == xindex[15]))) { // toggle
												      // space
												      // with
												      // button
												      // 9
				ToggleNumSpace(9);
			    }
			    // move space towards button 9
			    else {
				// if both button 9 and space is on 4th row and
				// space
				// button is on the right of button 9 move space
				// up
				// also if button 9 is on 3rd row, space button
				// is on 4th,
				// and space is just left of button 9, move
				// space up
				if (((yindex[15] == yindex[9])
					&& (yindex[9] == 3) && (xindex[15] > xindex[9]))
					| ((yindex[9] == yindex[15] - 1) && (xindex[9] == xindex[15] + 1)))
				    MoveSpaceUp();
				// if both button 9 and space is on 3rd row and
				// space
				// button is on the right of button 9 move space
				// down
				else if ((yindex[15] == yindex[9])
					&& (yindex[9] == 2)
					&& (xindex[9] > xindex[12]))
				    MoveSpaceDown();
				// when space button is left of button 9, move
				// space to the
				// right
				else if (xindex[15] < xindex[9])
				    MoveSpaceRight();
				// when space button is right or in the same
				// column of button 9,
				// move space left
				else
				    MoveSpaceLeft();
			    }
			}

		    }
		} else {
		    // move space to (1,3) and also push button 9, 13 to (1,2)
		    // and (1,3)
		    if ((yindex[15] == 2) && (xindex[13] == 1)
			    && (yindex[13] == 2)) {
			MoveSpaceDown();
			indicator4 = 1;
		    } else if (xindex[15] != 1) {
			MoveSpaceLeft();
			indicator4 = 1;
		    } else if ((yindex[15] == 3) && (xindex[15] == 1)
			    && (xindex[13] == 1) && (yindex[13] == 2))
			ToggleNumSpace(13);
		    else if ((yindex[15] == 2) && (xindex[15] == 1)
			    && (xindex[9] == 2) && (yindex[9] == 2)) {
			ToggleNumSpace(9);
			indicator4 = 0;
		    }
		}
	    }
	    // make sure button 10, 11 and 14 are in the right spot
	    else if ((yindex[10] != 2) | (xindex[10] != 2) | (yindex[11] != 2)
		    | (xindex[11] != 3) | (yindex[14] != 3) | (xindex[14] != 2)) {
		if ((xindex[15] == 2) && (yindex[15] == 2))
		    MoveSpaceDown();
		else if ((xindex[15] == 2) && (yindex[15] == 3))
		    MoveSpaceRight();
		else if ((xindex[15] == 3) && (yindex[15] == 3))
		    MoveSpaceUp();
		else
		    MoveSpaceLeft();
	    }

	    for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++) {
		    System.out.print(buttonpos[i][j] + ", ");
		}
	}
    }

    public void MoveSpaceDown() {
	int hx, hy, temp;
	hx = buttons[15].getX();
	hy = buttons[15].getY();
	buttons[15].setLocation(buttons[buttonpos[yindex[15] + 1][xindex[15]]]
		.getLocation());
	buttons[buttonpos[yindex[15] + 1][xindex[15]]].setLocation(hx, hy);
	temp = buttonpos[yindex[15] + 1][xindex[15]];
	buttonpos[yindex[15] + 1][xindex[15]] = 15;
	buttonpos[yindex[15]][xindex[15]] = temp;
    }

    public void MoveSpaceLeft() {
	int hx, hy, temp;
	hx = buttons[15].getX();
	hy = buttons[15].getY();
	buttons[15].setLocation(buttons[buttonpos[yindex[15]][xindex[15] - 1]]
		.getLocation());
	buttons[buttonpos[yindex[15]][xindex[15] - 1]].setLocation(hx, hy);
	temp = buttonpos[yindex[15]][xindex[15] - 1];
	buttonpos[yindex[15]][xindex[15] - 1] = 15;
	buttonpos[yindex[15]][xindex[15]] = temp;
    }

    public void MoveSpaceRight() {
	int hx, hy, temp;
	hx = buttons[15].getX();
	hy = buttons[15].getY();
	buttons[15].setLocation(buttons[buttonpos[yindex[15]][xindex[15] + 1]]
		.getLocation());
	buttons[buttonpos[yindex[15]][xindex[15] + 1]].setLocation(hx, hy);
	temp = buttonpos[yindex[15]][xindex[15] + 1];
	buttonpos[yindex[15]][xindex[15] + 1] = 15;
	buttonpos[yindex[15]][xindex[15]] = temp;
    }

    public void MoveSpaceUp() {
	int hx, hy, temp;
	hx = buttons[15].getX();
	hy = buttons[15].getY();
	buttons[15].setLocation(buttons[buttonpos[yindex[15] - 1][xindex[15]]]
		.getLocation());
	buttons[buttonpos[yindex[15] - 1][xindex[15]]].setLocation(hx, hy);
	temp = buttonpos[yindex[15] - 1][xindex[15]];
	buttonpos[yindex[15] - 1][xindex[15]] = 15;
	buttonpos[yindex[15]][xindex[15]] = temp;
    }

    public void ToggleNumSpace(int num) {
	int hx, hy;
	hx = buttons[15].getX();
	hy = buttons[15].getY();
	buttons[15].setLocation(buttons[num].getLocation());
	buttons[num].setLocation(hx, hy);
	buttonpos[yindex[num]][xindex[num]] = 15;
	buttonpos[yindex[15]][xindex[15]] = num;
    }
} // end class GridLayoutFrame

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
