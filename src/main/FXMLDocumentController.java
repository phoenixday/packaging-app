/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DateStringConverter;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    private final Data d = new Data();
    
    private final ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    private final ObservableList<Goods> gD = FXCollections.observableArrayList();
    private final ObservableList<Stores> storesData = FXCollections.observableArrayList();
    private final ObservableList types = FXCollections.observableArrayList();
    private final ObservableList containertypes = FXCollections.observableArrayList();
    private final ObservableList sizes = FXCollections.observableArrayList(600, 800, 1000, 1250, 2500, 5000, 7500, 10000, 25000);
    
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
    private TableColumn<Goods, Integer> widthGood;
    
    @FXML
    private TableColumn<Goods, Integer> lengthGood;
    
    @FXML
    private TableColumn<Goods, Integer> heightGood;
    
    @FXML
    private TableColumn<Goods, Integer> containertypeGood;
    
    @FXML
    private TableColumn<Goods, Date> expirationdateGood;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private Button addGood, deleteGood, exportGoods;
    
    @FXML
    private ChoiceBox containertypescombo;
    
    @FXML
    private ListView containersList;
    
    @FXML
    private TableView<Listofgoods> goodsView2;
    
    @FXML
    private TableColumn<Listofgoods, Integer> idGood2;
    
    @FXML
    private TableColumn<Goods, String> nameGood2;
    
    @FXML
    private TableColumn<Listofgoods, Integer> countGood2;
    
    @FXML 
    private TableView<Stores> storesView;
    
    @FXML
    private TableColumn<Stores, Integer> idStore;
    
    @FXML
    private TableColumn<Stores, String> addressStore;
    
    @FXML
    private TableColumn<Stores, Integer> sizeStore;
    
    @FXML
    private TableColumn<Stores, Boolean> universalStore;
    
    @FXML
    private TableColumn<Stores, Integer> typesStore;
    
    @FXML
    private TableView<Goods> goodsView3;
    
    @FXML
    private TableColumn<Goods, Integer> idGood3;
    
    @FXML
    private TableColumn<Goods, String> nameGood3;
    
    @FXML
    private TableColumn<Goods, Integer> typeGood3;
    
    @FXML
    private TableColumn<Goods, Integer> countGood3;
    
    @FXML
    private TableColumn<Goods, Integer> idStoreGood3;
    
    @FXML
    private TableColumn<Goods, Double> massGood3;
    
    @FXML
    private TableColumn<Goods, Integer> widthGood3;
    
    @FXML
    private TableColumn<Goods, Integer> lengthGood3;
    
    @FXML
    private TableColumn<Goods, Integer> heightGood3;
    
    @FXML
    private TableColumn<Goods, Integer> containertypeGood3;
    
    @FXML
    private TableColumn<Goods, Date> expirationdateGood3;
    
    @FXML
    private ChoiceBox colour;
    
    @FXML
    private TextField count;
    
    @FXML
    private Button add, delete;
    
    @FXML
    private ListView goodsList;
    
    @FXML
    private CheckBox choice;
    
    @FXML
    private ListView containersList2;
    
    @FXML
    private ComboBox containerscombo;
    
    @FXML
    private Button add2, delete2;
    
    @FXML
    private Group group;
    
    @FXML
    private Box container;
    
    @FXML
    private Slider sliderX, sliderY;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // goods
        idGood.setCellValueFactory(new PropertyValueFactory<>("idGood"));
        nameGood.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameGood.setCellFactory(TextFieldTableCell.<Goods>forTableColumn());
        typeGood.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        typeGood.setCellFactory(ComboBoxTableCell.forTableColumn(types));
        countGood.setCellValueFactory(new PropertyValueFactory<>("count"));
        countGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        idStoreGood.setCellValueFactory(new PropertyValueFactory<>("idStore"));
        idStoreGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        massGood.setCellValueFactory(new PropertyValueFactory<>("mass"));
        massGood.setCellFactory(TextFieldTableCell.<Goods, Double>forTableColumn(new DoubleStringConverter()));
        widthGood.setCellValueFactory(new PropertyValueFactory<>("width"));
        widthGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        lengthGood.setCellValueFactory(new PropertyValueFactory<>("length"));
        lengthGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        heightGood.setCellValueFactory(new PropertyValueFactory<>("height"));
        heightGood.setCellFactory(TextFieldTableCell.<Goods, Integer>forTableColumn(new IntegerStringConverter()));
        containertypeGood.setCellValueFactory(new PropertyValueFactory<>("containertypeName"));
        containertypeGood.setCellFactory(ComboBoxTableCell.forTableColumn(containertypes));
        expirationdateGood.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        expirationdateGood.setCellFactory(TextFieldTableCell.<Goods, Date>forTableColumn(new DateStringConverter()));
        //stores
        idStore.setCellValueFactory(new PropertyValueFactory<>("idStore"));
        addressStore.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressStore.setCellFactory(TextFieldTableCell.<Stores>forTableColumn());
        sizeStore.setCellValueFactory(new PropertyValueFactory<>("size"));
        sizeStore.setCellFactory(ComboBoxTableCell.forTableColumn(sizes));
        universalStore.setCellValueFactory(new PropertyValueFactory<>("universal"));
        universalStore.setCellFactory(TextFieldTableCell.<Stores, Boolean>forTableColumn(new BooleanStringConverter()));
        typesStore.setCellValueFactory(new PropertyValueFactory<>("idListoftypes"));
        typesStore.setCellFactory(TextFieldTableCell.<Stores, Integer>forTableColumn(new IntegerStringConverter()));
        //goods2
        idGood2.setCellValueFactory(new PropertyValueFactory<>("idGood"));
        nameGood2.setCellValueFactory(new PropertyValueFactory<>("name"));
        countGood2.setCellValueFactory(new PropertyValueFactory<>("count"));
        //goods3
        idGood3.setCellValueFactory(new PropertyValueFactory<>("idGood"));
        nameGood3.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeGood3.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        countGood3.setCellValueFactory(new PropertyValueFactory<>("count"));
        idStoreGood3.setCellValueFactory(new PropertyValueFactory<>("idStore"));
        massGood3.setCellValueFactory(new PropertyValueFactory<>("mass"));
        widthGood3.setCellValueFactory(new PropertyValueFactory<>("width"));
        lengthGood3.setCellValueFactory(new PropertyValueFactory<>("length"));
        heightGood3.setCellValueFactory(new PropertyValueFactory<>("height"));
        containertypeGood3.setCellValueFactory(new PropertyValueFactory<>("containertypeName"));
        expirationdateGood3.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        
        initData();
        goodsView.setItems(goodsData);
        goodsView3.setItems(gD);
        containertypescombo.getItems().addAll(containertypes);
        containertypescombo.setValue(containertypes.get(0));
        storesView.setItems(storesData);
        
        colour.getItems().addAll(
            "красный",
            "оранжевый",
            "желтый",
            "зеленый",
            "светло-зеленый",
            "голубой",
            "светло-голубой",
            "синий",
            "розовый", 
            "светло-розовый",
            "малиновый",
            "фиолетовый",
            "коричневый",
            "светло-коричневый",
            "серый",
            "черный"
        );
        colour.setValue("красный");
 
        FilteredList<Goods> filteredData = new FilteredList<>(goodsData);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(good -> {
                if (newValue == null || newValue.isEmpty()) {
                    addGood.setVisible(true);
                    deleteGood.setVisible(true);
                    exportGoods.setVisible(true);
                    return true;
                }
                addGood.setVisible(false);
                deleteGood.setVisible(false);
                exportGoods.setVisible(false);
                String lowerCaseFilter = newValue.toLowerCase();
                if (good.getName().toLowerCase().contains(lowerCaseFilter))
                    return true;
                else if (good.getTypeName().toLowerCase().contains(lowerCaseFilter))
                    return true;
                return false;
            });
        });
        SortedList<Goods> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(goodsView.comparatorProperty());
        goodsView.setItems(sortedData);
    }
    
    public void initData(){
        List typesList = d.loadTypesList();
        Iterator it3 = typesList.iterator();
	while (it3.hasNext()) types.add(it3.next());
        List containertypesList = d.loadContainertypesList();
        Iterator it4 = containertypesList.iterator();
	while (it4.hasNext()) containertypes.add(it4.next());
        List g = d.loadGoodsList();
        Iterator<Goods> it = g.iterator();
	while (it.hasNext()) {
            Goods tmp = it.next();
            tmp.setTypeName(types.get(tmp.getType()).toString());
            tmp.setContainertypeName(containertypes.get(tmp.getIdContainerType()).toString());
            goodsData.add(tmp);
            gD.add(tmp);
        }
        List storesList = d.loadStoresList();
        Iterator<Stores> it2 = storesList.iterator();
	while (it2.hasNext()) storesData.add(it2.next());
        List containersListt = d.loadContainersList();
        Iterator<Containers> it5 = containersListt.iterator();
	while (it5.hasNext()) {
            Containers tmp = it5.next();
            tmp.setContainertypeName(containertypes.get(tmp.getIdContainertype() - 1).toString());
            String s = tmp.getIdContainer() + "-ый, " + tmp.getContainertypeName();
            if (tmp.getFree() == true) s += ", свободный";
            containersList.getItems().add(s);
        }
    }
    
    public void addGood(){
        Goods g = new Goods(goodsData.size() + 1, "Новый товар", 1, 1, 1, 1, 1, 1, 1, 1, null, "");
        g.setTypeName(types.get(g.getType()).toString());
        g.setContainertypeName(containertypes.get(g.getIdContainerType()).toString());
        goodsData.add(g);
        d.addGood(g);
    }
    
    public void addContainer(){
        Containers c = new Containers(containersList.getItems().size() + 1, 1, true);
        c.setContainertypeName(containertypescombo.getValue().toString());
        for(int i = 0; i < containertypes.size(); i++)
            if (containertypes.get(i) == containertypescombo.getValue().toString()){
                c.setIdContainertype(i + 1);
                break;
            }
        containersList.getItems().add(d.addContainer(c) + "-ый, " + c.getContainertypeName());
    }
    
    public void addStore(){
        Stores s = new Stores(storesData.size() + 1, "", 600, true, 0);
        storesData.add(s);
        d.addStore(s);
    }
    
    public void deleteGood(){
        int selectedIndex = goodsView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) return;
        d.deleteGood(goodsData.get(selectedIndex).getIdGood());
        goodsView.getItems().remove(selectedIndex);
    }
    
    public void deleteContainer(){
        int selectedIndex = containersList.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) return;
        d.deleteContainer(Integer.valueOf(containersList.getItems().get(selectedIndex).toString().split("-")[0]));
        containersList.getItems().remove(selectedIndex);
    }
    
    public void deleteStore(){
        int selectedIndex = storesView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) return;
        d.deleteStore(storesData.get(selectedIndex).getIdStore());
        storesView.getItems().remove(selectedIndex);
    }
    
    public void changeGood(CellEditEvent t){
        int column = t.getTableView().getEditingCell().getColumn();
        switch(column){
            case 1: 
                ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue().toString());
                break;
            case 2:
                ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setTypeName(t.getNewValue().toString());
                for(int i = 0; i < types.size(); i++)
                    if (t.getNewValue().toString() == types.get(i)){
                        ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setType(i);
                        break;
                    }    
                break;
            case 3: 
                if ((int) t.getNewValue() >= 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setCount((int) t.getNewValue());
                break;
            case 4: 
                if ((int) t.getNewValue() >= 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdStore((int) t.getNewValue());
                break;
            case 5: 
                if ((double) t.getNewValue() >= 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setMass((double) t.getNewValue());
                break;
            case 6: 
                if ((double) t.getNewValue() >= 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setWidth((int) t.getNewValue());
                break;
            case 7: 
                if ((double) t.getNewValue() >= 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setLength((int) t.getNewValue());
                break;
            case 8: 
                if ((double) t.getNewValue() >= 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setHeight((int) t.getNewValue());
                break;
            case 9: 
                ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setContainertypeName(t.getNewValue().toString());
                for(int i = 0; i < containertypes.size(); i++)
                    if (t.getNewValue().toString() == containertypes.get(i)){
                        ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdContainerType(i);
                        break;
                    }
                break;
            case 10:
                ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setExpirationDate((Date) t.getNewValue());
        
        }
        d.updateGood((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow()));
    }
    
    public void changeStore(CellEditEvent t){
        int column = t.getTableView().getEditingCell().getColumn();
        switch(column){
            case 1: 
                ((Stores)t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue().toString());
                break;
            case 2:
                ((Stores)t.getTableView().getItems().get(t.getTablePosition().getRow())).setSize((int) t.getNewValue());    
                break;
            case 3: 
                //if ((int) t.getNewValue() >= 0)
                ((Stores)t.getTableView().getItems().get(t.getTablePosition().getRow())).setUniversal((boolean) t.getNewValue());
                break;
        }
        d.updateStore((Stores)t.getTableView().getItems().get(t.getTablePosition().getRow()));
    }
    
    public void getGoods(){
        int number = Integer.valueOf(containersList.getSelectionModel().getSelectedItem().toString().split("-")[0]);
        ObservableList<Listofgoods> data = FXCollections.observableArrayList();
        List l = d.loadListofgoods(number);
        Iterator<Listofgoods> it = l.iterator();
	while (it.hasNext()) { 
            data.add(it.next());
        }
        goodsView2.setItems(data);
    }
    
    public void exportGoods() throws FileNotFoundException, IOException{
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Сохранить файл");
        if (ret == JFileChooser.APPROVE_OPTION){
            File file = fileopen.getSelectedFile();
            Workbook book = new HSSFWorkbook();
            parseGoods(book);
            FileOutputStream out = new FileOutputStream(file);
            book.write(out);
            out.close();
        }
    }
    
    public void exportStores() throws FileNotFoundException, IOException{
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Сохранить файл");
        if (ret == JFileChooser.APPROVE_OPTION){
            File file = fileopen.getSelectedFile();
            Workbook book = new HSSFWorkbook();
            parseStores(book);
            FileOutputStream out = new FileOutputStream(file);
            book.write(out);
            out.close();
        }
    }
    
    public void exportAll() throws FileNotFoundException, IOException{
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Сохранить файл");
        if (ret == JFileChooser.APPROVE_OPTION){
            File file = fileopen.getSelectedFile();
            Workbook book = new HSSFWorkbook();
            parseGoods(book);
            parseStores(book);
            FileOutputStream out = new FileOutputStream(file);
            book.write(out);
            out.close();
        }
    }
    
    public void parseGoods(Workbook book){
        Sheet sheet = book.createSheet("Goods");
        for(int i = 0; i < goodsData.size(); i++){
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(goodsData.get(i).getIdGood());
            row.createCell(1).setCellValue(goodsData.get(i).getName());
            row.createCell(2).setCellValue(goodsData.get(i).getTypeName());
            row.createCell(3).setCellValue(goodsData.get(i).getCount());
            row.createCell(4).setCellValue(goodsData.get(i).getMass());
            row.createCell(5).setCellValue(goodsData.get(i).getWidth());
            row.createCell(6).setCellValue(goodsData.get(i).getLength());
            row.createCell(7).setCellValue(goodsData.get(i).getHeight());
            row.createCell(8).setCellValue(goodsData.get(i).getContainertypeName());
        }
        sheet.autoSizeColumn(1);
    }
    
    public void parseStores(Workbook book){
        Sheet sheet = book.createSheet("Stores");
        for(int i = 0; i < storesData.size(); i++){
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(storesData.get(i).getIdStore());
            row.createCell(1).setCellValue(storesData.get(i).getAddress());
            row.createCell(2).setCellValue(storesData.get(i).getSize());
        }
        sheet.autoSizeColumn(1);
    }
    
    public void showCount(){
        count.setDisable(false);
        colour.setDisable(false);
        count.setText(String.valueOf(gD.get(goodsView3.getSelectionModel().getSelectedIndex()).getCount()));
        add.setDisable(false);
        delete.setDisable(true);
    }
    
    public void add(){
        if (goodsView3.getSelectionModel().getSelectedIndex() == -1) return;
        if (Integer.valueOf(count.getText()) < 1 ||
            Integer.valueOf(count.getText()) > gD.get(goodsView3.getSelectionModel().getSelectedIndex()).getCount())
            return;
        Goods tmp = gD.get(goodsView3.getSelectionModel().getSelectedIndex());
        goodsList.getItems().add(tmp.getName() + ", " + count.getText() + " шт., " 
                + tmp.getMass() + " кг, " + tmp.getWidth() + "x" + tmp.getLength() 
                + "x" + tmp.getHeight() + ", " + tmp.getContainertypeName() + ", " + colour.getValue());
        gD.remove(goodsView3.getSelectionModel().getSelectedIndex());
    }
    
    public void change(){
        count.setDisable(true);
        colour.setDisable(true);
        add.setDisable(true);
        delete.setDisable(false);
    }
    
    public void delete(){
        if (goodsList.getSelectionModel().getSelectedIndex() == -1) return;
        goodsList.getItems().remove(goodsList.getSelectionModel().getSelectedIndex());
        List g = d.loadGoodsList();
        Iterator<Goods> it = g.iterator();
        gD.clear();
	while (it.hasNext()){
            Goods tmp = it.next();
            tmp.setTypeName(types.get(tmp.getType()).toString());
            tmp.setContainertypeName(containertypes.get(tmp.getIdContainerType()).toString());
            boolean b = true;
            for (int i = 0; i < goodsList.getItems().size(); i++){
                if (tmp.getName().equals(goodsList.getItems().get(i).toString().split(",")[0])){
                    b = false;
                    break;
                }
            }
            if (b) gD.add(tmp);
        }
        goodsView3.setItems(gD);
    }
    
    public void autoadd(){
        if (choice.isSelected()) {
            containerscombo.setDisable(true);
            add2.setDisable(true);
            delete2.setDisable(true);
            containerscombo.getItems().clear();
            return;
        }
        containerscombo.setDisable(false);
        add2.setDisable(false);
        delete2.setDisable(false);
        for(int i = 0; i < containersList.getItems().size(); i++){
            if (containersList.getItems().get(i).toString().split(", ").length == 3)
                containerscombo.getItems().add(containersList.getItems().get(i));
        }
        containerscombo.setValue(containerscombo.getItems().get(0));
    }
    
    public void add2(){
        if (containerscombo.getItems().isEmpty()) return;
        containersList2.getItems().add(containerscombo.getValue());
        containerscombo.getItems().remove(containerscombo.getValue());
        containerscombo.setValue(containerscombo.getItems().get(0));
    }
    
    public void delete2(){
        if (containersList2.getSelectionModel().getSelectedIndex() == -1) return;
        containerscombo.getItems().add(containersList2.getItems().get(containersList2.getSelectionModel().getSelectedIndex()));
        containersList2.getItems().remove(containersList2.getSelectionModel().getSelectedIndex());
    }
    
    public void clickX(){
        group.setRotationAxis(Rotate.X_AXIS);
        group.rotateProperty().bind(sliderX.valueProperty());
    }
    
    public void clickY(){
        group.setRotationAxis(Rotate.Y_AXIS);
        group.rotateProperty().bind(sliderY.valueProperty());
    }
    
    public void calculate(){
        Logic logic = new Logic();
        logic.start(goodsList.getItems());
        group.getChildren().addAll(Arrays.asList(logic.draw()));
    }
}