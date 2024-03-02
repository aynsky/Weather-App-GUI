package application;



import API.WeatherApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.WeatherData;

public class Controller {
	
	 @FXML
	 private Button btn;

    @FXML
    private Text displayText;

    @FXML
    private TextField cityTextField;
    
    @FXML
    private ImageView image1;
    
    @FXML
    private ImageView image2;
    
    @FXML
    private ImageView image3;
    
    @FXML
    private Pane pane;
    
    @FXML
    private Text text1;
    
    @FXML
    private Text text2;
    
    @FXML
    private Text text3;
    
    @FXML
    private Text textlocation;

    @FXML
    private Text textlocation1;
    
    @FXML
    private Text textHumidity;
    
    @FXML
    private Text textwindspeed;
    
    @FXML
    private Text displayins;
    
    @FXML
    private Text Errortext;

    // You need to set the scene either through injection or initialization
	    
	@SuppressWarnings("unused")
	private Scene scene;

    public void setScene(Scene scene) {
            this.scene = scene;
     }
    
    @FXML
    private void handleButtonClick(ActionEvent event) {
        // Get the text from the TextField
        String cityName = cityTextField.getText();

        // Assuming WeatherApi.getWeatherData returns a WeatherData object
        WeatherData weatherData = WeatherApi.getWeatherData(cityName);
        
        // Clear any existing error message
        Errortext.setText("");
        // Clear any existing  message
        text3.setText("");
     // Clear any existing  message
        text1.setText("");
     // Clear any existing  message
        text2.setText("");
     // Clear any existing  message
        textlocation1.setText("");
     // Clear any existing  message
        textHumidity.setText("");
     // Clear any existing  message
        textwindspeed.setText("");
        // You can now use the weatherData object as needed
        if (weatherData != null) {
            displayWeatherInfo(weatherData);
        } else {
        	Errortext.setText("Plz enter the valid city name !");
        }
    }
    
    @FXML
    private void onEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            // Trigger the button action when Enter key is pressed
            btn.fire();
        }
    }

    // Display weather information
    private void displayWeatherInfo(WeatherData weatherData) {
        StringBuilder weatherInfo = new StringBuilder();
        weatherInfo.append("").append(weatherData.getTimestamp()).append("\n\n");
        weatherInfo.append("").append(weatherData.getCity()).append("\n\n");
        weatherInfo.append("Temperature: ").append(weatherData.getTemperature()).append("°C\n\n");
        weatherInfo.append("Description: ").append(weatherData.getDescription()).append("\n\n");
        weatherInfo.append("Humidity: ").append(weatherData.getHumidity()).append("%\n\n");
        weatherInfo.append("Wind Speed: ").append(weatherData.getWindDirection()).append(" m/s\n");
        
     // Set the text of the displayText element
        //displayText.setText(weatherInfo.toString());
        
        /*try {
            Image image = new Image(getClass().getResourceAsStream("/images/location.png"));
            // Set the image to the ImageView
            image1.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (e.g., file not found)
        }
        
        try {
            Image image = new Image(getClass().getResourceAsStream("/images/humidity.png"));
            // Set the image to the ImageView
            image2.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (e.g., file not found)
        }
        
        try {
            Image image = new Image(getClass().getResourceAsStream("/images/windspeed.png"));
            // Set the image to the ImageView
            image3.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (e.g., file not found)
        }*/
        

        // Set the temperature value to text1
        text1.setText( weatherData.getTemperature() + "°");

        // Set the city value to text2
        text2.setText( weatherData.getDescription());
        
    
        // Set the date value to text2
        text3.setText( weatherData.getTimestamp().replace(" ", "\n"));
        
        // Set the Location value to textlocation1
        textlocation1.setText( weatherData.getCity());
        
     // Set the  value to humidity textHumidity
        textHumidity.setText(String.valueOf(weatherData.getHumidity()) + "%");
        
     // Set the windspeed value to textwindspeed
        textwindspeed.setText(String.valueOf(weatherData.getWindDirection()) + "m/s");
        
        
        
        
        
        
        
        
       // displayins.setText(" Please provide the city name \n for which you would like to get weather information.");
        
        

        
        
        
    }
}
