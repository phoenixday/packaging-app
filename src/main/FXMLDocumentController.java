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
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.util.Callback;
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
    private VBox specialisations;
    
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
    private AnchorPane drawPane;
    
    @FXML
    private Group group;
    
    @FXML
    private Box container;
    
    @FXML
    private Slider sliderX, sliderY;
    
    @FXML
    private Hyperlink link1, link2, link3; 
    
    @FXML
    private TextArea text;
    
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
        expirationdateGood.setCellValueFactory(
            new Callback<CellDataFeatures<Goods, Date>, ObservableValue<Date>>(){
            @Override
            public ObservableValue<Date> call(CellDataFeatures<Goods, Date> param){
                Goods g = param.getValue();
                DatePicker datePicker = new DatePicker();
                if (g.getExpirationDate() != null)
                    datePicker.setValue((g.getExpirationDate()).toLocalDate());
                datePicker.valueProperty().addListener((ov, old_val, new_val) -> {
                    g.setExpirationDate(java.sql.Date.valueOf(new_val));
                    d.updateGood(g);
                });
                return new SimpleObjectProperty(datePicker);
            }      
        });
        //stores
        idStore.setCellValueFactory(new PropertyValueFactory<>("idStore"));
        addressStore.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressStore.setCellFactory(TextFieldTableCell.<Stores>forTableColumn());
        sizeStore.setCellValueFactory(new PropertyValueFactory<>("size"));
        sizeStore.setCellFactory(ComboBoxTableCell.forTableColumn(sizes));
        universalStore.setCellValueFactory(
            new Callback<CellDataFeatures<Stores, Boolean>, ObservableValue<Boolean>>(){
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<Stores, Boolean> param){
                Stores s = param.getValue();
                CheckBox checkBox = new CheckBox();
                checkBox.selectedProperty().setValue(s.getUniversal());
                checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
                    s.setUniversal(new_val);
                    /*if (new_val) specialisations.setVisible(false);
                    else {
                        specialisations.setVisible(true);
                        List typesList = d.loadTypesList();
                        Iterator it = typesList.iterator();
                        while (it.hasNext()) {
                            CheckBox cb = new CheckBox();
                            List tmpList = d.loadStoreTypesList(s.getIdStore());
                            cb.setText(it.next().toString());
                            cb.selectedProperty().addListener((ov2, old_val2, new_val2) -> {
                                if 
                            });
                        }
                    }*/
                    System.out.println(s.getIdStore());
                    d.updateStore(s);
                });
                return new SimpleObjectProperty(checkBox);
            }      
        });
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
        //search
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
        goodsData.remove(selectedIndex);
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
        storesData.remove(selectedIndex);
    }
    
    public void changeGood(CellEditEvent t){
        int column = t.getTableView().getEditingCell().getColumn();
        switch(column){
            case 1: 
                if (t.getNewValue().toString().length() < 45)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue().toString());
                else {
                    AlertBox.display("Ошибка!", "Название не должно превышать 45 символов.");
                    goodsData.set(t.getTablePosition().getRow(), (Goods)t.getTableView().getItems().get(t.getTablePosition().getRow()));
                }
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
                if ((int) t.getNewValue() > 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setCount((int) t.getNewValue());
                else {
                    AlertBox.display("Ошибка!", "Количество должно быть большим, чем 0.");
                    goodsData.set(t.getTablePosition().getRow(), (Goods)t.getTableView().getItems().get(t.getTablePosition().getRow()));
                }
                break;
            case 4: 
                if ((int) t.getNewValue() >= 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdStore((int) t.getNewValue());
                break;
            case 5: 
                if ((double) t.getNewValue() > 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setMass((double) t.getNewValue());
                else {
                    AlertBox.display("Ошибка!", "Масса должна быть большей, чем 0.");
                    goodsData.set(t.getTablePosition().getRow(), (Goods)t.getTableView().getItems().get(t.getTablePosition().getRow()));
                }
                break;
            case 6: 
                if ((int) t.getNewValue() > 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setWidth((int) t.getNewValue());
                else {
                    AlertBox.display("Ошибка!", "Ширина должна быть большей, чем 0.");
                    goodsData.set(t.getTablePosition().getRow(), (Goods)t.getTableView().getItems().get(t.getTablePosition().getRow()));
                }
                break;
            case 7: 
                if ((int) t.getNewValue() > 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setLength((int) t.getNewValue());
                else {
                    AlertBox.display("Ошибка!", "Длина должна быть большей, чем 0.");
                    goodsData.set(t.getTablePosition().getRow(), (Goods)t.getTableView().getItems().get(t.getTablePosition().getRow()));
                }
                break;
            case 8: 
                if ((int) t.getNewValue() > 0)
                    ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setHeight((int) t.getNewValue());
                else {
                    AlertBox.display("Ошибка!", "Высота должна быть большей, чем 0.");
                    goodsData.set(t.getTablePosition().getRow(), (Goods)t.getTableView().getItems().get(t.getTablePosition().getRow()));
                }
                break;
            case 9: 
                ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setContainertypeName(t.getNewValue().toString());
                for(int i = 0; i < containertypes.size(); i++)
                    if (t.getNewValue().toString() == containertypes.get(i)){
                        ((Goods)t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdContainerType(i);
                        break;
                    }
                break;
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
        drawPane.setVisible(true);
        group.getChildren().clear();
        Box box = new Box(300, 300, 300);
        box.setDrawMode(DrawMode.LINE);
        group.getChildren().add(box);
        group.getChildren().addAll(Arrays.asList(logic.draw()));
    }
    
    public void setText(){
        link1.setVisited(true);
        text.setText(link1.getText() + "\n\n");
        text.appendText("Программа SimplePack помогает расчитать погрузку контейнеров и вести складской учет." + "\n" + "Чтобы посмотреть товары на складе, зайдите в пункт меню \"Склад\". Для загрузки контейнера зайдите в пункт меню \"Упаковка\".");
    }
    
    public void setText2(){
        link2.setVisited(true);
        text.setText(link2.getText() + "\n");
        text.appendText("Подробнее: http://www.mktu.info/goods/" + "\n\n");
        text.appendText("Класс 1\n" +
"Химические продукты, предназначенные для использования в промышленных, научных целях, в фотографии, сельском хозяйстве, садоводстве и лесоводстве; необработанные синтетические смолы, необработанные пластические материалы; удобрения; составы для тушения огня; препараты для закалки и пайки металлов; препараты для консервирования пищевых продуктов; дубильные вещества; клеящие вещества для промышленных целей.\n" +
"\n" +
"Класс 2\n" +
"Краски, олифы, лаки; защитные средства, предохраняющие металлы от коррозии и древесину от разрушения; красящие вещества; протравы; необработанные природные смолы; листовые и порошкообразные металлы, используемые для художественно-декоративных целей и художественной печати.\n" +
"\n" +
"Класс 3\n" +
"Препараты для отбеливания и прочие вещества для стирки; препараты для чистки, полирования, обезжиривания и абразивной обработки; мыла; парфюмерные изделия, эфирные масла, косметика, лосьоны для волос; зубные порошки и пасты.\n" +
"\n" +
"Класс 4\n" +
"Технические масла и смазки; смазочные материалы; составы для поглощения, смачивания и связывания пыли; топлива (в том числе моторные бензины) и осветительные материалы; фитили и свечи для освещения.\n" +
"\n" +
"Класс 5\n" +
"Фармацевтические и ветеринарные препараты; гигиенические препараты для медицинских целей; диетические вещества для медицинских целей, детское питание; пластыри, перевязочные материалы; материалы для пломбирования зубов и изготовления зубных слепков; дезинфицирующие средства; препараты для уничтожения вредных животных; фунгициды, гербициды.\n" +
"\n" +
"Класс 6\n" +
"Обычные металлы и их сплавы; металлические строительные материалы; передвижные металлические конструкции и сооружения; металлические материалы для рельсовых путей; металлические тросы и проволока [неэлектрические]; скобяные и замочные изделия; металлические трубы; сейфы; изделия из обычных металлов, не относящиеся к другим классам; руды.\n" +
"\n" +
"Класс 7\n" +
"Машины и станки; двигатели (за исключением предназначенных для наземных транспортных средств); соединения и элементы передач (за исключением предназначенных для наземных транспортных средств); сельскохозяйственные орудия, иные, чем орудия с ручным управлением; инкубаторы.\n" +
"\n" +
"Класс 8\n" +
"Ручные орудия и инструменты; ножевые изделия, вилки и ложки; холодное оружие; бритвы.\n" +
"\n" +
"Класс 9\n" +
"Приборы и инструменты научные, морские, геодезические, фотографические, кинематографические, оптические, для взвешивания, измерения, сигнализации, контроля (проверки), спасания и обучения; приборы и инструменты для передачи, распределения, трансформации, накопления, регулирования или управления электричеством; аппаратура для записи, передачи, воспроизведения звука или изображений; магнитные носители информации, диски звукозаписи; торговые автоматы и механизмы для аппаратов с предварительной оплатой; кассовые аппараты, счетные машины, оборудование для обработки информации и компьютеры; оборудование для тушения огня.\n" +
"\n" +
"Класс 10\n" +
"Приборы и инструменты хирургические, медицинские, стоматологические и ветеринарные; протезы конечностей, глазные и зубные протезы; ортопедические изделия; материалы для наложения швов.\n" +
"\n" +
"Класс 11\n" +
"Устройства для освещения, нагрева, получения пара, тепловой обработки пищевых продуктов, для охлаждения, сушки, вентиляции, водораспределительные и санитарно-технические.\n" +
"\n" +
"Класс 12\n" +
"Транспортные средства; аппараты, перемещающиеся по земле, воде и воздуху.\n" +
"\n" +
"Класс 13\n" +
"Огнестрельное оружие; боеприпасы и снаряды; взрывчатые вещества; фейерверки.\n" +
"\n" +
"Класс 14\n" +
"Благородные металлы и их сплавы, изделия или покрытия из них, не относящиеся к другим классам; ювелирные изделия, бижутерия, драгоценные камни; часы и прочие хронометрические приборы.\n" +
"\n" +
"Класс 15\n" +
"Музыкальные инструменты.\n" +
"\n" +
"Класс 16\n" +
"Бумага, картон и изделия из них, не относящиеся к другим классам; печатная продукция; материалы для переплетных работ; фотоснимки; писчебумажные товары; клейкие вещества для канцелярских и бытовых целей; принадлежности для художников; кисти; пишущие машины и конторские принадлежности (за исключением мебели); учебные материалы и наглядные пособия (за исключением аппаратуры); пластмассовые материалы для упаковки (не относящиеся к другим классам); шрифты; клише типографские.\n" +
"\n" +
"Класс 17\n" +
"Каучук, резина, гуттаперча, асбест, слюда и изделия из этих материалов, не относящиеся к другим классам; изделия из частично обработанных пластмасс; материалы для конопачения, уплотнения и изоляции; неметаллические гибкие трубы.\n" +
"\n" +
"Класс 18\n" +
"Кожа и имитация кожи, изделия из них, не относящиеся к другим классам; шкуры животных; дорожные сундуки, чемоданы; зонты от дождя и солнца, трости; хлысты, кнуты, конская сбруя и шорные изделия.\n" +
"\n" +
"Класс 19\n" +
"Неметаллические строительные материалы; неметаллические жесткие трубы для строительных целей; асфальт, смолы и битум; неметаллические передвижные конструкции и сооружения; неметаллические памятники.\n" +
"\n" +
"Класс 20\n" +
"Мебель, зеркала, обрамления для картин и тому подобное; изделия, не относящиеся к другим классам, из дерева, пробки, камыша, тростника, ивы, рога, кости, слоновой кости, китового уса, панциря черепах, раковин, янтаря, перламутра, морской пенки, из заменителей этих материалов или из пластмасс.\n" +
"\n" +
"Класс 21\n" +
"Домашняя или кухонная утварь и посуда; расчески и губки; щетки (за исключением кистей); материалы для щеточных изделий; приспособления для чистки и уборки; мочалки металлические; необработанное или частично обработанное стекло (за исключением строительного стекла); изделия из стекла, фарфора и фаянса, не относящиеся к другим классам.\n" +
"\n" +
"Класс 22\n" +
"Канаты, веревки, бечевки, сети, палатки, навесы, брезент, паруса и мешки, не относящиеся к другим классам; набивочные материалы (за исключением из резиновых и пластических материалов); текстильное волокнистое сырье.\n" +
"\n" +
"Класс 23\n" +
"Нити текстильные и пряжа.\n" +
"\n" +
"Класс 24\n" +
"Ткани и текстильные изделия, не относящиеся к другим классам; одеяла, покрывала и скатерти.\n" +
"\n" +
"Класс 25\n" +
"Одежда, обувь, головные уборы.\n" +
"\n" +
"Класс 26\n" +
"Кружева и вышитые изделия, тесьма и ленты; пуговицы, кнопки, крючки и блочки, булавки и иглы; искусственные цветы.\n" +
"\n" +
"Класс 27\n" +
"Ковры, циновки, маты, линолеум и прочие покрытия для полов; стенные обои и обивочные материалы, нетекстильные.\n" +
"\n" +
"Класс 28\n" +
"Игры, игрушки; гимнастические и спортивные товары, не относящиеся к другим классам; елочные украшения.\n" +
"\n" +
"Класс 29\n" +
"Мясо, рыба, птица и дичь; мясные экстракты; овощи и фрукты консервированные, сушеные и подвергнутые тепловой обработке; желе, варенье, компоты; яйца, молоко и молочные продукты; масла и жиры пищевые.\n" +
"\n" +
"Класс 30\n" +
"Кофе, чай, какао, сахар, рис, тапиока (маниока), саго, заменители кофе; мука и зерновые продукты, хлебобулочные изделия, кондитерские изделия, мороженое; мед, сироп из патоки; дрожжи, пекарные порошки; соль, горчица; уксус, приправы; пряности; пищевой лед.\n" +
"\n" +
"Класс 31\n" +
"Сельскохозяйственные, садово-огородные, лесные и зерновые продукты, не относящиеся к другим классам; живые животные; свежие фрукты и овощи; семена, живые растения и цветы; корма для животных; солод.\n" +
"\n" +
"Класс 32\n" +
"Пиво; минеральные и газированные воды и прочие безалкогольные напитки; фруктовые напитки и фруктовые соки; сиропы и прочие составы для изготовления напитков.\n" +
"\n" +
"Класс 33\n" +
"Алкогольные напитки (за исключением пива).\n" +
"\n" +
"Класс 34\n" +
"Табак; курительные принадлежности; спички.");
    }
    
    public void setText3(){
        link3.setVisited(true);
        text.setText(link3.getText() + "\n\n");
        text.appendText("Контейнер — основная единица перевозки или хранения, используемая в транспортной логистике. Контейнеры изготавливают из различных материалов и форм, однако наибольшее распространение получили универсальные контейнеры.");
    }
}