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
 * -----------------
 * WaferMapPlot.java
 * -----------------
 *
 * (C) Copyright 2003, 2004, by Robert Redburn and Contributors.
 *
 * Original Author:  Robert Redburn;
 * Contributor(s):   David Gilbert (for Object Refinery Limited);
 *
 * Changes
 * -------
 * 25-Nov-2003 : Version 1 contributed by Robert Redburn (DG);
 * 10-Jun-2005 : Changed private --> protected for drawChipGrid(), 
 *               drawWaferEdge() and getWafterEdge() (DG);
 * 16-Jun-2005 : Added default constructor and setDataset() method (DG);
 *
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ResourceBundle;

import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.block.ArrangeParams;
import org.jfree.chart.block.ArrangeResult;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.ui.RectangleInsets;

/**
 * A wafer map plot.
 */
public class WaferMapPlot extends Plot implements RendererChangeListener,
                                                  Cloneable,
                                                  Serializable {

    /** For serialization. */
    private static final long serialVersionUID = 4668320403707308155L;
    
    /** The default grid line stroke. */
    public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f,
        BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_BEVEL,
        0.0f,
        new float[] {2.0f, 2.0f},
        0.0f);

    /** The default grid line paint. */
    public static final Paint DEFAULT_GRIDLINE_PAINT = Color.lightGray;

    /** The default crosshair visibility. */
    public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;

    /** The default crosshair stroke. */
    public static final Stroke DEFAULT_CROSSHAIR_STROKE 
        = DEFAULT_GRIDLINE_STROKE;

    /** The default crosshair paint. */
    public static final Paint DEFAULT_CROSSHAIR_PAINT = Color.blue;

    /** The resourceBundle for the localization. */
    protected static ResourceBundle localizationResources = 
        ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");

    /** The plot orientation. 
     *  vertical = notch down
     *  horizontal = notch right
     */
    private PlotOrientation orientation;

    /** The dataset. */
    private WaferMapDataset dataset;

    /** 
     * Object responsible for drawing the visual representation of each point 
     * on the plot. 
     */
    private WaferMapRenderer renderer;

    /**
     * Creates a new plot with no dataset.
     */
    public WaferMapPlot() {
        this(null);   
    }

    /**
     * Creates a new plot.
     * 
     * @param dataset  the dataset (<code>null</code> permitted).
     */
    public WaferMapPlot(WaferMapDataset dataset) {
        this(dataset, null);
    }

    /**
     * Creates a new plot.
     *
     * @param dataset  the dataset (<code>null</code> permitted).
     * @param renderer  the renderer (<code>null</code> permitted).
     */
    public WaferMapPlot(WaferMapDataset dataset, WaferMapRenderer renderer) {

        super();

        this.orientation = PlotOrientation.VERTICAL;
        
        this.dataset = dataset;
        if (dataset != null) {
            dataset.addChangeListener(this);
        }

        this.renderer = renderer;
        if (renderer != null) {
            renderer.setPlot(this);
            renderer.addChangeListener(this);
        }

    }

    /**
     * Returns the plot type as a string.
     *
     * @return A short string describing the type of plot.
     */
    @Override
	public String getPlotType() {
        return ("WMAP_Plot");
    }

    /**
     * Returns the dataset
     * 
     * @return The dataset.
     */
    public WaferMapDataset getDataset() {
        return this.dataset;
    }

    /**
     * Sets the dataset used by the plot and sends a {@link PlotChangeEvent}
     * to all registered listeners.
     * 
     * @param dataset  the dataset (<code>null</code> permitted).
     */
    public void setDataset(WaferMapDataset dataset) {
        // if there is an existing dataset, remove the plot from the list of 
        // change listeners...
        if (this.dataset != null) {
            this.dataset.removeChangeListener(this);
        }

        // set the new dataset, and register the chart as a change listener...
        this.dataset = dataset;
        if (dataset != null) {
            setDatasetGroup(dataset.getGroup());
            dataset.addChangeListener(this);
        }

        // send a dataset change event to self to trigger plot change event
        datasetChanged(new DatasetChangeEvent(this, dataset));
    }

    /**
     * Sets the item renderer, and notifies all listeners of a change to the 
     * plot.  If the renderer is set to <code>null</code>, no chart will be 
     * drawn.
     *
     * @param renderer  the new renderer (<code>null</code> permitted).
     */
    public void setRenderer(WaferMapRenderer renderer) {

        if (this.renderer != null) {
            this.renderer.removeChangeListener(this);
        }

        this.renderer = renderer;
        if (renderer != null) {
            renderer.setPlot(this);
        }

        notifyListeners(new PlotChangeEvent(this));

    }
    
    /**
     * Arranges the contents of the block, within the given constraints, and 
     * returns the block size.
     * 
     * @param g2  the graphics device.
     * @param constraint  the constraint (<code>null</code> not permitted).
     * @param params  the layout parameters (<code>null</code> not permitted).
     * 
     * @return The layout result.
     */
    @Override
	public ArrangeResult arrange(Graphics2D g2, RectangleConstraint constraint, 
            ArrangeParams params) {
        
        // there isn't any content to arrange, so we just need to return the
        // size for the given constraint
        ArrangeResult result = params.getRecyclableResult();
        double w = constraint.calculateConstrainedWidth(getDefaultWidth());
        double h = constraint.calculateConstrainedHeight(getDefaultHeight());
        if (result != null) {
            result.setSize(w, h);
        }
        else {
            result = new ArrangeResult(w, h, null);
        }
        return result;
        
    }
    
    /**
     * Draws the wafermap view.
     * 
     * @param g2  the graphics device.
     * @param plotArea  the plot area.
     * @param state  the plot state.
     * @param info  the plot rendering info.
     */
    @Override
	public void draw(Graphics2D g2, Rectangle2D plotArea, Point2D anchor,
                     PlotState state, 
                     PlotRenderingInfo info) {

        // if the plot area is too small, just return...
        boolean b1 = (plotArea.getWidth() <= MINIMUM_WIDTH_TO_DRAW);
        boolean b2 = (plotArea.getHeight() <= MINIMUM_HEIGHT_TO_DRAW);
        if (b1 || b2) {
            return;
        }

        // record the plot area...
        if (info != null) {
            info.setPlotArea(plotArea);
        }

        // adjust the drawing area for the plot insets (if any)...
        //RectangleInsets insets = getInsets();
        //insets.trim(plotArea);
        RectangleInsets margin = getMargin();
        margin.trim(plotArea);

        drawChipGrid(g2, plotArea);       
        drawWaferEdge(g2, plotArea);
        
    }

    /**
     * Calculates and draws the chip locations on the wafer.
     * 
     * @param g2  the graphics device.
     * @param plotArea  the plot area.
     */
    protected void drawChipGrid(Graphics2D g2, Rectangle2D plotArea) {
        
        Shape savedClip = g2.getClip();
        g2.setClip(getWaferEdge(plotArea));
        Rectangle2D chip = new Rectangle2D.Double();
        int xchips = 35;
        int ychips = 20;
        double space = 1d;
        if (this.dataset != null) {
            xchips = this.dataset.getMaxChipX() + 2;
            ychips = this.dataset.getMaxChipY() + 2;
            space = this.dataset.getChipSpace();
        }
        double startX = plotArea.getX();
        double startY = plotArea.getY();
        double chipWidth = 1d;
        double chipHeight = 1d;
        if (plotArea.getWidth() != plotArea.getHeight()) {
            double major = 0d;
            double minor = 0d;
            if (plotArea.getWidth() > plotArea.getHeight()) {
                major = plotArea.getWidth();
                minor = plotArea.getHeight();
            } 
            else {
                major = plotArea.getHeight();
                minor = plotArea.getWidth();
            } 
            //set upperLeft point
            if (plotArea.getWidth() == minor) { // x is minor
                startY += (major - minor) / 2;
                chipWidth = (plotArea.getWidth() - (space * xchips - 1)) 
                    / xchips;
                chipHeight = (plotArea.getWidth() - (space * ychips - 1)) 
                    / ychips;
            }
            else { // y is minor
                startX += (major - minor) / 2;
                chipWidth = (plotArea.getHeight() - (space * xchips - 1)) 
                    / xchips;
                chipHeight = (plotArea.getHeight() - (space * ychips - 1)) 
                    / ychips;
            }
        }
        
        for (int x = 1; x <= xchips; x++) {
            double upperLeftX = (startX - chipWidth) + (chipWidth * x) 
                + (space * (x - 1));
            for (int y = 1; y <= ychips; y++) {
                double upperLeftY = (startY - chipHeight) + (chipHeight * y) 
                    + (space * (y - 1));
                chip.setFrame(upperLeftX, upperLeftY, chipWidth, chipHeight);
                g2.setColor(Color.white);
                if (this.dataset.getChipValue(x - 1, ychips - y - 1) != null) {
                    g2.setPaint(
                        this.renderer.getChipColor(
                            this.dataset.getChipValue(x - 1, ychips - y - 1)
                        )
                    );
                } 
                g2.fill(chip);
                g2.setColor(Color.lightGray);
                g2.draw(chip);
            }
        }
        g2.setClip(savedClip);
    }

    /**
     * Calculates the location of the waferedge.
     * 
     * @param plotArea  the plot area.
     * 
     * @return The wafer edge.
     */
    protected Ellipse2D getWaferEdge(Rectangle2D plotArea) {
        Ellipse2D edge = new Ellipse2D.Double();
        double diameter = plotArea.getWidth();
        double upperLeftX = plotArea.getX();
        double upperLeftY = plotArea.getY();
        //get major dimension
        if (plotArea.getWidth() != plotArea.getHeight()) {
            double major = 0d;
            double minor = 0d;
            if (plotArea.getWidth() > plotArea.getHeight()) {
                major = plotArea.getWidth();
                minor = plotArea.getHeight();
            } 
            else {
                major = plotArea.getHeight();
                minor = plotArea.getWidth();
            } 
            //ellipse diameter is the minor dimension
            diameter = minor;
            //set upperLeft point
            if (plotArea.getWidth() == minor) { // x is minor
                upperLeftY = plotArea.getY() + (major - minor) / 2;
            }
            else { // y is minor
                upperLeftX = plotArea.getX() + (major - minor) / 2;
            }
        }
        edge.setFrame(upperLeftX, upperLeftY, diameter, diameter); 
        return edge;        
    }

    /**
     * Draws the waferedge, including the notch.
     * 
     * @param g2  the graphics device.
     * @param plotArea  the plot area.
     */
    protected void drawWaferEdge(Graphics2D g2, Rectangle2D plotArea) {
        // draw the wafer
        Ellipse2D waferEdge = getWaferEdge(plotArea);
        g2.setColor(Color.black);
        g2.draw(waferEdge);
        // calculate and draw the notch
        // horizontal orientation is considered notch right
        // vertical orientation is considered notch down
        Arc2D notch = null;
        Rectangle2D waferFrame = waferEdge.getFrame();
        double notchDiameter = waferFrame.getWidth() * 0.04;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            Rectangle2D notchFrame = 
                new Rectangle2D.Double(
                    waferFrame.getX() + waferFrame.getWidth() 
                    - (notchDiameter / 2), waferFrame.getY()
                    + (waferFrame.getHeight() / 2) - (notchDiameter / 2),
                    notchDiameter, notchDiameter
                );
            notch = new Arc2D.Double(notchFrame, 90d, 180d, Arc2D.OPEN);
        }
        else {
            Rectangle2D notchFrame = 
                new Rectangle2D.Double(
                    waferFrame.getX() + (waferFrame.getWidth() / 2) 
                    - (notchDiameter / 2), waferFrame.getY() 
                    + waferFrame.getHeight() - (notchDiameter / 2),
                    notchDiameter, notchDiameter
                );
            notch = new Arc2D.Double(notchFrame, 0d, 180d, Arc2D.OPEN);        
        }
        g2.setColor(Color.white);
        g2.fill(notch);
        g2.setColor(Color.black);
        g2.draw(notch);
        
    }

    /**
     * Return the legend items from the renderer.
     * 
     * @return The legend items.
     */
    @Override
	public LegendItemCollection getLegendItems() {
        return this.renderer.getLegendCollection();
    }

    /**
     * Notifies all registered listeners of a renderer change.
     *
     * @param event  the event.
     */
    @Override
	public void rendererChanged(RendererChangeEvent event) {
        notifyListeners(new PlotChangeEvent(this));
    }

}
