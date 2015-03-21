/**
 * @(#) ItemNotFoundException.java Mar 29, 2010 3:07:23 PM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package old;

/**
 * Class <code>ItemNotFoundException</code>
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Mar 29, 2010 3:07:23 PM
 * 
 */
/**
 * Exception class for failed finds/removes in search
 * trees, hash tables, and list and tree iterators.
 * @author Mark Allen Weiss
 */
public class ItemNotFoundException
    extends RuntimeException
{
  /**
   * Construct this exception object.
   */
  public ItemNotFoundException()
  {
    super();
  }

  /**
   * Construct this exception object.
   * @param message the error message.
   */
  public ItemNotFoundException(String message)
  {
    super(message);
  }
}
