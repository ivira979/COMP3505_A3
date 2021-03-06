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
 * -------------------------
 * AttributedLabelBlock.java
 * -------------------------
 * (C) Copyright 2005, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: AttributedLabelBlock.java,v 1.2 2005/07/19 14:27:02 mungady Exp $
 *
 * Changes:
 * --------
 * 22-Jun-2005 : Version 1 (DG);
 * 
 */

package org.jfree.chart.block;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.text.AttributedString;

import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.Size2D;

/**
 * A block containing an attributed label.
 */
public class AttributedLabelBlock extends AbstractContentBlock {
    
    /** 
     * The text for the label - retained in case the label needs 
     * regenerating (for example, to change the block size). 
     */
    private AttributedString text;
    
    /** The label. */
    private TextBlock label;
    
    /** The font. */
    private Font font;
    
    /** The tool tip text (can be <code>null</code>). */
    private String toolTipText;
    
    /** The URL text (can be <code>null</code>). */
    private String urlText;
    
    /**
     * Creates a new label block.
     * 
     * @param label  the label (<code>null</code> not permitted).
     */
    public AttributedLabelBlock(AttributedString label) {
        this(label, new Font("SansSerif", Font.PLAIN, 10));
    }
    
    /**
     * Creates a new label block.
     * 
     * @param text  the text for the label (<code>null</code> not permitted).
     * @param font  the font (<code>null</code> not permitted).
     */
    public AttributedLabelBlock(AttributedString text, Font font) {        
        this.text = text;
        this.label = ACIUtilities.createTextBlock(text.getIterator(), font, 
                Color.black, HorizontalAlignment.LEFT);
        this.font = font;
        this.toolTipText = null;
        this.urlText = null;
    }
    
    /**
     * Returns the tool tip text.
     * 
     * @return The tool tip text (possibly <code>null</code>).
     */
    public String getToolTipText() {
        return this.toolTipText;
    }
    
    /**
     * Sets the tool tip text.
     * 
     * @param text  the text (<code>null</code> permitted).
     */
    public void setToolTipText(String text) {
        this.toolTipText = text;   
    }
    
    /**
     * Returns the URL text.
     * 
     * @return The URL text (possibly <code>null</code>).
     */
    public String getURLText() {
        return this.urlText;
    }
    
    /**
     * Sets the URL text.
     * 
     * @param text  the text (<code>null</code> permitted).
     */
    public void setURLText(String text) {
        this.urlText = text;   
    }
    
    /**
     * Arranges the contents of the block, within the given constraints, and 
     * returns the block size.
     * 
     * @param g2  the graphics device.
     * @param constraint  the constraint (<code>null</code> not permitted).
     * @param params  layout parameters (<code>null</code> not permitted).
     * 
     * @return The result of the arrangement, including the block size.
     */
    @Override
	public ArrangeResult arrange(Graphics2D g2, RectangleConstraint constraint,
                                 ArrangeParams params) {
        g2.setFont(this.font);
        Size2D s = this.label.calculateDimensions(g2);
        return new ArrangeResult(calculateTotalWidth(s.getWidth()), 
                calculateTotalHeight(s.getHeight()), null);
    }
    
    /**
     * Draws the block.
     * 
     * @param g2  the graphics device.
     * @param area  the area.
     */
    @Override
	public void draw(Graphics2D g2, Rectangle2D area) {
        draw(g2, area, null);
    }
    
    /**
     * Draws the block within the specified area.
     * 
     * @param g2  the graphics device.
     * @param area  the area.
     * @param params  ignored (<code>null</code> permitted).
     * 
     * @return Always <code>null</code>.
     */
    @Override
	public Object draw(Graphics2D g2, Rectangle2D area, Object params) {
        area = (Rectangle2D) area.clone();
        area = trimMargin(area);
        drawBorder(g2, area);
        area = trimBorder(area);
        area = trimPadding(area);
        
        // check if we need to collect chart entities from the container
        EntityBlockParams ebp = null;
        StandardEntityCollection sec = null;
        Shape entityArea = null;
        if (params instanceof EntityBlockParams) {
            ebp = (EntityBlockParams) params;
            if (ebp.getGenerateEntities()) {
                sec = new StandardEntityCollection();
                // TODO:  this transformation doesn't work always.  Fix!
                entityArea = g2.getTransform().createTransformedShape(area);
            }
        }
        g2.setPaint(Color.black);
        g2.setFont(this.font);
        this.label.draw(
            g2, (float) area.getX(), (float) area.getY(), 
            TextBlockAnchor.TOP_LEFT
        );
        BlockResult result = null;
        if (ebp != null && sec != null) {
            if (this.toolTipText != null || this.urlText != null) {
                ChartEntity entity = new ChartEntity(
                    entityArea, this.toolTipText, this.urlText
                );   
                sec.add(entity);
                result = new BlockResult();
                result.setEntityCollection(sec);
            }
        }
        return result;
    }

}
