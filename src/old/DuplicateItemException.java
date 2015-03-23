/**
 * @(#) DuplicateItemException.java Mar 29, 2010 3:07:02 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package old;

/**
 * Class <code>DuplicateItemException</code>
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 29, 2010 3:07:02 PM
 * 
 */
/**
 * Exception class for duplicate item errors in search tree insertions.
 * 
 * @author Mark Allen Weiss
 */
public class DuplicateItemException extends RuntimeException {
    /**
     * Construct this exception object.
     */
    public DuplicateItemException() {
	super();
    }

    /**
     * Construct this exception object.
     * 
     * @param message
     *            the error message.
     */
    public DuplicateItemException(String message) {
	super(message);
    }
}
