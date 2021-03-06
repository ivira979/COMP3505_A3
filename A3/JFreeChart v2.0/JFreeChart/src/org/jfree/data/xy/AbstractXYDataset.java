/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License 
 * along with this library; if not, write to the Free Software Foundation, 
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * ----------------------
 * AbstractXYDataset.java
 * ----------------------
 * (C) Copyright 2004, 2005, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited).
 * Contributor(s):   -;
 *
 * $Id: AbstractXYDataset.java,v 1.2 2005/01/28 14:10:03 mungady Exp $
 *
 * Changes
 * -------
 * 05-May-2004 : Version 1 (DG);
 * 15-Jul-2004 : Switched getX() with getXValue() and getY() with 
 *               getYValue() (DG);
 * 18-Aug-2004 : Moved from org.jfree.data --> org.jfree.data.xy (DG);
 * 
 */

package org.jfree.data.xy;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.AbstractSeriesDataset;

/**
 * An base class that you can use to create new implementations of the 
 * {@link XYDataset} interface.
 */
public abstract class AbstractXYDataset extends AbstractSeriesDataset 
                                        implements XYDataset {

    /**
     * Returns the order of the domain (X) values.
     * 
     * @return The domain order.
     */
    @Override
	public DomainOrder getDomainOrder() {
        return DomainOrder.NONE;
    }
    
    /**
     * Returns the x-value (as a double primitive) for an item within a series.
     * 
     * @param series  the series index (zero-based).
     * @param item  the item index (zero-based).
     * 
     * @return The value.
     */
    @Override
	public double getXValue(int series, int item) {
        double result = Double.NaN;
        Number x = getX(series, item);
        if (x != null) {
            result = x.doubleValue();   
        }
        return result;   
    }

    /**
     * Returns the y-value (as a double primitive) for an item within a series.
     * 
     * @param series  the series index (zero-based).
     * @param item  the item index (zero-based).
     * 
     * @return The value.
     */
    @Override
	public double getYValue(int series, int item) {
        double result = Double.NaN;
        Number y = getY(series, item);
        if (y != null) {
            result = y.doubleValue();   
        }
        return result;   
    }

}