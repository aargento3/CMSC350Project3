/* import all required java libraries */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author AArgento
 * @date 23 April 2017
 * @class CMSC350
 * @purpose  Provide 3 classes: CMSC350Project3, BinarySearch and Tree
 *
 */


/* --------- CMSC350Project3 ---------
* Define all components required for GUI. Initialize GUI. Monitor GUI for user input.
*/
public class CMSC350Project3 extends JFrame {

    private BinarySearch tree;
    private String sortedList = "";

    /* constructor */
    private CMSC350Project3() {

        /* define original list components */
        JLabel labelOriginal = new JLabel("Original List");
        final JTextField textOriginal = new JTextField();
        textOriginal.setPreferredSize(new Dimension(350, 25));

        /* define sorted list components */
        JLabel labelSorted = new JLabel("Sorted List  ");
        final JTextField textSorted = new JTextField();
        textSorted.setPreferredSize(new Dimension(350, 25));
        textSorted.setEditable (false);

        /* define "Perform Sort" button */
        JButton buttonPerformSort = new JButton("Perform Sort");

        /* define radio buttons and radio button groups*/
        final JRadioButton radioAscending = new JRadioButton("Ascending");
        final JRadioButton radioDescending = new JRadioButton("Descending");
        final JRadioButton radioInteger = new JRadioButton("Integer");
        final JRadioButton radioFraction = new JRadioButton("Fraction");
        radioInteger.setSelected(true);
        radioAscending.setSelected(true);
        ButtonGroup radioGroupSortOrder = new ButtonGroup();
        radioGroupSortOrder.add(radioAscending);
        radioGroupSortOrder.add(radioDescending);
        ButtonGroup radioGroupNumericType = new ButtonGroup();
        radioGroupNumericType.add(radioInteger);
        radioGroupNumericType.add(radioFraction);

		/* define JPanels */
        JPanel panelOriginal = new JPanel();
        JPanel panelSorted = new JPanel();
        JPanel panelButton = new JPanel();
        JPanel panelRadioGroup = new JPanel();
        JPanel panelSortOrderRadios = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelNumericTypeRadios = new JPanel(new FlowLayout(FlowLayout.LEFT));

        /* define containers for radio buttons */
        Container containerSortOrderRadios = new Container();
        containerSortOrderRadios.setLayout(new BoxLayout(containerSortOrderRadios, BoxLayout.Y_AXIS));
        containerSortOrderRadios.add(radioAscending);
        containerSortOrderRadios.add(radioDescending);
        Container containerNumericTypeRadios = new Container();
        containerNumericTypeRadios.setLayout(new BoxLayout(containerNumericTypeRadios, BoxLayout.Y_AXIS));
        containerNumericTypeRadios.add(radioInteger);
        containerNumericTypeRadios.add(radioFraction);

        /* set border and title for radio button panels */
        panelSortOrderRadios.setBorder (new TitledBorder (new EtchedBorder(EtchedBorder.LOWERED), " Sort Order " ));
        panelSortOrderRadios.setPreferredSize(new Dimension(220, 80));
        panelNumericTypeRadios.setBorder ( new TitledBorder (new EtchedBorder (EtchedBorder.LOWERED), " Numeric Type " ));
        panelNumericTypeRadios.setPreferredSize(new Dimension(220, 80));

        /* add components to JPanels */
        panelOriginal.add(labelOriginal, BorderLayout.CENTER);
        panelOriginal.add(textOriginal, BorderLayout.CENTER);
        panelSorted.add(labelSorted, BorderLayout.CENTER);
        panelSorted.add(textSorted, BorderLayout.CENTER);
        panelButton.add(buttonPerformSort, BorderLayout.CENTER);
        panelSortOrderRadios.add(containerSortOrderRadios);
        panelNumericTypeRadios.add(containerNumericTypeRadios);
        panelRadioGroup.add(panelSortOrderRadios, BorderLayout.CENTER );
        panelRadioGroup.add(panelNumericTypeRadios, BorderLayout.CENTER);

        /* define container to group panels */
        Container containerPnlGrp = new Container();
        containerPnlGrp.setLayout(new BoxLayout(containerPnlGrp, BoxLayout.Y_AXIS));
        containerPnlGrp.add(panelOriginal);
        containerPnlGrp.add(panelSorted);
        containerPnlGrp.add(panelButton);
        containerPnlGrp.add(panelRadioGroup);

        /* create a frame that will be used to properly display all the components in the GUI */
        JFrame frameMainGUI = new JFrame ();
        frameMainGUI.setTitle("Binary Search Tree Sort");
        frameMainGUI.setPreferredSize(new Dimension(530, 250));
        frameMainGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMainGUI.add(containerPnlGrp);
        frameMainGUI.pack ();
        frameMainGUI.setLocationRelativeTo(null);
        frameMainGUI.setVisible(true);

        /*
        * upon buttonPerformSort click: retrieve user input to be sorted. monitor state of integer/fraction and
        * ascending/descending radio buttons. perform correct calls based on these inputs. catch
        */
        buttonPerformSort.addActionListener((ActionEvent ae) -> {

            textSorted.setText("");
            String listToBeSorted = textOriginal.getText();
            String data[] = listToBeSorted.split(" ");

            /* integer path */
            if (radioInteger.isSelected()) try {

                tree = new BinarySearch<Integer>();

                Integer integerArray[] = new Integer[data.length];

                for (int i = 0; i < data.length; i++) {
                    integerArray[i] = Integer.parseInt(data[i]);
                }

                Tree root = tree.addToTree(integerArray);

                if (radioAscending.isSelected()) {
                    switch (sortedList = tree.sortTreeAscending(root)) {
                    }
                } else if (radioDescending.isSelected()) {
                    switch (sortedList = tree.sortTreeDescending(root)) {
                    }
                }
                textSorted.setText(sortedList);
            } catch (NumberFormatException e){
                showMessageDialog(null, "Non numeric Input");
                System.out.println("User Input Will Be Cleared. \nPlease Reenter Integer List To Be Sorted.");
                textOriginal.setText("");
            }

            /* fraction path */
            else try {
                tree = new BinarySearch<Fractions>();

                Fractions fractionArray[] = new Fractions[data.length];

                for (int i = 0; i < data.length; i++) {
                    String[] fractionElements = data[i].split("/");

                    if (fractionElements.length > 2) throw new NumberFormatExpression();
                    Fractions fractions = new Fractions(data[i]);
                    fractionArray[i] = fractions;
                }

                Tree root = tree.addToTree(fractionArray);

                if (radioAscending.isSelected()) {
                    switch (sortedList = tree.sortTreeAscending(root)) {
                    }
                } else if (radioDescending.isSelected()) {
                    switch (sortedList = tree.sortTreeDescending(root)) {
                    }
                }

                textSorted.setText(sortedList);

            } catch (NumberFormatExpression e1) {
                System.out.println("User Input Will Be Cleared. \nPlease Reenter Fraction List To Be Sorted.");
                textOriginal.setText("");
            }
        });
    }//end constructor

    /* initialize CMSC350Project3 */
    public static void main(String[] args) {
        new CMSC350Project3();
    }//end main

}//end CMSC350Project3

/* --------- BinarySearch ---------
* Perform all actions relating to input of data into tree and all data manipulation in tree
*/
class BinarySearch <binarySearch> {

    private Tree <binarySearch> tree = null;
    private String output = "";

    /* constructor */
    BinarySearch() {
    }

    /* create the binary search tree and ensure tree is empty */
    Tree <binarySearch> addToTree(binarySearch array[]) {
        tree = null;
        Tree<binarySearch> createNode;

        for (binarySearch i : array) {
            createNode = new Tree <> (i);
            tree = newValue (tree, createNode);
        }
        return tree;
    }

    /* inserts new integer or fraction values into tree */
    private Tree<binarySearch> newValue(Tree<binarySearch> tree, Tree<binarySearch> newNode) {

        if (tree == null) return newNode;

        /* integer path */
        if (tree.treeInput instanceof Integer) {
            if (Objects.equals(newNode.treeInput, tree.treeInput))
                tree.rightNode = newValue(tree.rightNode, newNode);
            else if ((Integer)newNode.treeInput > (Integer)tree.treeInput) {
                tree.rightNode = newValue (tree.rightNode, newNode);
            } else if ((Integer)newNode.treeInput < (Integer)tree.treeInput)
                tree.leftNode = newValue(tree.leftNode, newNode);
            return tree;
        }
        /* fraction path */
        else {
            if (((Fractions)newNode.treeInput).compareTo(tree.treeInput) == 0)
                tree.rightNode = newValue(tree.rightNode, newNode);
            else {
                if (((Fractions)newNode.treeInput).compareTo(tree.treeInput) > 0)
                    tree.rightNode = newValue(tree.rightNode, newNode);
                else if (((Fractions)newNode.treeInput).compareTo(tree.treeInput) < 0)
                    tree.leftNode = newValue(tree.leftNode, newNode);
            }
            return tree;
        }
    }

    /* sort tree in ascending order */
    String sortTreeAscending(Tree <binarySearch> tree) {
        if (tree == null) return output;

        final String s = sortTreeAscending(tree.leftNode);

        output += String.valueOf(tree.treeInput + " ");

        final String s1 = sortTreeAscending(tree.rightNode);

        return output;
    }

    /* sort tree in descending order */
    String sortTreeDescending(Tree <binarySearch> tree) {
        if (tree == null) return output;

        final String s = sortTreeDescending(tree.rightNode);

        output += String.valueOf(tree.treeInput + " ");

        final String s1 = sortTreeDescending(tree.leftNode);

        return output;
    }
} //end BinarySearch

/* --------- Tree ---------
* Provide tree structure to be used for both integer and fraction computations
*/
class Tree <BST> {

    BST treeInput;
    Tree<BST> leftNode;
    Tree <BST> rightNode;

    Tree(BST input) {
        this.treeInput = input;
        this.leftNode = null;
        this.rightNode = null;
    }

    @Override
    public String toString() {
        return treeInput + " ";
    }

} //end Tree