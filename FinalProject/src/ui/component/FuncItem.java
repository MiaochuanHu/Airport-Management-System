/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.component;

/**
 *
 * @author limingxia
 */
public class FuncItem {

    private String icon;
    private String text;
    private Integer Index;

    public FuncItem(String icon, String text, Integer Index) {
        this.icon = icon;
        this.text = text;
        this.Index = Index;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIndex() {
        return Index;
    }

    public void setIndex(Integer Index) {
        this.Index = Index;
    }

}
