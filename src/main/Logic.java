/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;

/**
 *
 * @author Aline
 */
class Element{
    String name;
    double mass;
    int width, height, depth;
    String contType;
    String colour;
    int variants;
    int x = 1000000, y = 1000000, z = 1000000;
    
    public Element(String name, double mass, int width, int depth, int height, String contType, String colour){
        this.name = name;
        this.mass = mass;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.contType = contType;
        this.colour = colour;
    }
}

public class Logic {
    
    Element[] elements;
    int contHeight = 300;
    int contDepth = 300;
    int contWidth = 300;
    int[][][] container = new int[contHeight][contDepth][contWidth];
    
    public void start(List list){
        int tmp = 0;
        for(int i = 0; i < list.size(); i++){
            tmp += Integer.parseInt(list.get(i).toString().split(", ")[1].split(" ")[0]);
        }
        elements = new Element[tmp];
        int k = 0;
        for(int i = 0; i < list.size(); i++){
            String[] temp = list.get(i).toString().split(", ");
            String[] temp2 = temp[3].split("x");
            for(int j = 0; j < Integer.parseInt(temp[1].split(" ")[0]); j++)
                elements[k++] = new Element(temp[0], //name 
                    Double.parseDouble(temp[2].split(" ")[0]), //mass
                    Integer.parseInt(temp2[0]), //width
                    Integer.parseInt(temp2[1]), //depth
                    Integer.parseInt(temp2[2]), //height
                    temp[4], //contType
                    temp[5]); //colour
        }
        setVariants();
        sort();
        pack();
    }
    
    public void setVariants(){
        for (Element element : elements) {
            int variantsPlacement = 0;
            if(element.width <= contWidth && element.height <= contHeight && element.depth <= contDepth) 
                variantsPlacement++;
            if(element.width <= contWidth && element.depth <= contHeight && element.height <= contDepth) 
                variantsPlacement++;
            if(element.height <= contWidth && element.width <= contHeight && element.depth <= contDepth) 
                variantsPlacement++;
            if(element.height <= contWidth && element.depth <= contHeight && element.width <= contDepth) 
                variantsPlacement++;
            if(element.depth <= contWidth && element.height <= contHeight && element.width <= contDepth) 
                variantsPlacement++;
            if(element.depth <= contWidth && element.width <= contHeight && element.height <= contDepth) 
                variantsPlacement++; 
            element.variants = variantsPlacement; 
        }
    }
    
    public void sort(){
        boolean swapped = true;
        int j = 0;
        Element tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < elements.length - j; i++) {
                int volume1 = elements[i].width * elements[i].height * elements[i].depth;
                int volume2 = elements[i + 1].width * elements[i + 1].height * elements[i + 1].depth;
                if (volume1 < volume2) {
                    tmp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = tmp;
                    swapped = true;
                }
                if (volume1 == volume2)
                    if (elements[i].variants > elements[i + 1].variants){
                        tmp = elements[i];
                        elements[i] = elements[i + 1];
                        elements[i + 1] = tmp;
                        swapped = true;
                    }
                if (elements[i].mass > elements[i + 1].mass){
                    tmp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
    
    public void pack(){
        int number = 0;
        while (number < elements.length){
            int cartI = 0, cartJ = 0, cartK = 0;
            int h = elements[number].height;
            int d = elements[number].depth;
            int w = elements[number].width;
            boolean end = false;
            for (int i = 0; i < contHeight; i++){
                for (int j = 0; j < contDepth; j++){
                    for (int k = 0; k < contWidth; k++){
                        // if the coordinate is empty
                        if (container[i][j][k] == 0){
                            int tmp = 1;
                            while (tmp <= 6){
                                switch(tmp){
                                    case 1:
                                        elements[number].height = h;
                                        elements[number].depth = d;
                                        elements[number].width = w;
                                        break;
                                    case 2:
                                        elements[number].height = h;
                                        elements[number].depth = w;
                                        elements[number].width = d;
                                        break;
                                    case 3:
                                        elements[number].height = d;
                                        elements[number].depth = h;
                                        elements[number].width = w;
                                        break;
                                    case 4:
                                        elements[number].height = d;
                                        elements[number].depth = w;
                                        elements[number].width = h;
                                        break;
                                    case 5:
                                        elements[number].height = w;
                                        elements[number].depth = h;
                                        elements[number].width = d;
                                        break;
                                    case 6:
                                        elements[number].height = w;
                                        elements[number].depth = d;
                                        elements[number].width = h;
                                        break;
                                }
                                boolean fit = true;
                                // if we place element in this coordinate, does it fit fully?
                                if (i + elements[number].height > contHeight 
                                        || j + elements[number].depth > contDepth
                                        || k + elements[number].width > contWidth)
                                    fit = false;
                                // does it fit in height?
                                if (fit != false)
                                    for (int t = i; t < i + elements[number].height; t++) 
                                        if (container[t][j][k] != 0){fit = false; break;}
                                // does it fit in depth?
                                if (fit != false)
                                    for (int t = j; t < j + elements[number].depth; t++) 
                                        if (container[i][t][k] != 0){fit = false; break;}
                                // does it fit in width?
                                if (fit != false)
                                    for (int t = k; t < k + elements[number].width; t++) 
                                        if (container[i][j][t] != 0){fit = false; break;}
                                // if it's OK, the coordinate is for this element
                                if (fit != false) {
                                    cartI = i;
                                    cartJ = j;
                                    cartK = k;
                                    end = true;
                                }
                                if (end) break;
                                tmp++;
                            }
                        }
                        if (end == true) break;
                    }
                    if (end == true) break;
                }
                if (end == true) break;
            }
            if (container[cartI][cartJ][cartK] == 0) {
                //set the coordinate
                elements[number].y = contHeight / 2 - (cartI + elements[number].height/ 2);
                elements[number].z = contDepth / 2 - (cartJ + elements[number].depth / 2);
                elements[number].x = -(contWidth / 2) + cartK + elements[number].width / 2;
                // fill the array
                for (int i = 0; i < elements[number].height; i++)
                    for (int j = 0; j < elements[number].depth; j++)
                        for (int k = 0; k < elements[number].width; k++)
                            container[cartI + i][cartJ + j][cartK + k] = number + 1;
            }
            number++; 
        }
    }
    
    public Box[] draw(){
        Box[] boxes = new Box[elements.length];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].x != 1000000 && elements[i].y != 1000000 && elements[i].z != 1000000){
                Box box = new Box(elements[i].width, elements[i].height, elements[i].depth); 
                switch (elements[i].colour){
                    case "красный": box.setMaterial(new PhongMaterial(Color.RED)); break;
                    case "оранжевый": box.setMaterial(new PhongMaterial(Color.ORANGE)); break;
                    case "желтый": box.setMaterial(new PhongMaterial(Color.YELLOWGREEN)); break;
                    case "зеленый": box.setMaterial(new PhongMaterial(Color.GREEN)); break;
                    case "светло-зеленый": box.setMaterial(new PhongMaterial(Color.LIGHTGREEN)); break;
                    case "голубой": box.setMaterial(new PhongMaterial(Color.BLUE)); break;
                    case "светло-голубой": box.setMaterial(new PhongMaterial(Color.AQUA)); break;
                    case "синий": box.setMaterial(new PhongMaterial(Color.DARKBLUE)); break;
                    case "розовый": box.setMaterial(new PhongMaterial(Color.MAGENTA)); break;
                    case "светло-розовый": box.setMaterial(new PhongMaterial(Color.PINK)); break;
                    case "малиновый": box.setMaterial(new PhongMaterial(Color.CRIMSON)); break;
                    case "фиолетовый": box.setMaterial(new PhongMaterial(Color.BLUEVIOLET)); break;
                    case "коричневый": box.setMaterial(new PhongMaterial(Color.BROWN)); break;
                    case "светло-коричневый": box.setMaterial(new PhongMaterial(Color.CHOCOLATE)); break;
                    case "серый": box.setMaterial(new PhongMaterial(Color.GRAY)); break;
                    case "черный": box.setMaterial(new PhongMaterial(Color.BLACK)); break;
                }
                box.setTranslateX(elements[i].x);
                box.setTranslateY(elements[i].y);
                box.setTranslateZ(elements[i].z);
                box.setDrawMode(DrawMode.FILL);
                boxes[i] = box;
            }
        }
        return boxes;
    }
}