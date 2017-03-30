/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import java.util.Date;
import java.util.Iterator;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.converter.DateStringConverter;
/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    private Data d = new Data();
    
    private String[] types;
    
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Goods> goodsView;
    
    @FXML
    private TableColumn<Goods, Integer> idGood;
    
    @FXML
    private TableColumn<Goods, String> nameGood;
    
    @FXML
    private TableColumn<Goods, Integer> typeGood;
    
    @FXML
    private TableColumn<Goods, Integer> countGood;
    
    @FXML
    private TableColumn<Goods, Integer> idStoreGood;
    
    @FXML
    private TableColumn<Goods, Double> massGood;
    
    @FXML
    private TableColumn<Goods, Double> widthGood;
    
    @FXML
    private TableColumn<Goods, Double> lengthGood;
    
    @FXML
    private TableColumn<Goods, Double> heightGood;
    
    @FXML
    private TableColumn<Goods, Integer> containertypeGood;
    
    @FXML
    private TableColumn<Goods, Date> expirationdateGood;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idGood.setCellValueFactory(new PropertyValueFactory<>("idGood"));
        nameGood.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameGood.setCellFactory(TextFieldTableCell.<Goods>forTableColumn());
        typeGood.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        countGood.setCellValueFactory(new PropertyValueFactory<>("count"));
        countGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        idStoreGood.setCellValueFactory(new PropertyValueFactory<>("idStore"));
        idStoreGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        massGood.setCellValueFactory(new PropertyValueFactory<>("mass"));
        massGood.setCellFactory(TextFieldTableCell.<Goods, Double>forTableColumn(new DoubleStringConverter()));
        widthGood.setCellValueFactory(new PropertyValueFactory<>("width"));
        widthGood.setCellFactory(TextFieldTableCell.<Goods, Double>forTableColumn(new DoubleStringConverter()));
        lengthGood.setCellValueFactory(new PropertyValueFactory<>("length"));
        lengthGood.setCellFactory(TextFieldTableCell.<Goods, Double>forTableColumn(new DoubleStringConverter()));
        heightGood.setCellValueFactory(new PropertyValueFactory<>("height"));
        heightGood.setCellFactory(TextFieldTableCell.<Goods, Double>forTableColumn(new DoubleStringConverter()));
        containertypeGood.setCellValueFactory(new PropertyValueFactory<>("idContainerType"));
        containertypeGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        expirationdateGood.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        expirationdateGood.setCellFactory(TextFieldTableCell.<Goods, Date>forTableColumn(new DateStringConverter()));
        
        initData();
        goodsView.setItems(goodsData);
    }    
    
    public void initData(){
        /*List typesList = d.loadTypesList();
        types = new String[typesList.size()]; 
        int i = 1;
        Iterator<Types> it2 = typesList.iterator();
	while (it2.hasNext()) types[i++] = it2.next().getType();*/
        List goodsList = d.loadGoodsList();
        Iterator<Goods> it = goodsList.iterator();
	while (it.hasNext()) {
            goodsData.add(it.next());
        }
    }
}
