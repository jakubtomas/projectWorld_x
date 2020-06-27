package Martin;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {

    public TextField num1;
    public TextField num2;
    public Label result;
    public CheckBox show;
    public Label text;
    public TextField newText;
    public RadioButton small;
    public RadioButton big;
    public ColorPicker colorPicker;
    public Button exit;
    public static ChoiceBox<String> countryPicker;

    public void getSum(javafx.event.ActionEvent actionEvent) {



        float a = Float.parseFloat(num1.getText());
        float b = Float.parseFloat(num2.getText());

        String res = String.valueOf(a+b);
        result.setText(res);
    }

    public void showHide(ActionEvent actionEvent) {
        if (show.isSelected()){
            text.setVisible(true);
        }else{
            text.setVisible(false);
        }
    }

    public void changeText(ActionEvent actionEvent) {
        String nwTxt = newText.getText().trim();
        if (!nwTxt.equals("")){
            text.setText(nwTxt);
        }
    }

    public void changeSize(ActionEvent actionEvent) {
        if (small.isSelected()){
            text.setFont(Font.font(15));
        }else if (big.isSelected()){
            text.setFont(Font.font(20));
        }
    }

    public void pickColor(ActionEvent actionEvent) {
        text.setTextFill(colorPicker.getValue());
    }

    public void exitApp(ActionEvent actionEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void getPickedCountryCity(MouseEvent mouseEvent) {
        /*try{
            String COUNTRIES = "Select * from message order by id desc limit 10";

            PreparedStatement ps = Database.getConnection().prepareStatement(COUNTRIES);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String a = resultSet.getString(2);
                String b = resultSet.getString(3);
                String c = resultSet.getString(4);
                String d = resultSet.getString(5);
                System.out.println(name  + "  " + a  + "  "+ b + " " + "  " +  c +"  " + d);

            }
        }catch (Exception e){
            e.printStackTrace();
        }*/


        try {
            String COUNTRY = "select * from country limit 10 ";
            PreparedStatement stmt3 = Database.getConnection().prepareStatement(COUNTRY);
            ResultSet resultSet = stmt3.executeQuery();


            System.out.println(" to this okey ");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String a = resultSet.getString(2);
                String b = resultSet.getString(3);
                String c = resultSet.getString(4);
                // String d = resultSet.getString(5);
                System.out.println(name  + "  " + a  + "  "+ b + " " + "  " +  c +"  " );

//                Database.getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
