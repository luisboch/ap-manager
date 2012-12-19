/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.components;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author luis
 */
public class Label extends JLabel {

    private int maxLineLength = 50;
    private boolean autoLineBreak = false;
    private int originalSize = 15;
    private LabelOrientation orientation = LabelOrientation.CENTER;

    public Label() {
    }

    public Label(boolean autoLineBreak) {
        this.autoLineBreak = autoLineBreak;
    }

    public Label(Icon image) {
        super(image);
    }

    public Label(String text) {
        super(text);
    }

    public Label(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public Label(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public Label(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public Label(Icon image, boolean autoLineBreak) {
        super(image);
        this.autoLineBreak = autoLineBreak;
    }

    public Label(String text, boolean autoLineBreak) {
        super(text);
        this.autoLineBreak = autoLineBreak;
    }

    public Label(Icon image, int horizontalAlignment, boolean autoLineBreak) {
        super(image, horizontalAlignment);
        this.autoLineBreak = autoLineBreak;
    }

    public Label(String text, int horizontalAlignment, boolean autoLineBreak) {
        super(text, horizontalAlignment);
        this.autoLineBreak = autoLineBreak;
    }

    public Label(String text, Icon icon, int horizontalAlignment, boolean autoLineBreak) {
        super(text, icon, horizontalAlignment);
        this.autoLineBreak = autoLineBreak;
    }

    @Override
    public void setText(String text) {
        if (!autoLineBreak) {
            super.setText(text);
            return;
        }
        // controla a quebra de linha
        if (text.length() > maxLineLength) {
            int size = originalSize;
            StringBuilder b = new StringBuilder("<html>");
            
            switch(orientation){
                case CENTER:
                    b.append("<div style=\"width:100%;text-align:center;\">");
                    break;
                    case LEFT:
                    b.append("<div style=\"width:100%;text-align:left;\">");
                    break;
                    case RIGHT:
                    b.append("<div style=\"width:100%;text-align:right;\">");
                    break;
                        
            }
            
            int index = -1;
            int beginIndex = 0;
            int searchIndex = maxLineLength;
            boolean continuAdd = true;
            int brFound = -1;
            do {
                brFound = text.indexOf("<br />", searchIndex-maxLineLength +1);
                brFound = brFound == -1? text.indexOf("<br/>", searchIndex-maxLineLength+1):brFound;
                brFound = brFound == -1? text.indexOf("<br >", searchIndex-maxLineLength+1):brFound;
                brFound = brFound == -1? text.indexOf("<br>", searchIndex-maxLineLength+1):brFound;
                if (brFound != -1 && brFound < searchIndex) {
                    searchIndex = brFound + maxLineLength;
                    index = brFound;
                    b.append(text.substring(beginIndex, index));
                    beginIndex = brFound;
                } else {
                    index = text.indexOf(" ", searchIndex);
                    if (index != -1) {
                        b.append(text.substring(beginIndex, index)).append("<br />");
                        beginIndex = index;
                        searchIndex = searchIndex + maxLineLength;
                        size = size + originalSize;
                    } else {
                        continuAdd = false;
                    }
                }
            } while (continuAdd);

            b.append(text.substring(beginIndex)).append("<br />");
            b.append("</html>");
            Dimension dimension = getSize();
            dimension = new Dimension(dimension.width, size);
            super.setSize(dimension);
            super.setMinimumSize(dimension);
            super.setMaximumSize(dimension);
            
            
            switch(orientation){
                case CENTER:
                    this.setHorizontalAlignment(SwingConstants.CENTER);
                    break;
                    case LEFT:
                    this.setHorizontalAlignment(SwingConstants.LEFT);
                    break;
                    case RIGHT:
                    this.setHorizontalAlignment(SwingConstants.RIGHT);
                    break;
                        
            }
            super.setText(b.toString());
        } else {
            super.setText(text);
        }
    }
}
