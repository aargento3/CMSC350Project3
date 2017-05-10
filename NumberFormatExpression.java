import static javax.swing.JOptionPane.*;

/**
 *
 * @author AArgento
 * @date 23 April 2017
 * @class CMSC 350
 * @purpose  Define custom exception class to be called if fraction element length is > 2.
 *
 */

class NumberFormatExpression extends Exception {

    NumberFormatExpression(){
        showMessageDialog(null, "Non numeric Input");
   }

} //end NumberFormatExpression
